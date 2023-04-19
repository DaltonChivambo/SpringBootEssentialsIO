package dvx.company.springboot.controller;

import dvx.company.springboot.domain.Anime;
import dvx.company.springboot.requests.AnimePostRequestBody;
import dvx.company.springboot.requests.AnimePutRequestBody;
import dvx.company.springboot.service.AnimeService;
import dvx.company.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController // return responseBody(Strings)
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor //for dependency injection
public class AnimeController {
    private final DateUtil dateUtil;
    /**Another way to add dependency injection:
     * public AnimeController(DateUtil dateUtil){
     *     this.dateUtil = dateUtil;
     * }
     * or use spring resources
     * private final DateUtil dateUti; and add @RequiredArgsConstructor bellow the class;
     *
    **/
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDateToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK); //return lis and status
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id)); //return anime using id
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody animePostRequestBody) {
        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody){
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
