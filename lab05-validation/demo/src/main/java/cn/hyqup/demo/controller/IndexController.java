package cn.hyqup.demo.controller;

import cn.hyqup.demo.bean.request.StudentRequest;
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
    public StudentRequest test1( @RequestBody StudentRequest request) {
        return request;
    }


}
