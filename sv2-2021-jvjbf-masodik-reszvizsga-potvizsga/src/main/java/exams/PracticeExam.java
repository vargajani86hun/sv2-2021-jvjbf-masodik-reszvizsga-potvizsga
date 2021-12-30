package exams;

import java.util.List;

public class PracticeExam extends Exam {
    public PracticeExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public PracticeExam(long studentId, String topic, List<Integer> pointsOfTasks) {
        super(studentId, topic);
        setMaxPoints(getMaxPoints(pointsOfTasks));
    }

    @Override
    public void calculateExamResult(int actualPoints) { //51 és 76 százalék
        double percentage = actualPoints * 100. / getMaxPoints();
        if (percentage < 51) {
            setExamResult(ExamResult.NOT_PASSED);
        }
        else if (percentage < 76) {
            setExamResult(ExamResult.OK);
        }
        else {
            setExamResult(ExamResult.PERFECT);
        }
    }

    private int getMaxPoints(List<Integer> pointsOfTasks) {
        int sum = 0;
        for (Integer i : pointsOfTasks) {
            sum += i;
        }
        validateMaxPoints(sum);
        return sum;
    }

    private void validateMaxPoints(int maxPoints) {
        if (maxPoints < 10 || maxPoints > 150) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + maxPoints);
        }
    }
}
