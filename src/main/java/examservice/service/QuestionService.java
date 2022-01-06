package examservice.service;

import examservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    String add(String question,String answer);
    String add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
