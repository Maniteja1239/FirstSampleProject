package com.example.firstsample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/sayhello")
    public String sayHello(){
        return "Hello Everyone";
    }

    @GetMapping("/saybye")
    public String sayBye(){
        return "Goodbye Everyone";
    }
}
