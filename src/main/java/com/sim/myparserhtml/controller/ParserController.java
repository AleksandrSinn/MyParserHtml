package com.sim.myparserhtml.controller;

import com.sim.myparserhtml.entity.Statistic;
import com.sim.myparserhtml.service.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parser")
public class ParserController {
    private final ParserService parserService;

    @GetMapping("/{url}")
    public void parseHtmlPage(@PathVariable String url){
//        return parserService.parsePage(url);
    }

    @GetMapping("/get")
    public List<Statistic> getAllStatistic(){
        return parserService.getAllStatistics();
    }
}
