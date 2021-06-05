package com.likelion.hackaton.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Account> accountList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="title_id")
    private Title title;

    @Column(nullable = false,unique = true)
    private String name;

    @Column
    @ColumnDefault("0")
    private int todo_1;

    @Column
    @ColumnDefault("0")
    private int todo_2;

    @Column
    @ColumnDefault("0")
    private int todo_3;

    @Column
    @ColumnDefault("0")
    private int todo_4;

    @Column
    @ColumnDefault("0")
    private int todo_5;

    @Column
    @ColumnDefault("0")
    private int todo_6;

    public void setTodo_1(){
        this.todo_1 = 1;
    }

    public final String one = "먹방 꿈나무";

}
