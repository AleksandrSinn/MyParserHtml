package com.sim.myparserhtml.service.impl;

import com.sim.myparserhtml.component.Parser;
import com.sim.myparserhtml.dto.ParserResponseDto;
import com.sim.myparserhtml.mapper.StatisticMapper;
import com.sim.myparserhtml.repository.ParserRepository;
import com.sim.myparserhtml.service.ParserService;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@Getter
class ParserServiceImplTest {
    private final ParserRepository parserRepository;
    private final Parser parser = new Parser();
    private final ParserService parserService;
    private final StatisticMapper statisticMapper;

    private final String URL = "https://www.simbirsoft.com";

    public ParserServiceImplTest() {
        this.parserRepository = mock(ParserRepository.class);
        this.statisticMapper = mock(StatisticMapper.class);
        this.parserService = new ParserServiceImpl(parserRepository, statisticMapper, parser);
    }

    @Test
    void parsePage() {
        Map<String, Integer> wordsMap = new HashMap<>();
        try {
            wordsMap = parser.parseHtmlPage(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordsMap.entrySet().forEach(System.out::println);
        assertFalse(wordsMap.isEmpty());
    }

    @Test
    void getAllStatistics() {
        parserService.parsePage(URL);
        List<ParserResponseDto> list = parserService.getAllStatistics();
        list.forEach(System.out::println);
    }
}