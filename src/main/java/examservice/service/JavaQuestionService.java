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
public class JavaQuestionService implements QuestionService{

    private final QuestionRepository repository;

    public JavaQuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        repository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        repository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
       return repository.getAll().stream().skip(random.nextInt(repository.size())).findFirst().orElse(null);
    }
}
