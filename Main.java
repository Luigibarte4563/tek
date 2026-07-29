import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class javajava extends JFrame {
    public static void main(String[] args){

        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 300;


        Color lightBlue = new Color(70, 170, 255);

        JFrame frame = new JFrame("Student Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Information System!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16)); 
        frame.add(welcomeLabel, BorderLayout.NORTH); 
        
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(lightBlue);
        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField(10);
        nameField.setToolTipText("Enter the student's name here.");

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(5);
        ageField.setToolTipText("Enter the student's age here.");
        JButton addButton = new JButton("Add Student");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(addButton);
        frame.add(inputPanel, BorderLayout.NORTH);

        JTextArea studentListArea = new JTextArea(10, 20);
        studentListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(studentListArea);
        frame.add(scrollPane, BorderLayout.CENTER); 

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.setBackground(lightBlue);
        JLabel searchLabel = new JLabel("Search name:");
        JTextField searchField = new JTextField(10);
        JButton searchButton = new JButton("search");

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        frame.add(searchPanel, BorderLayout.SOUTH);

        ArrayList<String> studentNamesList = new ArrayList<>();
        ArrayList<String> studentAgesList = new ArrayList<>();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = nameField.getText();
                String age = ageField.getText();
                if(!name.isEmpty() && !age.isEmpty()){
                    studentNamesList.add(name);
                    studentAgesList.add(age);
                    studentListArea.append(name + " (Age: " + age + ") \n" );
                    JOptionPane.showMessageDialog(frame, "Student added successfully.");
                    nameField.setText("");
                    ageField.setText("");
                }else{
                    JOptionPane.showMessageDialog(frame, "Please enter both name and age.");
                }

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String searchName = searchField.getText();
                if(!searchName.isEmpty()){
                    int index = studentNamesList.indexOf(searchName);
                    if(index != -1){
                        JOptionPane.showMessageDialog(frame, "Student found: " + searchName + ", Age: " + studentAgesList.get(index));
                        searchField.setText("");
                    }else{
                        JOptionPane.showMessageDialog(frame, "Student not found");
                        searchField.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Please enter a name to search.");
                }
            }
        });

        frame.setVisible(true);

    }
}