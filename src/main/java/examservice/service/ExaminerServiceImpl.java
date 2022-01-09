package examservice.service;

import examservice.domain.Question;
import examservice.exceptions.QuestionAmountException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private final QuestionService mathQuestionService;
    private final List<QuestionService> services ;

    public ExaminerServiceImpl(QuestionService questionService, QuestionService mathQuestionService, List<QuestionService> services) {
        this.questionService = questionService;
        this.mathQuestionService = mathQuestionService;
        this.services = services;
    }


//    @Override
//    public Collection<Question> getQuestions(int amount) {
//        ArrayList<Question> questionsList = new ArrayList<>(amount);
//        if(questionServices.getAll().size()+mathQuestionService.getAll().size()<amount){
//            throw new QuestionAmountException();
//        }
//        while (amount>0){
//            Question questionToAdd = questionServices.getRandomQuestion();
//            if(!questionsList.contains(questionToAdd)){
//                questionsList.add(questionToAdd);
//                amount--;
//            }
//        }
//        return Collections.unmodifiableCollection(questionsList);
//    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        ArrayList<Question> questionsList = new ArrayList<>();
        if(questionService.getAll().size()+mathQuestionService.getAll().size()<amount){
            throw new QuestionAmountException();
        }
        Random random = new Random();
        while (amount>0){
           Question questionToAdd = services.get(random.nextInt(services.size())).getRandomQuestion();
            if(!questionsList.contains(questionToAdd)) {
                questionsList.add(questionToAdd);
                amount--;
            }
        }
        return Collections.unmodifiableCollection(questionsList);
    }
}
