package com.sim.myparserhtml.service;
import com.sim.myparserhtml.dto.ParserResponseDto;
import com.sim.myparserhtml.entity.Statistic;

import java.util.List;


public interface ParserService {
    void parsePage(String url);
    List<ParserResponseDto> getAllStatistics();
}
