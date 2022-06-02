package com.users.quotes.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Quote implements Comparable<Quote>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String statement;

    @ManyToOne
    private User user;

    @Column
    private Integer vote;

    @Override
    public int compareTo(Quote o) {
        if (this.vote > o.vote) {
            return 1;
        } else if (this.vote.equals(o.vote)) {
            return 0;
        } else {
           return  -1;
        }
    }
}
