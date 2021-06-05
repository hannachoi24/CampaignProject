package com.likelion.hackaton.form;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

    private int questionNo;

    private String questionText;

    private String answer1;
    private String answer2;

    public QuestionForm(int questionNo){
        this.questionNo = questionNo;
    }
}
