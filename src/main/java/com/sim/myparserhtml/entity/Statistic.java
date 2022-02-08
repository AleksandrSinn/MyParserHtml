package com.sim.myparserhtml.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "words_statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    @Column(name = "word_counter")
    private Integer wordCounter;
    private String url;

    @Override
    public String toString() {
        return word + " - " + wordCounter.toString();
    }
}
