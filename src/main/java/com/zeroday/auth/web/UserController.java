package com.zeroday.auth.web;

import java.security.Principal;
import java.util.List;

import com.zeroday.auth.validator.LoginValidator;
import com.zeroday.auth.validator.UserValidatorRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.zeroday.auth.model.Grade;
import com.zeroday.auth.model.User;
import com.zeroday.auth.model.payFees;
import com.zeroday.auth.repository.FeesRepository;
import com.zeroday.auth.repository.GradeRepository;
import com.zeroday.auth.repository.UserRepository;
import com.zeroday.auth.service.SecurityService;
import com.zeroday.auth.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidatorRegistration userValidatorRegistration;

    @Autowired
    private FeesRepository feesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        model.addAttribute("error", errorMessage);
        return "/login";
    }

    @GetMapping("/perform-login")
    public String performLogin(Model model, HttpServletRequest request, Principal principal,Authentication authentication) {
        if(null == principal){
            return "/login";
        }
        String determineURL = null;
        try {
            determineURL = determineURL(authentication);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String result = userService.loginValidation(principal.getName(), request);
        if (result.equalsIgnoreCase(LoginValidator.VALID)) {
            return determineURL;
        } else {
            model.addAttribute("error", result);
            HttpSession session= request.getSession(false);
            SecurityContextHolder.clearContext();
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            session.invalidate();
            return "/login";
        }
    }

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
        userValidatorRegistration.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        // Auto-login functionality removed for security reasons
        // securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/login";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard(HttpSession session, Model model) {
        if (session == null) {
            return "/login";
        }
        if (null == session.getAttribute("userName")) {
            return "/login";
        }
        return "/";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
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
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        List<Grade> listGrades = gradeRepository.findByStudentID(user.getId());
        model.addAttribute("listGrades", listGrades);
        return "viewGrades";
    }

    @GetMapping({"/payFees"})
    public String payFees(@ModelAttribute("payFees") payFees payFee, HttpSession session, Model model) {
        if (null == session.getAttribute("userName")) {
            return "/login";
        }
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        if (user.getPayFeesSet().isEmpty()) {
            model.addAttribute("payFees", new payFees());
            return "payFees";
        } else {
            model.addAttribute("error", "Fees have already been paid.");
            return "feeshavebeenpaid";
        }
    }

    @PostMapping("/payFees")
    public String payFees(@ModelAttribute("payFees") payFees fees, BindingResult bindingResult) {

        userValidatorRegistration.validateFees(fees, bindingResult);

        if (bindingResult.hasErrors()) {
            return "payFees";
        }
        String username = securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(username);
        fees.setUser(user);
        feesRepository.save(fees);
        logger.debug("User " + username + " has paid their fees.");
        return "redirect:/welcome";
    }

    @RequestMapping("/remove/{username}")
    public String deleteUser(@PathVariable(value = "username") String username) {
        User user = userService.findByUsername(username);
        userService.delete(user);

        return "login";
    }


    protected String determineURL(Authentication authentication) throws IllegalAccessException {
        boolean isAdmin = false;
        boolean isStaff = false;
        boolean isStudent = false;
        OUTER:
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            switch (authority.getAuthority()) {
                case "ROLE_ADMIN":
                    isAdmin = true;
                    break OUTER;
                case "ROLE_STAFF":
                    isStaff = true;
                case "ROLE_STUDENT":
                    isStudent = true;
            }
        }
        if (isAdmin) {
            return "/welcome";
        } else if(isStaff){
            return "/staffWelcome";
        }else if (isStudent){
            return "/welcome";
        }
        else {
            throw new IllegalAccessException();
        }
    }
}
