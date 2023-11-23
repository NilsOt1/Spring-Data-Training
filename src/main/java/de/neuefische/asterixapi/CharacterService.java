package de.neuefische.asterixapi;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepo repo;


    public List<Character> getAllCharacters() {
        return repo.findAll();
    }

    public Character getCharacterById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Kein Character gefunden"));
    }

    public void saveCharacter(Character character) {
        repo.save(character);
    }
}
