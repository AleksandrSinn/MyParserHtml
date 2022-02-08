package com.sim.myparserhtml.service.impl;

import com.sim.myparserhtml.component.Parser;
import com.sim.myparserhtml.dto.ParserResponseDto;
import com.sim.myparserhtml.entity.Statistic;
import com.sim.myparserhtml.mapper.StatisticMapper;
import com.sim.myparserhtml.repository.ParserRepository;
import com.sim.myparserhtml.service.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParserServiceImpl implements ParserService {
    private final ParserRepository parserRepository;
    private final StatisticMapper statisticMapper;
    private final Parser parser;
    private String CurrentUrl;

    @Override
    public void parsePage(String url) {
        CurrentUrl = url;
        Map<String, Integer> wordsMap = null;
        try {
            wordsMap = parser.parseHtmlPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Statistic>statisticList;

        if (wordsMap != null) {
            statisticList = new ArrayList<>(wordsMap.size());

            for(Map.Entry<String, Integer> words: wordsMap.entrySet()){
                Statistic statistic = new Statistic();
                statistic.setWord(words.getKey());
                statistic.setWordCounter(words.getValue());
                statistic.setUrl(url);
                statisticList.add(statistic);
            }
            parserRepository.saveAllAndFlush(statisticList);
        }
    }

    @Override
    public List<ParserResponseDto> getAllStatistics() {
       List<Statistic> list = parserRepository.findAllByUrl(CurrentUrl);
       return list.stream().map(statisticMapper::toDto).collect(Collectors.toList());
    }
}
