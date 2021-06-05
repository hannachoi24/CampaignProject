package com.likelion.hackaton.entity;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "title",cascade = CascadeType.ALL)
    private City city;

    @Column
    @ColumnDefault("0")
    private int badge_1;

    @Column
    @ColumnDefault("0")
    private int badge_2;

    @Column
    @ColumnDefault("0")
    private int badge_3;

    @Column
    @ColumnDefault("0")
    private int badge_4;

    @Column
    @ColumnDefault("0")
    private int badge_5;

    @Column
    @ColumnDefault("0")
    private int badge_6;


    public void initialize(){
        badge_1 = 0;
        badge_2 = 0;
        badge_3 = 0;
        badge_4 = 0;
        badge_5 = 0;
        badge_6 = 0;
    }

    public void setBadge_1(){
        this.badge_1 = 1;
    }
}
