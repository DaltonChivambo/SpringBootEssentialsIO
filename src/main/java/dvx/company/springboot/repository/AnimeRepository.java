package dvx.company.springboot.repository;

import dvx.company.springboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
