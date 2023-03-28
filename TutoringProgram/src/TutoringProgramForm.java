import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TutoringProgramForm extends JFrame {
    private JTextField name;
    private JTextField email;
    private JTextField grade;
    private JTextField subject;
    private JTextField quarter;
    private JButton tutorButton;
    private JButton tuteeButton;
    private JPanel panel;
    private JButton pairTutee;
    private List<Tutor> listOfTutors;
    private List<Tutee> listOfTutees;
    private List<String> commonCategories;

    public TutoringProgramForm() {
        listOfTutors = new ArrayList<>();
        listOfTutees = new ArrayList<>();
        setContentPane(panel);
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        tutorButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameInput = name.getText();
                String emailInput = email.getText();
                String gradeInput = grade.getText();
                String subjectInput = subject.getText();
                String quarterInput = quarter.getText();
                Tutor tutor = new Tutor(nameInput, emailInput, gradeInput, subjectInput, quarterInput, 0, commonCategories);
                listOfTutors.add(tutor);
            }
        });
        tuteeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameInput = name.getText();
                String emailInput = email.getText();
                String gradeInput = grade.getText();
                String subjectInput = subject.getText();
                String quarterInput = quarter.getText();
                Tutee tutee = new Tutee(nameInput, emailInput, gradeInput, subjectInput, quarterInput);
                listOfTutees.add(tutee);
            }
        });
        pairTutee.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                PairTuteeForm pairTuteeForm = new PairTuteeForm(listOfTutors, listOfTutees);
            }
        });
    }

    public static void main(String[] args) {
        TutoringProgramForm tutoringForm = new TutoringProgramForm();
    }
}