package examservice.repository;

import examservice.domain.Question;
import examservice.exceptions.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static examservice.constants.ExaminerServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionRepositoryTest {
    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    public void shouldReturnAddedByParametersQuestion() {
        Question result = out.add(QUESTION, ANSWER);
        assertEquals(CORRECT_QUESTION, result);
    }

    @Test
    public void shouldReturnAddedByObjectQuestion() {
        Question result = out.add(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, result);
    }

    @Test
    public void shouldReturnRemovedQuestion() {
        out.add(CORRECT_QUESTION);
        Question result = out.remove(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, result);
    }

    @Test
    public void shouldReturnCorrectCollection() {
        out.add(CORRECT_QUESTION);
        out.add(CORRECT_QUESTION2);
        Collection<Question> result = out.getAll();
        assertIterableEquals(CORRECT_COLLECTION, result);
    }

}
