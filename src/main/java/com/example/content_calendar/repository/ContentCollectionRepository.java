package com.example.content_calendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Repository;
import com.example.content_calendar.model.Content;
import com.example.content_calendar.model.Status;
import com.example.content_calendar.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findById(Integer id) {
        return contents.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(
            1,
            "My first blog post",
            "My first blog post",
            Status.IDEA,
            Type.ACTICLE,
            LocalDateTime.now(),
            null,
            ""
        );

        contents.add(c);
    }

    public void save(Content c) {
        contents.removeIf(e -> e.id().equals(c.id()));
        contents.add(c);
    }

    public void delete(Integer id) {
        contents.removeIf(e -> e.id().equals(id));
    }
}
