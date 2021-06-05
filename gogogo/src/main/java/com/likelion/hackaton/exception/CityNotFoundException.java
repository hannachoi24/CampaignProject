package com.likelion.hackaton.exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(){
        super("도시가 존재하지 않습니다. ");
    }
}
