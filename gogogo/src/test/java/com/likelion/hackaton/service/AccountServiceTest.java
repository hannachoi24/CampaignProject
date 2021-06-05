package com.likelion.hackaton.service;

import com.likelion.hackaton.entity.Account;
import com.likelion.hackaton.entity.City;
import com.likelion.hackaton.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


class AccountServiceTest extends AccountServiceFactory{

    /*@Test
    public void 회원가입() throws Exception{
        // given
        City city = createCity();
        Account account = createAccount(city,"test@email.com");

        // when
        Long id = accountService.signup(account);

        // then
        assertEquals(account,accountRepository.findById(id).get());
    }*/


}