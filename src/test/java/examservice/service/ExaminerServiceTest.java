package examservice.service;

import examservice.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static examservice.constants.ExaminerServiceConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    public void shouldReturnCollectionOfRandomQuestions() {

        when(questionServiceMock.getRandomQuestion())
                .thenReturn(CORRECT_QUESTION);
                assertEquals(CORRECT_COLLECTION,out.getQuestions(CORRECT_AMOUNT));
    }
}
