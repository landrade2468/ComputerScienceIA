import java.util.ArrayList;
import java.util.List;
/**
 * A subclass that extends Person and adds additional characteristics for tutors
 */
public class Tutor extends Person {
    private int sum;
    private List<String> commonCategories;

    /**
     * Creates an instance of the Tutor class that includes the variables of the superclass, Person
     * @param name the name of the tutor
     * @param emailAddress the email address of the tutor
     * @param grade the grade of the tutor
     * @param subject the subject which the tutor is teaching
     * @param quarterForTutoring the quarter during which the tutor will help the tutee
     * @param sum the sum of the similarities between the tutor and tutee
     * @param commonCategories a list of the similarities between the tutor and tutee
     */
    public Tutor(String name, String emailAddress, String grade, String subject, String quarterForTutoring, int sum, List<String> commonCategories) {
        super(name, emailAddress, grade, subject, quarterForTutoring);
        this.sum = sum;
        commonCategories = new ArrayList<>(3);
        this.commonCategories = commonCategories;
    }

    /**
     * A setter which sets the sum of the similarities between the tutor and tutee after comparing the two
     * @param updatedSum the sum of the similarities between the tutor and tutee after comparing the two
     */
    public void setSum(int updatedSum) {
        this.sum = updatedSum;
    }

    /**
     * A getter which returns the sum of the similarities between the tutor and tutee
     * @return the sum of the similarities between the tutor and tutee
     */
    public int getSum() {
        return sum;
    }

    /**
     * A setter which sets the list of similarities between the tutor and tutee after comparing the two
     * @param updatedCommonCategories the list of similarities between the tutor and tutee after comparing the two
     */
    public void setCommonCategories(List<String> updatedCommonCategories) {
        this.commonCategories = updatedCommonCategories;
    }

    /**
     * A getter which returns the list of similarities between the tutor and tutee
     * @return the list of the similarities between the tutor and tutee as a string
     */
    public String getCommonCategories() {
        return commonCategories.toString();
    }
}