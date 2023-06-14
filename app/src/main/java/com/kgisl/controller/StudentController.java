package com.kgisl.controller;

import com.kgisl.dao.StudentDAO;
import com.kgisl.dao.StudentDAOImpl;
import com.kgisl.model.Student;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = { "/", "/student" })
public class StudentController {

    private final StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentDAOImpl();
    }

    @GetMapping
    public ModelAndView showListStudent() {
        ModelAndView modelAndView = new ModelAndView("student/list");
        List<Student> studentList = studentDAO.findAll();
        modelAndView.addObject("listStudent", studentList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detailStudent(@PathVariable Long id) {
        Student student = studentDAO.findById(id);
        ModelAndView modelAndView = new ModelAndView("student/detail");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        Student student = studentDAO.findById(id);
        ModelAndView modelAndView = new ModelAndView("student/edit");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String actionEdit(@PathVariable Long id, @RequestParam("name") String name,
            @RequestParam("email") String email, @RequestParam("address") String address) {
        Student student = studentDAO.findById(id);
        student.setName(name);
        student.setEmail(email);
        student.setAddress(address);
        studentDAO.update(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String actionDelete(@PathVariable Long id) {
        studentDAO.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("student/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public String actionCreate(@RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("address") String address) {
        Long id;
        List<Student> studentList = studentDAO.findAll();
        if (studentList.isEmpty()) {
            id = 1L;
        } else {
            id = studentList.get(studentList.size() - 1).getId() + 1;
        }
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setAddress(address);
        studentDAO.save(student);
        return "redirect:/";
    }
}
