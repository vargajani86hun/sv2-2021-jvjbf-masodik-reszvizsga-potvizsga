package exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {
    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoint) {
        exams.add(exam);
        exam.calculateExamResult(actualPoint);
    }

    public int countPassedExams() {
        int i = 0;
        for (Exam e : exams) {
            if (e.isSuccess()) {
                i++;
            }
        }
        return i;
    }

    public List<Exam> findById(long studentId) {
        List<Exam> results = new ArrayList<>();
        for (Exam e : exams) {
            if (e.getStudentId() == studentId) {
                results.add(e);
            }
        }
        return results;
    }

    public List<String> findTopicByPrefix(String topicPrefix) {
        List<String> results = new ArrayList<>();
        for (Exam e : exams) {
            if (e.getTopic().startsWith(topicPrefix) && !results.contains(e.getTopic())) {
                results.add(e.getTopic());
            }
        }
        return results;
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }
}
