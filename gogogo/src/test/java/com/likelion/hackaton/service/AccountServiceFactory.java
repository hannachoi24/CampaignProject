package com.likelion.hackaton.service;

import com.likelion.hackaton.entity.Account;
import com.likelion.hackaton.entity.City;
import com.likelion.hackaton.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AccountServiceFactory {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected AccountService accountService;

    @Autowired
    protected AccountRepository accountRepository;

    protected City createCity(){
        City city = City.builder()
                .name("Seoul")
                .build();

        return city;
    }

    protected Account createAccount(City city,String email){

        Account account = Account.builder()
                .city(city)
                .email(email)
                .password("test_password")
                .name("test_user")
                .build();

        return account;
    }
}
