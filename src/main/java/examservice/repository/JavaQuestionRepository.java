package examservice.repository;

import examservice.domain.Question;
import examservice.exceptions.QuestionNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


@Repository
@Primary
public class JavaQuestionRepository implements QuestionRepository{

    private final HashSet<Question> questions =new HashSet<>();

    @PostConstruct
    public void init (){
        add("a","a");
        add("b","b");
        add("c","c");
        add("d","d");
        System.out.println("на месте");
    }

    @Override
    public Question add(String question, String answer) {
        Question element = new Question(question,answer);
        questions.add(element);
        return element;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public int size() {
        return questions.size();
    }

    @Override
    public boolean isEmpty() {
        return questions.isEmpty();
    }

}
