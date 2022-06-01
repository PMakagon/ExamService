package examservice.controller;

import examservice.domain.Question;
import examservice.service.MathQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/get")
    public Collection<Question> getQuestions() {
        return mathQuestionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.remove(new Question(question, answer));
    }
}
