package examservice.controller;

import examservice.domain.Question;
import examservice.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java/add")
    public Question addQuestion(String question,String answer){


    }

    @GetMapping("/java")
    public Collection<Question> getQuestion(){

    }

    @GetMapping("/java/remove")
    public Question removeQuestion(String question,String answer){

    }
}
