package examservice.service;

import examservice.domain.Question;
import examservice.repository.MathQuestionRepository;
import examservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository mathRepository;
    private final Random random;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository mathRepository) {
        this.mathRepository = mathRepository;
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        return mathRepository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return mathRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return mathRepository.getAll().stream()
                .skip(random.nextInt(mathRepository.size()))
                .findFirst()
                .orElseThrow();
    }
}
