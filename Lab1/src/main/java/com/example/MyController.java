package com.example;

/**
 * Created by Vít on 11. 12. 2016.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/")
    public String foo() {
        return "hello";
    }
}
