import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PairTuteeForm extends JFrame {
    private JPanel panel;
    private JTextField tuteeBeingPaired;
    private JButton pairTuteeButton;
    private JButton displayPair;
    private static List<Tutor> listOfTutors;
    private static List<Tutee> listOfTutees;
    private String pair;

    public PairTuteeForm (List<Tutor> listOfTutors, List<Tutee> listOfTutees) {
        PairTuteeForm.listOfTutors = listOfTutors;
        PairTuteeForm.listOfTutees = listOfTutees;
        setContentPane(panel);
        setSize(800, 800);
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
                    for (Tutee listOfTutee : listOfTutees) {
                        int compareTutees = tuteeName.compareTo(listOfTutee.getName());
                        if (compareTutees == 0) {
                            tuteeEmailAddress = listOfTutee.getSchoolEmailAddress();
                            tuteeGrade = listOfTutee.getGrade();
                            tuteeSubject = listOfTutee.getSubject();
                            tuteeQuarter = listOfTutee.getQuarterForTutoring();
                            notFound = false;
                        }
                    }
                }
                boolean foundPerfectTutor = false; //Remember to set findPerfectTutor to true after finding the best tutor
                int sum = 0;
                List<String> commonCategories = new ArrayList<>();
                for (int i = 0; i < listOfTutors.size(); i++) {
                    if (tuteeGrade.toLowerCase().compareTo(listOfTutees.get(i).getGrade().toLowerCase()) == 0) {
                        sum += 1;
                        commonCategories.add(tuteeGrade);
                    }
                    if (tuteeSubject.toLowerCase().compareTo(listOfTutees.get(i).getSubject().toLowerCase()) == 0) {
                        sum += 1;
                        commonCategories.add(tuteeSubject);
                    }
                    if (tuteeQuarter.toLowerCase().compareTo(listOfTutees.get(i).getQuarterForTutoring().toLowerCase()) == 0) {
                        sum += 1;
                        commonCategories.add(tuteeQuarter);
                    }
                    listOfTutors.get(i).setSum(sum);
                    listOfTutors.get(i).setCommonCategories(commonCategories);
                }
                String tutorName = "";
                while (!foundPerfectTutor) {
                    for (int i = 0; i < listOfTutors.size(); i++) {
                        int sumOfCategories = listOfTutors.get(i).getSum();
                        int max = 0;
                        if (sumOfCategories > 0) {
                            max = sumOfCategories;
                            tutorName = listOfTutors.get(i).getName();
                            String pair = "Tutee Name: " + tuteeName + "\nTutee Contact Information: " + tuteeEmailAddress + "\nTutor Name: " + tutorName + "\nTutor Contact Information: " + listOfTutors.get(i).getSchoolEmailAddress() + "\nCommon Categories: " + listOfTutors.get(i).getCommonCategories();
                        }
                    }
                    foundPerfectTutor = true;
                }
                for (int i = 0; i < listOfTutees.size(); i++) {
                    if (tuteeName.compareTo(listOfTutees.get(i).getName()) == 0) {
                        listOfTutees.remove(i);
                    }
                }
                for (int i = 0; i < listOfTutors.size(); i++) {
                    if (tutorName.compareTo(listOfTutors.get(i).getName()) == 0) {
                        listOfTutors.remove(i);
                    }
                }
            }
        });
        displayPair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Find a way to display all of said information on the GUI
            }
        });
    }

    public static void main(String[] args) {
        PairTuteeForm pairTuteeForm = new PairTuteeForm(listOfTutors, listOfTutees);
    }
}
