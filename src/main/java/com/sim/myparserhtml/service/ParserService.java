package com.sim.myparserhtml.service;
import com.sim.myparserhtml.dto.ParserResponseDto;

import java.util.List;


public interface ParserService {
    ParserResponseDto parsePage(String url);
    List<ParserResponseDto> getAllStatistics();
}
