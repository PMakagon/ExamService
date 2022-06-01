package examservice.service;

import examservice.domain.Question;
import examservice.exceptions.QuestionAmountException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private final QuestionService mathQuestionService;
    private final List<QuestionService> services ;
    private final Random random;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService,@Qualifier("mathQuestionService") QuestionService mathQuestionService, List<QuestionService> services) {
        this.questionService = questionService;
        this.mathQuestionService = mathQuestionService;
        this.services = services;
        this.random = new Random();
    }



    @Override
    public Collection<Question> getQuestions(int amount) {
       Set<Question> questionsToReturn = new HashSet<>();
        if(questionService.getAll().size()+mathQuestionService.getAll().size()<amount || amount<0){
            throw new QuestionAmountException();
        }

        while (questionsToReturn.size()<amount){
           Question questionToAdd = services.get(random.nextInt(services.size())).getRandomQuestion();
           questionsToReturn.add(questionToAdd);
        }
        return Collections.unmodifiableCollection(questionsToReturn);
    }
}
