package com.fastcampus.trustRide.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")

public class MemberController {


    @GetMapping("/main")
    public String main(){
        return "admin/main";

    }

}
