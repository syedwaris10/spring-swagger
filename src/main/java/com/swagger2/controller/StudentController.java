package com.swagger2.controller;

import com.swagger2.entity.Student;
import com.swagger2.service.StudentService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    @SecurityRequirement(
            name = "JWT-AUTH"
    )
    @Operation(
           // tags = "Get Student",
            description = "Get All Students data",
            servers = @Server(
                    url = "http://localhost:8080",
                    description = "test"
            ),
            deprecated = false,
            hidden = false,
            responses = @ApiResponse (
                    description = "Returns List of all students",
                    responseCode = "200",
                    content = @Content (
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )

    )
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @SecurityRequirement(
            name = "JWT-AUTH"
    )
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    @SecurityRequirement(
            name = "JWT-AUTH"
    )
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }
}
