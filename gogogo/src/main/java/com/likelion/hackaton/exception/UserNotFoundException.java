package com.likelion.hackaton.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("계정이 존재하지 않습니다.");
    }
}
