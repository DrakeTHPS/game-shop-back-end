package gameshop.controllers;

import gameshop.models.entities.Genres;
import gameshop.models.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenreController {
    @Autowired
    GenreRepository genreRepository;

    @GetMapping("/genres")
    public List<Genres> index() {
        return genreRepository.findAll();
    }

    @PostMapping("/genres")
    @ResponseStatus(HttpStatus.CREATED)
    public Genres create(@RequestBody Genres genres) {
        return genreRepository.save(genres);
    }

    @PutMapping("/genres/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Genres save(@PathVariable long id, @RequestBody Genres newGenres) {
        return genreRepository.findById(id)
                .map(Genres -> {
                    Genres.setGenre(newGenres.getGenre());
                    Genres.setGames(newGenres.getGames());
                    return genreRepository.save(Genres);
                }).orElseGet(() -> null);
    }

    @DeleteMapping("/genres/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id){
        genreRepository.deleteById(id);
    }
}
