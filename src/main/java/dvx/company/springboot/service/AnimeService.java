package dvx.company.springboot.service;

import dvx.company.springboot.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service //bin
public class AnimeService {

    private static List<Anime> animes;

    static {
       animes = new ArrayList<>(List.of(new Anime(1L,"Vikings", "Disney"), new Anime(2L,"Mr Robot", "Netflix")));
    }
    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime not found"));
    }

    public Anime save(Anime anime){
        anime.setId((ThreadLocalRandom.current().nextLong(3,10000)));
        animes.add(anime);
        return anime;
    }

    public void delete(long id) {
        animes.remove(findById(id));
    }

    public void replace(Anime anime) {
        delete(anime.getId());
        animes.add(anime);
    }
}
