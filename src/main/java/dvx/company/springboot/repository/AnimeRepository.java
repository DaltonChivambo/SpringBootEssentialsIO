package dvx.company.springboot.repository;

import dvx.company.springboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    //private final animeRepository animeRepository
    List<Anime> listAll();
}
