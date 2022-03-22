package com;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {
    private Student student;

    @GetMapping("/student")
    public String get(){
        return student == null ? "nulli" : student.toString();
    }

    //curl -i -X POST -H "Content-Type: application/json" -d "{\"firstName\":\"first\",\"middleName\":\"mid\",\"lastName\":\"last\"}" http://localhost:8080/student
    @PostMapping(
            path = "/student",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    "application/json"
            }
    )
    public void set(@Valid @RequestBody Student student){
        this.student = student;
    }

    @DeleteMapping("/student")
    public void delete(){
        student = null;
    }
}
