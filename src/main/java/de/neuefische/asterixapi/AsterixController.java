package de.neuefische.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asterix/character")
@RequiredArgsConstructor
public class AsterixController {

    private final CharacterService service;

    @GetMapping
    public List<Character> getAllCharacters() {
        return service.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable String id) {
        return service.getCharacterById(id);
    }


    @PostMapping
    public void newCharacter(@RequestBody NewCharacterDTO character) {
        service.saveCharacter(character);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {
        service.deleteCharacter(id);
    }

    /*@PutMapping("/{id}")
    public Character updateCharacter(@RequestBody Character character) {
        return service.updateCharacter(character);
    }*/
}
