package examservice.service;

import examservice.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class JavaQuestionService implements QuestionService{

    HashSet<Question> questions = new HashSet<>();

    @Override
    public String add(String question, String answer) {
        questions.add(new Question(question,answer));
        return question;
    }

    @Override
    public String add(Question question) {
        questions.add(question);
        return question.toString();
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
