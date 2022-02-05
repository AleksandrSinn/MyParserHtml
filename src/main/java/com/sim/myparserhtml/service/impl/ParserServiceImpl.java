package com.sim.myparserhtml.service.impl;

import com.sim.myparserhtml.component.Parser;
import com.sim.myparserhtml.entity.Statistic;
import com.sim.myparserhtml.mapper.StatisticMapper;
import com.sim.myparserhtml.repository.ParserRepository;
import com.sim.myparserhtml.service.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ParserServiceImpl implements ParserService {
    private final StatisticMapper statisticMapper;
    private final ParserRepository parserRepository;
    private final Parser parser;

    @Override
    public void parsePage(String url) {
        Map<String, Integer> wordsMap = null;
        try {
            wordsMap = parser.parseHtmlPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wordsMap != null) {
            for(Map.Entry<String, Integer> words: wordsMap.entrySet()){
                Statistic statistic = new Statistic();
                statistic.setWord(words.getKey());
                statistic.setWordCounter(words.getValue());
                statisticMapper.toDto(parserRepository.save(statistic));
            }
        }
    }

    @Override
    public List<Statistic> getAllStatistics() {
        List<Statistic>statisticList = parserRepository.getStatisticsByState(Statistic.State.OPEN);
//        return statisticList.stream().map(statisticMapper::toDto).collect(Collectors.toList());
        return statisticList;
    }
}
