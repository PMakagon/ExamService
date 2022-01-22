package examservice.service;

import examservice.domain.Question;
import examservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Random;


@Service
@Primary
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository repository;
    private final Random random;


    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository repository) {
        this.repository = repository;
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return repository.getAll().stream()
                .skip(random.nextInt(repository.size()))
                .findFirst()
                .orElseThrow();
    }
}
