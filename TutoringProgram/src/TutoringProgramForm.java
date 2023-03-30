import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *  A GUI that takes in the information for individual tutors and tutees and links to the other GUI after all information is inputted
 */
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

    /**
     * Creates an instance of the TutoringProgramForm class
     */
    public TutoringProgramForm() {
        listOfTutors = new ArrayList<>();
        listOfTutees = new ArrayList<>();
        setContentPane(panel);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        tutorButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the button to add to the list of tutors is clicked
             * @param e the tutor that needs to be processed and added to the list of tutors
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
             * Invoked when the button to add to the list of tutees is clicked
             * @param e the tutee that needs to be processed and added to the list of tutees
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
             * Invoked when the button to pair the tutee is clicked
             * @param e the event that, after processing, will generate an instance of the PairTuteeForm GUI
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