package com.sim.myparserhtml.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "words_statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    @Column(name = "word_counter")
    private Integer wordCounter;
    @Enumerated(EnumType.STRING)
    private State state;

    public enum State{
        OPEN,
        CLOSED
    }
}
