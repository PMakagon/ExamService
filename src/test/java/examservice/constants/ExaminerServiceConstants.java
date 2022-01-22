package examservice.constants;

import examservice.domain.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ExaminerServiceConstants {
    public static final String QUESTION = "a";
    public static final String ANSWER = "a";
    public static final Question CORRECT_QUESTION = new Question("a", "a");
    public static final Question CORRECT_QUESTION2 = new Question("c", "c");
    public static final Collection<Question> CORRECT_COLLECTION = Set.of(CORRECT_QUESTION, CORRECT_QUESTION2);
    public static final int CORRECT_AMOUNT = CORRECT_COLLECTION.size();
}
