package com.likelion.hackaton.controller;

import com.likelion.hackaton.form.LoginForm;
import com.likelion.hackaton.form.SignupForm;
import com.likelion.hackaton.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/signup")
    public String getSignup(Model model){
        model.addAttribute("signupForm",new SignupForm());
        log.info("get signup");
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@Valid SignupForm signupForm, BindingResult result){

        if(result.hasErrors())
            return "signup";

        accountService.signup(signupForm);
        log.info("post signup");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("loginForm",new LoginForm());
        log.info("get login");
        return "login";
    }
/*
    @PostMapping("/login")
    public String postLogin(@Valid LoginForm loginForm, BindingResult result){
        if(result.hasErrors())
            return "login";

        log.info("post login");
        return "redirect:/";
    }*/
}
