package com.sim.myparserhtml.dto;

import com.sim.myparserhtml.entity.Statistic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParserRequestDto {
    private String word;
    private Integer wordCounter;
    private Statistic.State state = Statistic.State.OPEN;
}
