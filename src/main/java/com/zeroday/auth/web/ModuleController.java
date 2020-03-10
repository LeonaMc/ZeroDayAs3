package com.zeroday.auth.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeroday.auth.exception.AuthorNotFoundException;
import com.zeroday.auth.exception.ModuleNotFoundException;
import com.zeroday.auth.model.Module;
import com.zeroday.auth.repository.ModuleRepository;

@Controller
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;

    @RequestMapping({ "/list" })
    public String viewHomePage(Model model) {
        List<Module> listModules = moduleRepository.findAll();
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
        return viewHomePage(model);
    }

    // Update a Note
    @RequestMapping(value = "staffWelcome", method = RequestMethod.POST)
    public String updateNote(@ModelAttribute("module") Module module, Model model) throws ModuleNotFoundException {

        moduleRepository.save(module);

        return viewHomePage(model);
    }

    // Get a Single Note
    @GetMapping("/modules/{id}")
    public String getNoteById(@PathVariable(value = "id") Long moduleId, Model model)
            throws ModuleNotFoundException, AuthorNotFoundException {
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
    public String listGrades() {
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
        return "moduleEnrolment";
    }

    @RequestMapping({ "/listActiveEnrolledModules" })
    public String listAEnrolledModules(Model model) {
        List<Module> listEnrolledModules = moduleRepository.getListOfEnrolledModules();
        model.addAttribute("listEnrolledModules", listEnrolledModules);
        return "moduleEnrolmentActive";
    }

    @GetMapping("/modules/enroll/{moduleId}")
    public String enroll(@PathVariable(value = "moduleId") Long moduleId, Model model) {
        Module module = moduleRepository.getOne(moduleId);
        module.setEnroll(true);
        moduleRepository.save(module);
        model.addAttribute("listEnrolledModules", moduleRepository.findAll());
        return "moduleEnrolment";
    }

    @GetMapping("/modules/cancel/{moduleId}")
    public String cancel(@PathVariable(value = "moduleId") Long moduleId, Model model) {
        Module module = moduleRepository.getOne(moduleId);
        module.setEnroll(false);
        moduleRepository.save(module);
        model.addAttribute("listEnrolledModules", moduleRepository.findAll());
        return "moduleEnrolment";
    }
}
