/**
 * A subclass that extends Person to differentiate between tutors and tutees
 */
public class Tutee extends Person {
    /**
     * Creates an instance of the Tutee class with the variables in the superclass, Person
     * @param name the name of the tutee
     * @param emailAddress the email address of the tutee
     * @param grade the grade of the tutee
     * @param subject the subject of the tutee
     * @param quarterForTutoring the quarter during which the tutee will be tutored
     */
    public Tutee(String name, String emailAddress, String grade, String subject, String quarterForTutoring) {
        super(name, emailAddress, grade, subject, quarterForTutoring);
    }
}