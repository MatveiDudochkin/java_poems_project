package com.irlix.poems.repositories;

import com.irlix.poems.entities.Poem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoemRepository extends JpaRepository<Poem, Long> {
}
