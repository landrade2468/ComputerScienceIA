import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PairTuteeForm extends JFrame {
    private JPanel panel;
    private JTextField tuteeBeingPaired;
    private JButton pairTuteeButton;
    private JTextField tutoringPair;
    private static List<Tutor> listOfTutors;
    private static List<Tutee> listOfTutees;
    private String pair;

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
                List<String> commonCategories = new ArrayList<String>(3);
                for (int i = 0; i < listOfTutors.size(); i++) {
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
                    listOfTutors.get(i).setSum(sum);
                    listOfTutors.get(i).setCommonCategories(commonCategories);
                }
                String tutorName = "";
                while (!foundPerfectTutor) {
                    for (Tutor tutor : listOfTutors) {
                        int sumOfCategories = tutor.getSum();
                        int max = 0;
                        if (sumOfCategories > 0) {
                            max = sumOfCategories;
                            tutorName = tutor.getName();
                            pair = "Tutee Name: " + tuteeName + "\nTutee Contact Information: " + tuteeEmailAddress + "\nTutor Name: " + tutorName + "\nTutor Contact Information: " + tutor.getEmailAddress() + "\nCommon Categories: " + tutor.getCommonCategories();
                        }
                    }
                    foundPerfectTutor = true;
                }
                tutoringPair.setText(pair);
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