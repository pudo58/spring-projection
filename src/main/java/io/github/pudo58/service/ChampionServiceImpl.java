package io.github.pudo58.service;

import io.github.pudo58.dto.ChampionInterface;
import io.github.pudo58.entity.Champion;
import io.github.pudo58.repo.ChampionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(rollbackOn = IllegalArgumentException.class)
public class ChampionServiceImpl implements ChampionService {
    private final ChampionRepo championRepo;

    @Autowired
    public ChampionServiceImpl(ChampionRepo championRepo) {
        this.championRepo = championRepo;
    }

    @Override
    public Champion save(Champion champion) {
        return championRepo.save(champion);
    }

    @Override
    public Iterable<Champion> findAll() {
        return championRepo.findAll();
    }

    @Override
    public Champion findById(Integer id) {
        return championRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Champion not found"));
    }

    @Override
    public void deleteById(Integer id) {
        championRepo.deleteById(id);
    }

    @Override
    public List<ChampionInterface> findBySearch(String name) {
        return championRepo.findByName(name);
    }
}
