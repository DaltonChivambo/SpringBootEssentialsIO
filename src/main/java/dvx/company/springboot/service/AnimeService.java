package dvx.company.springboot.service;

import dvx.company.springboot.domain.Anime;
import dvx.company.springboot.repository.AnimeRepository;
import dvx.company.springboot.requests.AnimePostRequestBody;
import dvx.company.springboot.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service //bin
@RequiredArgsConstructor // for dependency injection of animeRepository
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime not found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody){
        Anime anime = Anime.builder()
                .name(animePostRequestBody.getName())
                .sponsor(animePostRequestBody.getSponsor()).build();
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .sponsor(animePutRequestBody.getSponsor())
                .build();
        animeRepository.save(anime);
    }
}
