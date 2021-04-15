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

}
