package com.irlix.poems.utils;

import com.irlix.poems.dto.PoemDto;
import com.irlix.poems.entities.Poem;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public PoemDto mapToPoemDto(Poem poem) {
        PoemDto poemDto = new PoemDto();
        poemDto.setId(poem.getId());
        poemDto.setTitle(poem.getTitle());
        poemDto.setText(poem.getText());
        return poemDto;
    }

    public Poem mapToPoem(PoemDto poemDto) {
        Poem poem = new Poem();
        poem.setId(poemDto.getId());
        poem.setTitle(poemDto.getTitle());
        poem.setText(poemDto.getText());
        return poem;
    }
}
