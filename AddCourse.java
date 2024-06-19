package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCourse extends JFrame implements ActionListener {
    
    // Components
    JLabel titleLabel, courseNameLabel, courseCodeLabel;
    JTextField courseNameField, courseCodeField;
    JButton addButton, clearButton;
    
    // Constructor
    public AddCourse() {
        // Frame setup
        setTitle("Add New Course");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        // Panel for layout
        JPanel panel = new JPanel();
        panel.setLayout(null); // Using absolute positioning
        
        // Title label
        titleLabel = new JLabel("Add New Course");
        titleLabel.setBounds(140, 10, 120, 20);
        panel.add(titleLabel);
        
        // Course name label and field
        courseNameLabel = new JLabel("Course Name:");
        courseNameLabel.setBounds(50, 50, 100, 20);
        panel.add(courseNameLabel);
        
        courseNameField = new JTextField();
        courseNameField.setBounds(160, 50, 150, 20);
        panel.add(courseNameField);
        
        // Course code label and field
        courseCodeLabel = new JLabel("Course Code:");
        courseCodeLabel.setBounds(50, 90, 100, 20);
        panel.add(courseCodeLabel);
        
        courseCodeField = new JTextField();
        courseCodeField.setBounds(160, 90, 150, 20);
        panel.add(courseCodeField);
        
        // Add button
        addButton = new JButton("Add");
        addButton.setBounds(100, 140, 80, 30);
        addButton.addActionListener(this);
        panel.add(addButton);
        
        // Clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(200, 140, 80, 30);
        clearButton.addActionListener(this);
        panel.add(clearButton);
        
        // Add panel to frame
        add(panel);
        
        // Center frame on screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getWidth()/2, dim.height/2 - getHeight()/2);
        
        setVisible(true); // Make frame visible
    }
    
    // Action listener for buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {
            // Perform action for Add button
            String courseName = courseNameField.getText().trim();
            String courseCode = courseCodeField.getText().trim();
            
            // Validate inputs (you can add more validation logic as needed)
            if (courseName.isEmpty() || courseCode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Example: You could save the course details to a database or perform other operations
                // Here we'll just print the details
                System.out.println("Course Name: " + courseName);
                System.out.println("Course Code: " + courseCode);
                
                // Optionally, you could clear the fields after adding
                clearFields();
            }
        } else if (ae.getSource() == clearButton) {
            // Perform action for Clear button
            clearFields();
        }
    }
    
    // Method to clear input fields
    private void clearFields() {
        courseNameField.setText("");
        courseCodeField.setText("");
    }
    
    // Main method for testing
    public static void main(String[] args) {
        new AddCourse();
    }
}
