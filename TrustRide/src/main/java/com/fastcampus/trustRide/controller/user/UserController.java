package com.fastcampus.trustRide.controller.user;

import com.fastcampus.trustRide.dto.UserDto;
import com.fastcampus.trustRide.mail.EmailAuthService;
import com.fastcampus.trustRide.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailAuthService emailAuthService;

    // 회원 메인 페이지 이동
    @GetMapping("/")
    public String main(){
        return "user/main";
    }

    // 고객 회원가입 페이지 이동
    @GetMapping("/register")
    public String goToRegisterPage() {
        return "user/registerForm";
    }

    // 고객 회원 등록
    @PostMapping("/register")
    public String processRegister(@ModelAttribute UserDto user, RedirectAttributes redirectAttributes) {
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("completeMessage", "가입이 완료되었습니다!");
        return "redirect:/login.do";
    }
}
