package com.sim.myparserhtml.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParserResponseDto {
    private long id;
    private String word;
    private Integer wordCounter;
}
