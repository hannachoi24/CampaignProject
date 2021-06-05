package com.likelion.hackaton.controller;

import com.likelion.hackaton.entity.Account;
import com.likelion.hackaton.entity.City;
import com.likelion.hackaton.exception.CityNotFoundException;
import com.likelion.hackaton.exception.UserNotFoundException;
import com.likelion.hackaton.form.Api_AirForm;
import com.likelion.hackaton.form.User_info;
import com.likelion.hackaton.repository.AccountRepository;
import com.likelion.hackaton.repository.CityRepository;
import com.likelion.hackaton.service.AccountService;
import com.likelion.hackaton.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/")
    public String get_airapi(Model model) throws Exception{
        Api_AirForm api_airForm = apiService.callApi_air();
        model.addAttribute("api_airForm",api_airForm);

        try {
            String userId = SecurityContextHolder.getContext().getAuthentication().getName();
            log.info(userId);
            Account account = accountRepository.findByName(userId).orElseThrow(UserNotFoundException::new);

            City city = cityRepository.findByName(account.getCityName()).orElseThrow(CityNotFoundException::new);

            model.addAttribute("city", city);
        }catch (UserNotFoundException u){

        }
        log.info("get air");
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        log.info("login controller");
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(){
        log.info("signup controller");
        return "signup";
    }

    @RequestMapping("/about")
    public String about(){
        log.info("about page");
        return"about";
    }

    @GetMapping("/information")
    public String information(Model model){
        try {
            String userId = SecurityContextHolder.getContext().getAuthentication().getName();
            log.info(userId);
            Account account = accountRepository.findByName(userId).orElseThrow(UserNotFoundException::new);
            User_info user_info = User_info.builder()
                    .cityName(account.getCityName())
                    .build();
            model.addAttribute("user_info", user_info);

            City city = cityRepository.findByName(account.getCityName()).orElseThrow(CityNotFoundException::new);
            log.info(city.getName());
            model.addAttribute("city",city);


            log.info("information page");
            return "information";
        }catch(UserNotFoundException u){
            User_info user_info = User_info.builder()
                    .error("로그인 후에 사용하세요!")
                    .build();
            model.addAttribute(user_info);
            return "information";
        }
    }

    @RequestMapping("/notice")
    public String notice(){
        log.info("notice page");
        return "notice";
    }

}
