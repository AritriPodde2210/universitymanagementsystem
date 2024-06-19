package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox<String> cbSemester, cbOddEven;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton cancel, submit;
    
    EnterMarks() {
        
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("")); // Add an image path if available
//        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(500, 40, 400, 300);
//        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblRollNumber = new JLabel("Select Roll Number");
        lblRollNumber.setBounds(50, 70, 150, 20);
        add(lblRollNumber);
        
        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);
        
        try {
            DatabaseConnection con = new DatabaseConnection();
            ResultSet rs = con.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblOddEven = new JLabel("Select Semester Type");
        lblOddEven.setBounds(50, 110, 150, 20);
        add(lblOddEven);
        
        String[] oddEvenOptions = {"Odd", "Even"};
        cbOddEven = new JComboBox<>(oddEvenOptions);
        cbOddEven.setBounds(200, 110, 150, 20);
        cbOddEven.setBackground(Color.WHITE);
        cbOddEven.addActionListener(this);
        add(cbOddEven);
        
        JLabel lblSemester = new JLabel("Select Semester");
        lblSemester.setBounds(50, 150, 150, 20);
        add(lblSemester);
        
        cbSemester = new JComboBox<>();
        cbSemester.setBounds(200, 150, 150, 20);
        cbSemester.setBackground(Color.WHITE);
        updateSemesters();
        add(cbSemester);
        
        JLabel lblEnterSubject = new JLabel("Enter Subject");
        lblEnterSubject.setBounds(100, 190, 200, 40);
        add(lblEnterSubject);
        
        JLabel lblEnterMarks = new JLabel("Enter Marks");
        lblEnterMarks.setBounds(320, 190, 200, 40);
        add(lblEnterMarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 230, 200, 20);
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 260, 200, 20);
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 290, 200, 20);
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 320, 200, 20);
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 350, 200, 20);
        add(tfsub5);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250, 230, 200, 20);
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250, 260, 200, 20);
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250, 290, 200, 20);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250, 320, 200, 20);
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250, 350, 200, 20);
        add(tfmarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(70, 390, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(280, 390, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                DatabaseConnection con = new DatabaseConnection();
                
                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"')";
                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";
            
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cbOddEven) {
            updateSemesters();
        } else {
            setVisible(false);
        }
    }
    
    private void updateSemesters() {
        String selectedType = (String) cbOddEven.getSelectedItem();
        cbSemester.removeAllItems();
        
        if ("Odd".equals(selectedType)) {
            cbSemester.addItem("1st Semester");
            cbSemester.addItem("3rd Semester");
            cbSemester.addItem("5th Semester");
            cbSemester.addItem("7th Semester");
        } else if ("Even".equals(selectedType)) {
            cbSemester.addItem("2nd Semester");
            cbSemester.addItem("4th Semester");
            cbSemester.addItem("6th Semester");
            cbSemester.addItem("8th Semester");
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
