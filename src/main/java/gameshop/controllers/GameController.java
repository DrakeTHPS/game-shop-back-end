package gameshop.controllers;

import gameshop.models.entities.Games;
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
    public List<Games> index() {
        return gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public Games get(@PathVariable long id) {
        Optional<Games> result = gameRepository.findById(id);
        return result.orElse(null);
    }



    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Games create(@RequestBody Games games){
        return gameRepository.save(games);
    }
    @PutMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Games save(@PathVariable long id, @RequestBody Games newGames) {
        return gameRepository.findById(id)
                .map(games -> {
                    games.setTitle(newGames.getTitle());
                    games.setPrice(newGames.getPrice());
                    games.setDeveloper(newGames.getDeveloper());
                    games.setGenres(newGames.getGenres());
                    games.setDiscount(newGames.getDiscount());
                    games.setSold(newGames.getSold());
                    games.setImgLink(newGames.getImgLink());
                    games.setReleaseDate(newGames.getReleaseDate());
                    return gameRepository.save(games);
                }).orElseGet(() -> null);
    }


    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id){
        gameRepository.deleteById(id);
    }
}
