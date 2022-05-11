package com.guanghui.springbootreact.controller;

import com.guanghui.springbootreact.entity.Tutorial;
import com.guanghui.springbootreact.exception.ResourceNotFoundException;
import com.guanghui.springbootreact.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tutorials")
public class TutorialController {
    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping()
    public ResponseEntity<List<Tutorial>> getAll(@RequestParam(required = false) String title, @RequestParam(required = false) String description) {
        try {
            List<Tutorial> tutorials = new ArrayList<>();
            if (title != null)
                tutorials.addAll(tutorialRepository.findByTitleContainingIgnoreCase(title));
            else if (description != null)
                tutorials.addAll(tutorialRepository.getByDescriptionNativeParam(description));
//                tutorials.addAll(tutorialRepository.getByDescription(description));
            else
                tutorials.addAll(tutorialRepository.findAll());

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{tutorialId}")
    public Tutorial getTutorialById(@PathVariable("tutorialId") long tutorialId) throws ResourceNotFoundException {
        Optional<Tutorial> tutorialDb = tutorialRepository.findById(tutorialId);

        if (tutorialDb.isEmpty()) {
            throw new ResourceNotFoundException(tutorialId);
        }

        return tutorialDb.get();
    }

    @PostMapping()
    public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
        return tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
    }

    @PutMapping("{tutorialId}")
    public Tutorial updateTutorial(@PathVariable("tutorialId") long tutorialId, @RequestBody Tutorial tutorial) throws ResourceNotFoundException {
        Optional<Tutorial> tutorialDb = tutorialRepository.findById(tutorialId);

        if (tutorialDb.isEmpty()) {
            throw new ResourceNotFoundException(tutorialId);
        } else {
            Tutorial t = tutorialDb.get();

            String title = tutorial.getTitle();
            if (Objects.nonNull(title) && !title.equals("")) {
                t.setTitle(title);
            }

            String description = tutorial.getDescription();
            if (Objects.nonNull(description) && !description.equals("")) {
                t.setDescription(description);
            }

            Boolean published = tutorial.getPublished();
            t.setPublished(published);

            return tutorialRepository.save(t);
        }
    }

    @PatchMapping()
    public ResponseEntity<Tutorial> updateTutorialDescriptionByName(@RequestBody Tutorial tutorial) {
        if (tutorialRepository.updateDescriptionByTitle(tutorial.getTitle(), tutorial.getDescription()) > 0) {
            // return the real entity
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{tutorialId}")
    public void deleteTutorial(@PathVariable("tutorialId") long tutorialId) {
        tutorialRepository.deleteById(tutorialId);
    }

    @DeleteMapping("")
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    @GetMapping("/published")
    public List<Tutorial> findByPublished() {
        return tutorialRepository.findByPublished(true);
    }
}
