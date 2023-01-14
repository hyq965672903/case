package cn.hyqup.lab04validation.controller;

import cn.hyqup.lab04validation.bean.request.StudentRequest;
import org.springframework.web.bind.annotation.*;

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
    public StudentRequest test2(@RequestBody  StudentRequest request) {
        return request;
    }
}
