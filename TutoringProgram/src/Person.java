/**
 * A superclass that encompasses the similar characteristics between the tutees and tutors
 */
public class Person {
    private String name;
    private String emailAddress;
    private String grade;
    private String subject;
    private String quarterForTutoring;

    /**
     * Creates an instance of the Person class
     * @param name the name of the person
     * @param emailAddress the email of the person
     * @param grade the grade of the person
     * @param subject the subject of the person
     * @param quarterForTutoring the quarter of the person during which tutoring will occur
     */
    public Person(String name, String emailAddress, String grade, String subject, String quarterForTutoring) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.grade = grade;
        this.subject = subject;
        this.quarterForTutoring = quarterForTutoring;
    }

    /**
     * A getter method that returns the name of the person
     * @return the name of the person
     */
    public String getName() {
        return name;
    }
    /**
     * A getter method that returns the email address of the person
     * @return the email address of the person
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * A getter method that returns the grade of the person
     * @return the grade of the person
     */
    public String getGrade() {
        return grade;
    }
    /**
     * A getter method that returns the subject of the person
     * @return the subject of the person
     */
    public String getSubject() {
        return subject;
    }
    /**
     * A getter method that returns the quarter of the person during which tutoring will occur
     * @return the quarter of the person during which tutoring will occur
     */
    public String getQuarterForTutoring() {
        return quarterForTutoring;
    }
}