package examservice.constants;

import examservice.domain.Question;

import java.util.Collection;
import java.util.List;

public class ExaminerServiceConstants {
    public static final String QUESTION = "a";
    public static final String ANSWER = "a";
    public static final Question CORRECT_QUESTION = new Question("b", "b");
    public static final Question CORRECT_QUESTION2 = new Question("c", "c");
    public static final Collection<Question> CORRECT_COLLECTION = List.of(CORRECT_QUESTION, CORRECT_QUESTION2);
    public static final int CORRECT_AMOUNT = CORRECT_COLLECTION.size();
}
