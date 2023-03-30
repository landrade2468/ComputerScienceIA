import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PairTuteeForm extends JFrame {
    private JPanel panel;
    private JTextField tuteeBeingPaired;
    private JButton pairTuteeButton;
    private JTextField tuteeNameTextField;
    private JTextField tutorNameTextField;
    private JTextField commonCategoriesTextField;
    private JTextField tuteeContactTextField;
    private JTextField tutorContactTextField;
    private static List<Tutor> listOfTutors;
    private static List<Tutee> listOfTutees;
    private String tuteeNamePartOfPair;
    private String tuteeContactPartOfPair;
    private String tutorNamePartOfPair;
    private String tutorContactPartOfPair;
    private String commonCategoriesBetweenThePairs;

    public PairTuteeForm (List<Tutor> listOfTutors, List<Tutee> listOfTutees) {
        PairTuteeForm.listOfTutors = listOfTutors;
        PairTuteeForm.listOfTutees = listOfTutees;
        setContentPane(panel);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pairTuteeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String tuteeName = tuteeBeingPaired.getText();
                String tuteeEmailAddress = "";
                String tuteeGrade = "";
                String tuteeSubject = "";
                String tuteeQuarter = "";
                boolean notFound = true;
                while (notFound) {
                    for (Tutee tutee : listOfTutees) {
                        int compareTutees = tuteeName.compareTo(tutee.getName());
                        if (compareTutees == 0) {
                            tuteeEmailAddress = tutee.getEmailAddress();
                            tuteeGrade = tutee.getGrade();
                            tuteeSubject = tutee.getSubject();
                            tuteeQuarter = tutee.getQuarterForTutoring();
                            notFound = false;
                        }
                    }
                }
                boolean foundPerfectTutor = false;
                for (Tutor tutor : listOfTutors) {
                    int sum = 0;
                    List<String> commonCategories = new ArrayList<>(3);
                    if (tuteeGrade.equals(tutor.getGrade())) {
                        sum += 1;
                        commonCategories.add(tuteeGrade);
                    }
                    if (tuteeSubject.toLowerCase().compareTo(tutor.getSubject().toLowerCase()) == 0) {
                        sum += 1;
                        commonCategories.add(tuteeSubject);
                    }
                    if (tuteeQuarter.equals(tutor.getQuarterForTutoring())) {
                        sum += 1;
                        commonCategories.add(tuteeQuarter);
                    }
                    tutor.setSum(sum);
                    tutor.setCommonCategories(commonCategories);
                }
                while (!foundPerfectTutor) {
                    int max = 0;
                    for (Tutor tutor : listOfTutors) {
                        int sumOfCategories = tutor.getSum();
                        if (sumOfCategories > max) {
                            max = sumOfCategories;
                            tuteeNamePartOfPair = tuteeName;
                            tuteeContactPartOfPair = tuteeEmailAddress;
                            tutorNamePartOfPair = tutor.getName();
                            tutorContactPartOfPair = tutor.getEmailAddress();
                            commonCategoriesBetweenThePairs = tutor.getCommonCategories();
                        }
                    }
                    foundPerfectTutor = true;
                }
                tuteeNameTextField.setText(tuteeNamePartOfPair);
                tuteeContactTextField.setText(tuteeContactPartOfPair);
                tutorNameTextField.setText(tutorNamePartOfPair);
                tutorContactTextField.setText(tutorContactPartOfPair);
                commonCategoriesTextField.setText(commonCategoriesBetweenThePairs);
                for (int i = 0; i < listOfTutees.size(); i++) {
                    if (tuteeName.compareTo(listOfTutees.get(i).getName()) == 0) {
                        listOfTutees.remove(i);
                    }
                }
                for (int i = 0; i < listOfTutors.size(); i++) {
                    if (tutorNamePartOfPair.compareTo(listOfTutors.get(i).getName()) == 0) {
                        listOfTutors.remove(i);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        PairTuteeForm pairTuteeForm = new PairTuteeForm(listOfTutors, listOfTutees);
    }
}