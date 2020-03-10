package com.zeroday.auth.web;

import com.zeroday.auth.model.User;
import com.zeroday.auth.model.payFees;
import com.zeroday.auth.service.SecurityService;
import com.zeroday.auth.service.UserService;
import com.zeroday.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
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

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping({"/gradeChange"})
    public String gradeChange(Model model) {
        return "gradeChange";
    }

    @GetMapping({"/moduleEnrolment"})
    public String moduleEnrolment(Model model) {
        return "moduleEnrolment";
    }

    @GetMapping({"/viewGrades"})
    public String viewGrades(Model model) {
        return "viewGrades";
    }

    @GetMapping({"/payFees"})
    public String payFees(@ModelAttribute("payFees") payFees user, Model model)
    {
        if (!user.getPayFees()) {
            model.addAttribute("payFees", new payFees());
            return "payFees";
        }else{
            return "welcome";
        }
    }

    @PostMapping("/payFees")
    public String payFees(@ModelAttribute("payFees") payFees user, BindingResult bindingResult) {

        userValidator.validateFees(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "payFees";
        }

        user.setPayFees();

        return "redirect:/welcome";
    }

    @RequestMapping("/remove/{username}")
    public String deleteUser(@PathVariable(value = "username") String username){
        User user = userService.findByUsername(username);
        userService.delete(user);

        return "login";
    }

}