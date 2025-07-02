package io.github.pudo58.repo;

import io.github.pudo58.dto.ChampionInterface;
import io.github.pudo58.entity.Champion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionRepo extends CrudRepository<Champion, Integer> {
    @Query("select c.id id, c.name name, c.dateOfBirth dateOfBirth, c.gender gender from Champion c where :name is null or length(trim(:name)) = 0 or c.name like %:name%")
    List<ChampionInterface> findByName(String name); // dùng interface làm DTO
}
