package examservice.controller;

import examservice.domain.Question;
import examservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
//    http://localhost:8080/exam/admin/add?question=a&answer=b
//    http://localhost:8080/exam/admin/add1?question=a
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/admin/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer){
        return questionService.add(question,answer);
    }
    @GetMapping("/admin/add1")
    public Question addQuestion(@RequestParam String question){
        return questionService.add(question,"Test");
    }

    @GetMapping("/admin/get")
    public Collection<Question> getQuestions(){
        return questionService.getAll();
    }

    @GetMapping("/admin/remove")
    public Question removeQuestion(@RequestParam String question,@RequestParam String answer){
        return questionService.remove(new Question(question,answer));
    }
}
