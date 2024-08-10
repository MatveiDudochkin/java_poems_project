package com.irlix.poems.controllers;

import com.irlix.poems.dto.PoemDto;
import com.irlix.poems.services.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poem")
public class PoemController {
    private final PoemService poemService;

    @Autowired
    public PoemController(PoemService poemService) {
        this.poemService = poemService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PoemDto>> getAllPoems() {
        return new ResponseEntity<>(poemService.getAllPoems(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoemDto> getPoemById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(poemService.getPoemById(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PoemDto> createPoem(@RequestBody PoemDto poemDto) {
        return new ResponseEntity<>(poemService.createPoem(poemDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PoemDto> updatePoem(@PathVariable("id") Long id, @RequestBody PoemDto poemDto) {
        PoemDto response = poemService.updatePoem(id, poemDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePoem(@PathVariable("id") Long id) {
        poemService.deletePoem(id);
        return new ResponseEntity<>("Poem deleted", HttpStatus.OK);
    }
}
