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
                int indexOfTutee = 0;
                while (notFound) {
                    for (int i = 0; i < listOfTutees.size(); i++) {
                        int compareTutees = tuteeName.compareTo(listOfTutees.get(i).getName());
                        if (compareTutees == 0) {
                            tuteeEmailAddress = listOfTutees.get(i).getEmailAddress();
                            tuteeGrade = listOfTutees.get(i).getGrade();
                            tuteeSubject = listOfTutees.get(i).getSubject();
                            tuteeQuarter = listOfTutees.get(i).getQuarterForTutoring();
                            indexOfTutee = i;
                            notFound = false;
                        }
                    }
                }
                boolean foundPerfectTutor = false;
                int sum = 0;
                List<String> commonCategories = new ArrayList<>(3);
                for (Tutor tutor : listOfTutors) {
                    if (tuteeGrade.toLowerCase().compareTo(listOfTutees.get(indexOfTutee).getGrade().toLowerCase()) == 0) {
                        sum += 1;
                        commonCategories.add(tuteeGrade);
                    }
                    if (tuteeSubject.toLowerCase().compareTo(listOfTutees.get(indexOfTutee).getSubject().toLowerCase()) == 0) {
                        sum += 1;
                        commonCategories.add(tuteeSubject);
                    }
                    if (tuteeQuarter.toLowerCase().compareTo(listOfTutees.get(indexOfTutee).getQuarterForTutoring().toLowerCase()) == 0) {
                        sum += 1;
                        commonCategories.add(tuteeQuarter);
                    }
                    tutor.setSum(sum);
                    tutor.setCommonCategories(commonCategories);
                    sum = 0;
                    commonCategories.clear();
                }
                String tutorName = "";
                while (!foundPerfectTutor) {
                    for (Tutor tutor : listOfTutors) {
                        int sumOfCategories = tutor.getSum();
                        int max = 0;
                        if (sumOfCategories > 0) { //Fix max method, so it actually gets the tutor with the most common categories
                            max = sumOfCategories;
                            tutorName = tutor.getName();
                            tuteeNamePartOfPair = tuteeName;
                            tuteeContactPartOfPair = tuteeEmailAddress;
                            tutorNamePartOfPair = tutorName;
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
                if (tuteeName.compareTo(listOfTutees.get(indexOfTutee).getName()) == 0) {
                        listOfTutees.remove(indexOfTutee);
                }
                for (int i = 0; i < listOfTutors.size(); i++) {
                    if (tutorName.compareTo(listOfTutors.get(i).getName()) == 0) {
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