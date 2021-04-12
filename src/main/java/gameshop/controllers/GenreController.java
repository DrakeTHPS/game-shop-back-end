package gameshop.controllers;

import gameshop.models.entities.Genre;
import gameshop.models.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
public class GenreController {
    @Autowired
    GenreRepository genreRepository;

    @GetMapping("/genres")
    public List<Genre> index() {
        return genreRepository.findAll();
    }

    @PostMapping("/genres")
    @ResponseStatus(HttpStatus.CREATED)
    public Genre create(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    @PutMapping("/genres/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Genre save(@PathVariable long id, @RequestBody Genre newGenre) {
        return genreRepository.findById(id)
                .map(Genre -> {
                    Genre.setGenre(newGenre.getGenre());
                    Genre.setGames(newGenre.getGames());
                    return genreRepository.save(Genre);
                }).orElseGet(() -> null);
    }

    @DeleteMapping("/genres/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        genreRepository.deleteById(id);
    }
}
