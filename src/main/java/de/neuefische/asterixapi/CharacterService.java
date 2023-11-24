package de.neuefische.asterixapi;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public void saveCharacter(NewCharacterDTO character) {
        Character newCharacter = new Character(UUID.randomUUID().toString(), character.name(), character.age(), character.profession());
        repo.save(newCharacter);
    }

    public void deleteCharacter(String id) {
        repo.deleteById(id);
    }
}
