package examservice.repository;

import examservice.domain.Question;
import examservice.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> mathQuestions = new HashSet<>();

    @PostConstruct
    public void init() {
        add("2", "2");
        add("3", "3");
        add("4", "4");
        add("5", "5");
        System.out.println("math на месте");
    }

    @Override
    public Question add(String question, String answer) {
        Question element = new Question(question, answer);
        mathQuestions.add(element);
        return element;
    }

    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!mathQuestions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        mathQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(mathQuestions);
    }

    @Override
    public int size() {
        return mathQuestions.size();
    }

    @Override
    public boolean isEmpty() {
        return mathQuestions.isEmpty();
    }
}
