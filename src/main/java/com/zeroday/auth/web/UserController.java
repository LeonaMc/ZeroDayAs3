package com.zeroday.auth.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeroday.auth.model.Grade;
import com.zeroday.auth.model.User;
import com.zeroday.auth.model.payFees;
import com.zeroday.auth.repository.FeesRepository;
import com.zeroday.auth.repository.GradeRepository;
import com.zeroday.auth.repository.UserRepository;
import com.zeroday.auth.service.SecurityService;
import com.zeroday.auth.service.UserService;
import com.zeroday.auth.validator.UserValidator;
import javax.swing.JOptionPane;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private FeesRepository feesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @GetMapping("/feeshavebeenpaid")
    public String feesAlreadyPaid(Model model) {
        return "feeshavebeenpaid";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({ "/", "/welcome" })
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping({ "/gradeChange" })
    public String gradeChange(Model model) {
        return "gradeChange";
    }

    @GetMapping({ "/moduleEnrolment" })
    public String moduleEnrolment(Model model) {
        return "moduleEnrolment";
    }

    @GetMapping({ "/viewGrades" })
    public String viewGrades(Model model) {
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        List<Grade> listGrades = gradeRepository.findByStudentID(user.getId());
        model.addAttribute("listGrades", listGrades);
        return "viewGrades";
    }

    @GetMapping({ "/payFees" })
    public String payFees(@ModelAttribute("payFees") payFees payFee, Model model) {
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        if (user.getPayFeesSet().isEmpty()) {
            model.addAttribute("payFees", new payFees());
            return "payFees";
        }else{
            model.addAttribute("error", "Fees have already been paid.");
            return "feeshavebeenpaid";
        }
    }

    @PostMapping("/payFees")
    public String payFees(@ModelAttribute("payFees") payFees fees, BindingResult bindingResult) {

        userValidator.validateFees(fees, bindingResult);

        if (bindingResult.hasErrors()) {
            return "payFees";
        }
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        fees.setUser(user);
        feesRepository.save(fees);

        return "redirect:/welcome";
    }

    @RequestMapping("/remove/{username}")
    public String deleteUser(@PathVariable(value = "username") String username) {
        User user = userService.findByUsername(username);
        userService.delete(user);

        return "login";
    }

}
