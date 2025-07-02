package io.github.pudo58.service;

import io.github.pudo58.dto.ChampionInterface;
import io.github.pudo58.entity.Champion;

import java.util.List;

public interface ChampionService {
    Champion save(Champion champion);

    Iterable<Champion> findAll();

    Champion findById(Integer id);

    void deleteById(Integer id);

    List<ChampionInterface> findBySearch(String name);
}
