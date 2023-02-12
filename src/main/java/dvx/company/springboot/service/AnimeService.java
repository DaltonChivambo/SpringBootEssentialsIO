package dvx.company.springboot.service;

import dvx.company.springboot.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    public List<Anime> listAll(){
        return List.of(new Anime(1L,"Vikings", "Disney"), new Anime(2L,"Mr Robot", "Netflix"));
    }
}
