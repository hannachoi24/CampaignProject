package com.likelion.hackaton.form;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Api_AirForm {
    private String name;
    private String seoul;
    private String gwangju;
    private String busan;
    private String jeju;

    private String dataTime;
}
