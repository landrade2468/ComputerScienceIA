public class Person {
    private String name;
    private String schoolEmailAddress;
    private String grade;
    private String subject;
    private String quarterForTutoring;

    public Person(String name, String schoolEmailAddress, String grade, String subject, String quarterForTutoring) {
        this.name = name;
        this.schoolEmailAddress = schoolEmailAddress;
        this.grade = grade;
        this.subject = subject;
        this.quarterForTutoring = quarterForTutoring;
    }

    public String getName() {
        return name;
    }

    public String getSchoolEmailAddress() {
        return schoolEmailAddress;
    }

    public String getGrade() {
        return grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getQuarterForTutoring() {
        return quarterForTutoring;
    }
}
