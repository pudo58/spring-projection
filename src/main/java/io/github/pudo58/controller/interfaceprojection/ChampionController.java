package io.github.pudo58.controller.interfaceprojection;

import io.github.pudo58.dto.ChampionInterface;
import io.github.pudo58.entity.Champion;
import io.github.pudo58.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/champion")
public class ChampionController {
    private final ChampionService championService;

    @Autowired
    public ChampionController(ChampionService championService) {
        this.championService = championService;
    }

    @PostMapping("/save")
    public Champion save(@RequestBody Champion champion) {
        return championService.save(champion);
    }

    @GetMapping("/get/{id}")
    public Champion findById(@PathVariable Integer id) {
        return championService.findById(id);
    }

    @GetMapping("/findAll")
    public Iterable<Champion> findAll() {
        return championService.findAll();
    }

    @GetMapping( value = "/findBySearch", produces = APPLICATION_JSON_VALUE)
    public List<ChampionInterface> findAll(@RequestParam String name) {
        return championService.findBySearch(name);
    }
}
