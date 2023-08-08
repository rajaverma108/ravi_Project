package InterviewQuestions.JDBC.crud;

public class StudentModel {
    private int studentId;
    private String studentName;
    private long studentPhone;
    private String studentCity;

    public StudentModel(int studentId, String studentName, long studentPhone, String studentCity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentCity = studentCity;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(long studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    @Override
    public String toString() {
        return "StudentManagementApp{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentPhone=" + studentPhone +
                ", studentCity='" + studentCity + '\'' +
                '}';
    }
}
