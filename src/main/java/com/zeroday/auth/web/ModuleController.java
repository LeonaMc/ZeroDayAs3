package com.zeroday.auth.web;

import com.zeroday.auth.exception.AuthorNotFoundException;
import com.zeroday.auth.exception.ModuleNotFoundException;
import com.zeroday.auth.model.Module;
import com.zeroday.auth.model.Grade;

import com.zeroday.auth.repository.GradeRepository;
import com.zeroday.auth.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@Controller
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;


    @Autowired
    GradeRepository gradeRepository;

    @RequestMapping({"/list"})
    public String viewHomePage(Model model) {
        List<Module> listModules = moduleRepository.findAll();
        model.addAttribute("listModules", listModules);
        return "staffWelcome";
    }

    @GetMapping({"/staffWelcome"})
    public String staffWelcome(Model model) {
        return "staffWelcome";
    }

    // Delete a Note
    @RequestMapping("/delete/{id}")
    public String deleteModule(@PathVariable(value = "id") Long moduleId, Model model) throws ModuleNotFoundException {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ModuleNotFoundException(moduleId));

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
    public String createNote(@ModelAttribute("module")  Module module, Model model) {
        moduleRepository.save(module);
        return viewHomePage(model);
    }

    // Update a Note
    @RequestMapping(value = "staffWelcome", method = RequestMethod.POST)
    public String updateNote( @ModelAttribute("module")  Module module, Model model) throws ModuleNotFoundException {

        moduleRepository.save(module);

        return viewHomePage(model);
    }

    // Get a Single Note
    @GetMapping("/modules/{id}")
    public String getNoteById(@PathVariable(value = "id") Long moduleId, Model model)
            throws ModuleNotFoundException, AuthorNotFoundException {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ModuleNotFoundException(moduleId));
        model.addAttribute("module", module);

        return "editform";
    }

    // Create a new Note
    @RequestMapping("/newgrade")
    public String createGrade() {
        return "newgrade";
    }

    @PostMapping("/grades")
    public String createGrade(@ModelAttribute("grade")  Grade grade, Model model) {
        gradeRepository.save(grade);
        return viewHomePage(model);
    }

    // Create a new Note
    @RequestMapping("/listgrades")
    public String listGrades() {
        return "listgrades";
    }

    ///////////

    // Create a new Note
    @RequestMapping("/newEnrolModule")
    public String enrolModule() {
        return "moduleEnrolment";
    }

    @RequestMapping({"/listAllEnroledModules"})
    public String listAllEnroledModules(Model model) {
        List<Module> listModules = moduleRepository.findAll();
        model.addAttribute("listModules", listModules);
        return "moduleEnrolment";
    }

}
