package gameshop.controllers;

import gameshop.models.entities.Game;
import gameshop.models.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GameController {
    @Autowired
    GameRepository gameRepository;


    @GetMapping("/games")
    public List<Game> index() {
        return gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public Game get(@PathVariable long id) {
        Optional<Game> result = gameRepository.findById(id);
        return result.orElse(null);
    }


    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game create(@RequestBody Game game){
        return gameRepository.save(game);
    }


    @PutMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game save(@PathVariable long id, @RequestBody Game newGame) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setTitle(newGame.getTitle());
                    game.setPrice(newGame.getPrice());
                    game.setDeveloper(newGame.getDeveloper());
                    game.setGenres(newGame.getGenres());
                    game.setDiscount(newGame.getDiscount());
                    game.setSold(newGame.getSold());
                    game.setImgLink(newGame.getImgLink());
                    game.setReleaseDate(newGame.getReleaseDate());
                    return gameRepository.save(game);
                }).orElseGet(() -> null);
    }


    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id){
        gameRepository.deleteById(id);
    }
}
