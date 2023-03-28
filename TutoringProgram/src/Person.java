public class Person {
    private String name;
    private String emailAddress;
    private String grade;
    private String subject;
    private String quarterForTutoring;

    public Person(String name, String emailAddress, String grade, String subject, String quarterForTutoring) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.grade = grade;
        this.subject = subject;
        this.quarterForTutoring = quarterForTutoring;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
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