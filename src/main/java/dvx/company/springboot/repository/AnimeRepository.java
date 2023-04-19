package dvx.company.springboot.repository;

import dvx.company.springboot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//The parameter is long because is the id attribute type
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    /**On Spring we have methods for interact with database, as findAll, findAllByID, etc.
     * We don't need to create these methods.**/
}
