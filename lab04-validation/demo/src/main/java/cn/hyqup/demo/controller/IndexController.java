package cn.hyqup.demo.controller;

import cn.hyqup.demo.bean.request.StudentRequest;
import cn.hyqup.validator.annations.ValidateProperty;
import cn.hyqup.validator.enums.CheckType;
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
    public StudentRequest test1(@RequestBody StudentRequest request) {
        return request;
    }


    @PostMapping("test2")
    public String test2(@ValidateProperty(checkType = CheckType.MobilePhone) String phone,@ValidateProperty(checkType = CheckType.True) boolean isMan) {
        return phone;
    }
}
