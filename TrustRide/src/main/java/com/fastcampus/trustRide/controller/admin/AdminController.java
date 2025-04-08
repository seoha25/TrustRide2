package com.fastcampus.trustRide.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/management")

public class AdminController {

    // 관리자 로그인시 관리자 메인페이지 이동
    @GetMapping("/main")
    public String main(){
        return "admin/main";

    }

    // 회원가입 폼 이동
    @GetMapping("/register")
    public String goToRegisterPage(){
        return "admin/registerForm";
    }

    // 관리자 회원가입
    @PostMapping("/register")
    public String Reggister(/*AdminRegisterDto adminregisterDto*/){
        return "redirect:/admin/management/main";
    }

}
