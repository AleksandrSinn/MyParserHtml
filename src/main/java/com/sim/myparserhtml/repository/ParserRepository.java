package com.sim.myparserhtml.repository;

import com.sim.myparserhtml.entity.Statistic;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParserRepository extends JpaRepository<Statistic, Long> {
    List<Statistic>findAllByUrl(String url);
}
