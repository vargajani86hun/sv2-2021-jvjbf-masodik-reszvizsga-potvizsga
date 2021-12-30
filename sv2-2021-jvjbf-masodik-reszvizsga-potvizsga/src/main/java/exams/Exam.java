package exams;

public abstract class Exam {
    private long studentId;
    private String topic;
    private int maxPoints = 100;
    private ExamResult examResult;

    public Exam(long studentId, String topic, int maxPoints) {
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = maxPoints;
    }

    public Exam(long studentId, String topic) {
        this.studentId = studentId;
        this.topic = topic;
    }

    public abstract void calculateExamResult(int actualPoints);

    public long getStudentId() {
        return studentId;
    }

    public String getTopic() {
        return topic;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public ExamResult getExamResult() {
        return examResult;
    }

    public boolean isSuccess() {
        return !(examResult == ExamResult.NOT_PASSED);
    }

    protected void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    protected void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
}
