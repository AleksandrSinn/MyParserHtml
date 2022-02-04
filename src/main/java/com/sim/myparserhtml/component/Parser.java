package com.sim.myparserhtml.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
@Setter
@Component
public class Parser {
//    private final String URL = "https://www.simbirsoft.com/";

    public Map<String, Integer> parseHtmlPage(String URL) throws IOException {
        Document document = Jsoup.connect(URL).get();
        Elements allElements = document.getAllElements();
        String dataOfHtml = allElements.text();

        List<String>stringList = Arrays.stream(dataOfHtml.split(" "))
                .filter(s -> s.matches("[а-яА-Я]+"))
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());

        Map<String, Integer> wordsMap = new HashMap<>(stringList.size());

        for (String s : stringList) {
            if (!wordsMap.containsKey(s)) {
                wordsMap.put(s, 1);
            } else {
                wordsMap.put(s, wordsMap.get(s) + 1);
            }
        }
        return wordsMap;
    }
}