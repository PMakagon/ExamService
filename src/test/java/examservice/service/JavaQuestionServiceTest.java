package examservice.service;

import examservice.exceptions.NoQuestionsAddedException;
import examservice.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static examservice.constants.ExaminerServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository repositoryMock;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void shouldReturnAddedByObjectJavaQuestion() {
        when(repositoryMock.add(CORRECT_QUESTION))
                .thenReturn(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_QUESTION));
    }

    @Test
    public void shouldReturnAddedByParamsJavaQuestion() {
        when(repositoryMock.add(QUESTION, ANSWER))
                .thenReturn(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, out.add(QUESTION, ANSWER));
    }

    @Test
    public void shouldReturnRemovedQuestion() {
        when(repositoryMock.remove(CORRECT_QUESTION))
                .thenReturn(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, out.remove(CORRECT_QUESTION));
    }

    @Test
    public void shouldReturnCorrectCollection() {
        when(repositoryMock.getAll())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(CORRECT_COLLECTION, out.getAll());
    }

}
