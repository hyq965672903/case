package cn.hyqup.lab04validation.controller;

import cn.hyqup.lab04validation.bean.request.StudentRequest;
import cn.hyqup.lab04validation.bean.request.TeacherRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/index")
@RestController
public class IndexController {
    @GetMapping("/hello")
    public String index() {

        return "hello";
    }


    /**
     * @param request
     * @return
     */
    @PostMapping("test1")
    public StudentRequest test1(@RequestBody  StudentRequest request) {
        return request;
    }

    @PostMapping("test2")
    public TeacherRequest test2(@RequestBody @Valid TeacherRequest request) {
        return request;
    }


}
