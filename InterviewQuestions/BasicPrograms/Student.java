package InterviewQuestions.BasicPrograms;

public class Student {
    private String studentName;
    private Integer studentNumber;

    Student(String studentName, Integer studentNumber) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }
}
