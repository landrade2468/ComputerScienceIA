import java.util.List;

public class Tutor extends Person {
    private int sum;
    private List<String> commonCategories;
    public Tutor(String name, String schoolEmailAddress, String grade, String subject, String quarterForTutoring, int sum, List<String> commonCategories) {
        super(name, schoolEmailAddress, grade, subject, quarterForTutoring);
        this.sum = sum;
        this.commonCategories = commonCategories;
    }

    public void setSum(int updatedSum) {
        this.sum = updatedSum;
    }

    public int getSum() {
        return sum;
    }

    public void setCommonCategories(List<String> updatedCommonCategories) {
        this.commonCategories = updatedCommonCategories;
    }
    public String getCommonCategories() {
        return commonCategories.toString();
    }
}
