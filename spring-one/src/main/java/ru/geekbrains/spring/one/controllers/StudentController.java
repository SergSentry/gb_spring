package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.model.Student;
import ru.geekbrains.spring.one.services.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // [http://localhost:8189/app]/
    @GetMapping("/")
    public String showAllStudentsPage(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/students/{id}")
    public String showStudentInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Student> student = studentService.findOneById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
        }
        return "student_info";
    }

    // [http://localhost:8189/app]/students/creator
    @GetMapping("/students/create")
    public String showCreator() {
        return "create_student_form";
    }

    @PostMapping("/students/create")
    public String createNewStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/students/score/sub/{id}")
    public String subScoreStudentById(@PathVariable Long id) {
        studentService.subScoreById(id);
        return "redirect:/";
    }

    @GetMapping("/students/score/add/{id}")
    public String addScoreStudentById(@PathVariable Long id) {
        studentService.addScoreById(id);
        return "redirect:/";
    }

    @PostMapping("/students/search")
    public String searchStudentInfo(@RequestParam Long id, Model model) {
        Optional<Student> student = studentService.findOneById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
        }
        return "student_info";
    }
}
