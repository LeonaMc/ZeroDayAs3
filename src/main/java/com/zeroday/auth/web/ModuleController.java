package com.zeroday.auth.web;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.zeroday.auth.service.GradeService;
import com.zeroday.auth.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeroday.auth.exception.ModuleNotFoundException;
import com.zeroday.auth.model.Grade;
import com.zeroday.auth.model.Module;
import com.zeroday.auth.model.User;
import com.zeroday.auth.repository.GradeRepository;
import com.zeroday.auth.repository.ModuleRepository;
import com.zeroday.auth.repository.UserRepository;
import com.zeroday.auth.service.SecurityService;
import com.zeroday.auth.validator.UserValidatorRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    private ModuleService moduleService;

    @Autowired
    private UserValidatorRegistration userValidatorRegistration;

    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    private GradeService gradeService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    public Logger logger = LoggerFactory.getLogger(ModuleController.class);
    @RequestMapping({ "/list" })
    @Secured({"ROLE_STAFF", "ROLE_ADMIN"})
    public String viewHomePage(Model model) {
        List<Module> listModules = moduleService.findAllByCurrentUser();
        model.addAttribute("listModules", listModules);
        return "staffWelcome";
    }

    @GetMapping({ "/staffWelcome" })
    public String staffWelcome(Model model) {
        return "staffWelcome";
    }

    // Delete a Note
    @RequestMapping("/delete/{id}")
    public String deleteModule(@PathVariable(value = "id") Long moduleId, Model model) throws ModuleNotFoundException {
        Module module = moduleRepository.findById(moduleId).orElseThrow(() -> new ModuleNotFoundException(moduleId));
        moduleRepository.delete(module);
        logger.debug("Module " + module.getModule_name() + " has been removed.");
        return viewHomePage(model);
    }

    // Create a new Note
    @RequestMapping("/new")
    public String createModule() {
        return "moduleform";
    }

    // Create a new Note
    @PostMapping("/modules")
    public String createNote(@ModelAttribute("module") Module module, Model model) {
        moduleRepository.save(module);
        logger.debug("Module " + module.getModule_name() + " created.");
        return viewHomePage(model);
    }

    // Update a Note
    @RequestMapping(value = "staffWelcome", method = RequestMethod.POST)
    @Secured({"ROLE_STAFF", "ROLE_ADMIN"})
    public String updateNote(@ModelAttribute("module") Module module, Model model) throws ModuleNotFoundException {
        moduleService.save(module);
        logger.debug("Information for module " + module.getModule_name() + " has been modified.");

        return viewHomePage(model);
    }

    // Get a Single Note
    @GetMapping("/modules/{id}")
    public String getNoteById(@PathVariable(value = "id") Long moduleId, Model model)
            throws ModuleNotFoundException {
        Module module = moduleRepository.findById(moduleId).orElseThrow(() -> new ModuleNotFoundException(moduleId));
        model.addAttribute("module", module);

        return "editform";
    }

    // Create a new Note
    @RequestMapping("/newgrade")
    public String createGrade() {
        return "newgrade";
    }

    // Create a new Note
    @RequestMapping("/listgrades")
    public String listGrades(Model model) {
        List<Grade> listGrades = gradeService.findAllByCurrentUser();
        model.addAttribute("listGrades", listGrades);
        return "listgrades";
    }

    // Create a new Note
    @RequestMapping("/newEnrolModule")
    public String enrolModule() {
        return "moduleEnrolment";
    }

    @RequestMapping({ "/listAllEnroledModules" })
    public String listAllEnroledModules(Model model) {
        List<Module> listModules = moduleRepository.findAll();
        model.addAttribute("listModules", listModules);
        String username = securityService.findLoggedInUsername();
        model.addAttribute("connectedUser", userRepository.findByUsername(username));
        return "moduleEnrolment";
    }

    @RequestMapping({ "/listActiveEnrolledModules" })
    public String listAEnrolledModules(Model model) {
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        Set<Module> listEnrolledModules = user.getModules();
        model.addAttribute("listEnrolledModules", listEnrolledModules);
        return "moduleEnrolmentActive";
    }

    @GetMapping("/modules/enroll/{moduleId}")
    public String enroll(@PathVariable(value = "moduleId") Long moduleId, Model model) {
        Module module = moduleRepository.getOne(moduleId);
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        if (!module.getUsers().contains(user)) {
            module.getUsers().add(user);
            moduleRepository.save(module);
            user.getModules().add(module);
            userRepository.save(user);
            logger.debug("Student " + user.getFirstName() + " " + user.getLastName() + "identified by username " + username + " has registered to the module " + module.getModule_name() + ".");
        }
        model.addAttribute("listEnrolledModules", moduleRepository.findAll());
        return "moduleEnrolment";
    }

    @GetMapping("/modules/cancel/{moduleId}")
    public String cancel(@PathVariable(value = "moduleId") Long moduleId, Model model) {
        Module module = moduleRepository.getOne(moduleId);
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        if (module.getUsers().contains(user)) {
            module.getUsers().remove(user);
            moduleRepository.save(module);
            user.getModules().remove(module);
            userRepository.save(user);
            logger.debug("Student " + user.getFirstName() + " " + user.getLastName() + "identified by username " + username + " has unregistered from the module " + module.getModule_name() + ".");
        }

        model.addAttribute("listEnrolledModules", moduleRepository.findAll());
        return "moduleEnrolment";
    }

    @RequestMapping({ "/statistics" })
    public String statistics(Model model) {
        List<User> users = userRepository.findAll();
        Map<String, List<User>> nationalitiesMap = users.stream().collect(Collectors.groupingBy(User::getNationality));
        Predicate<User> byGender = user -> user.getGender().equals("M");
        List<User> males = users.stream().filter(byGender).collect(Collectors.toList());
        model.addAttribute("males", males.size());
        model.addAttribute("females", users.size() - males.size());
        model.addAttribute("nationalitiesMap", nationalitiesMap);
        return "statistics";
    }

    @RequestMapping(value = "/newgrade/{moduleId}", method = RequestMethod.GET)
    public String enterGrade(Model model, @PathVariable(required = false, value = "moduleId") Long moduleId) {
        Module module;
        if(moduleId != null) {
            module = moduleService.findOneByCurrentUser(moduleId);
            Grade grade = new Grade();
            grade.setModule(module);
            model.addAttribute("newgrade", grade);
            return "newgrade";
        } else {
            return "redirect:/staffWelcome";
        }
    }

    @PostMapping("/newgrade")
    @Secured({"ROLE_STAFF", "ROLE_ADMIN"})
    public String newgrade(Model model, @ModelAttribute("newgrade") Grade thisgrade, BindingResult bindingResult) {

        if(thisgrade.getModule() != null && moduleService.findOneByCurrentUser(thisgrade.getModule().getId()) != null) {
            userValidatorRegistration.validateGrades(thisgrade, bindingResult);

            if (bindingResult.hasErrors()) {
                return "newgrade";
            }
            gradeRepository.save(thisgrade);
            logger.debug("Grade added for module " + thisgrade.getModule() + ". Student: " + thisgrade.getStudentName() + ". Grade: " + thisgrade.getGrade() + ".");
            return "redirect:/gradeChange";
        } else {
            return "redirect:/staffWelcome";
        }
    }
}
