package com.irlix.poems.services.impl;

import com.irlix.poems.dto.PoemDto;
import com.irlix.poems.entities.Poem;
import com.irlix.poems.exceptions.PoemNotFoundExceptions;
import com.irlix.poems.repositories.PoemRepository;
import com.irlix.poems.services.PoemService;
import com.irlix.poems.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoemServiceImpl implements PoemService {
    private final PoemRepository poemRepository;
    private final Mapper mapper;

    @Autowired
    public PoemServiceImpl(PoemRepository poemRepository, Mapper mapper) {
        this.poemRepository = poemRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PoemDto> getAllPoems() {
        return poemRepository.findAll().stream().map(mapper::mapToPoemDto).collect(Collectors.toList());
    }

    @Override
    public PoemDto getPoemById(Long id) {
        return poemRepository.findById(id).map(mapper::mapToPoemDto).orElseThrow(() -> new PoemNotFoundExceptions("Poem not found"));
    }

    @Override
    public PoemDto createPoem(PoemDto poemDto) {
        Poem poem = mapper.mapToPoem(poemDto);
        poemRepository.save(poem);
        return mapper.mapToPoemDto(poem);
    }

    @Override
    public PoemDto updatePoem(Long id, PoemDto poemDto) {
        Poem poem = poemRepository.findById(id).orElseThrow(() -> new PoemNotFoundExceptions("Poem not found"));
        poem.setTitle(poemDto.getTitle());
        poem.setText(poemDto.getText());
        poemRepository.save(poem);
        return mapper.mapToPoemDto(poem);
    }

    @Override
    public void deletePoem(Long id) {
        poemRepository.deleteById(id);
    }
}
