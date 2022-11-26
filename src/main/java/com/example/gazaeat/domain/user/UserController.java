package com.example.gazaeat.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final AuthService authService;

    @GetMapping("signup")
    public String signup()
    {
        return "signup";
    }

    @GetMapping("login")
    public String login()
    {
        return "login";
    }

    @PostMapping("signup")
    public String signup(UserEntity user) {
        authService.signup(user);

        return "redirect:/";
    }

    @PostMapping("login")
    public String login(UserEntity user, HttpSession session) {

        if(authService.login(user)) {
            session.setAttribute("account", user.accountId);
        }

        return "redirect:/";
    }

}
