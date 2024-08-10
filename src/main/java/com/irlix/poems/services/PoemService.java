package com.irlix.poems.services;

import com.irlix.poems.dto.PoemDto;

import java.util.List;

public interface PoemService {
    List<PoemDto> getAllPoems();

    PoemDto getPoemById(Long id);

    PoemDto createPoem(PoemDto poemDto);

    PoemDto updatePoem(Long id, PoemDto poemDto);

    void deletePoem(Long id);
}
