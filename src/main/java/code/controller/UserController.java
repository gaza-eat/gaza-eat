package code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import code.dto.UserDto;
import code.service.UserService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/user")
@Controller @RequiredArgsConstructor
public class UserController 
{
    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signup()
    {
        return "/signup";
    }
    @GetMapping("/login")
    public String login()
    {
        return "/login";
    }

    @PostMapping("/signup_process")
    public String signup_process(UserDto dto)
    {
        // 회원가입 성공 시, redirect:/
        // 회원가입 실패 시 , redirect:/user/signup

        return userService.signUp(dto);
    }
    @PostMapping("/login_process")
    public String login_process(UserDto dto)
    {
        // 회원가입 성공 시, redirect:/
        // 회원가입 실패 시 , redirect:/user/login

        // 세션에 들어가는 정보(문자열 그대로임.)
        // userNo, id, password

        return userService.login(dto);
    }
    



}


