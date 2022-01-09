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

    private final MathQuestionRepository mathRepository;

    public MathQuestionService(MathQuestionRepository mathRepository) {
        this.mathRepository = mathRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathRepository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        mathRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return mathRepository.getAll().stream().skip(random.nextInt(mathRepository.size())).findFirst().orElse(null);
    }
}
