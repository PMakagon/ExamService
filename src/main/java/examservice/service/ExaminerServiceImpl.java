package examservice.service;

import examservice.domain.Question;
import examservice.exceptions.QuestionAmountException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionServices;

    public ExaminerServiceImpl(QuestionService questionServices) {
        this.questionServices = questionServices;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        ArrayList<Question> questionsList = new ArrayList<>(amount);
        if(questionServices.getAll().size()<amount){
            throw new QuestionAmountException();
        }
        while (amount>0){
            Question questionToAdd = questionServices.getRandomQuestion();
            if(!questionsList.contains(questionToAdd)){
                questionsList.add(questionToAdd);
                amount--;
            }
        }
        return Collections.unmodifiableCollection(questionsList);
    }
}
