package exams;

public class MultipleChoiceExam extends Exam {

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        validatePoints(actualPoints);
        if (actualPoints * 100. / getMaxPoints() >= 51) {
            setExamResult(ExamResult.PASSED);
        }
        else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }

    private void validatePoints(int actualPoints) {
        if (actualPoints < 0 || actualPoints > getMaxPoints()) {
            throw new IllegalArgumentException("Points of exam shoud be between 0 and " + getMaxPoints());
        }
    }
}
