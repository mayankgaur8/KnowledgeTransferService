package com.avantika.knowledgetransferservice.service;

import com.avantika.knowledgetransferservice.model.Tutorial;
import com.avantika.knowledgetransferservice.repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public List<Tutorial> getAllTutorials() {
        return tutorialRepository.findAll();
    }

    public Optional<Tutorial> getTutorialById(Long id) {
        return tutorialRepository.findById(id);
    }

    public Tutorial createTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public Tutorial updateTutorial(Long id, Tutorial tutorial) {
        if (tutorialRepository.existsById(id)) {
            tutorial.setId(id);
            return tutorialRepository.save(tutorial);
        }
        return null; // Or throw an exception
    }

    public void deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
    }
}
