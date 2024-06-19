package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateFeeStructure extends JFrame implements ActionListener {

    JTextField tfTotalFees, tfPaidFees, tfDueFees;
    JLabel labelCourse, labelSemester, labelBranch;
    JButton submit, cancel;
    Choice cCourse, cSemester, cBranch;

    UpdateFeeStructure() {

        setSize(900, 650);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Fee Structure");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblCourse = new JLabel("Select Course");
        lblCourse.setBounds(50, 100, 200, 20);
        lblCourse.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblCourse);

        cCourse = new Choice();
        cCourse.setBounds(250, 100, 200, 20);
        add(cCourse);

        JLabel lblSemester = new JLabel("Select Semester");
        lblSemester.setBounds(50, 150, 200, 20);
        lblSemester.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblSemester);

        cSemester = new Choice();
        cSemester.setBounds(250, 150, 200, 20);
        add(cSemester);

        for (int i = 1; i <= 8; i++) {
            cSemester.add(i + " Semester");
        }

        JLabel lblBranch = new JLabel("Select Branch");
        lblBranch.setBounds(50, 200, 200, 20);
        lblBranch.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblBranch);

        cBranch = new Choice();
        cBranch.setBounds(250, 200, 200, 20);
        add(cBranch);

        JLabel lblTotalFees = new JLabel("Total Fees");
        lblTotalFees.setBounds(50, 250, 200, 30);
        lblTotalFees.setFont(new Font("serif", Font.BOLD, 20));
        add(lblTotalFees);

        tfTotalFees = new JTextField();
        tfTotalFees.setBounds(250, 250, 200, 30);
        add(tfTotalFees);

        JLabel lblPaidFees = new JLabel("Paid Fees");
        lblPaidFees.setBounds(50, 300, 200, 30);
        lblPaidFees.setFont(new Font("serif", Font.BOLD, 20));
        add(lblPaidFees);

        tfPaidFees = new JTextField();
        tfPaidFees.setBounds(250, 300, 200, 30);
        add(tfPaidFees);

        JLabel lblDueFees = new JLabel("Due Fees");
        lblDueFees.setBounds(50, 350, 200, 30);
        lblDueFees.setFont(new Font("serif", Font.BOLD, 20));
        add(lblDueFees);

        tfDueFees = new JTextField();
        tfDueFees.setBounds(250, 350, 200, 30);
        add(tfDueFees);

        submit = new JButton("Update");
        submit.setBounds(250, 400, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 400, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        loadCourses(); // Method to load courses into cCourse Choice component

        cCourse.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                updateBranches();
            }
        });

        cSemester.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                updateFeeDetails();
            }
        });

        setVisible(true);
    }

    private void loadCourses() {
        try {
            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs = c.s.executeQuery("select * from course");
            while (rs.next()) {
                cCourse.add(rs.getString("courseName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBranches() {
        cBranch.removeAll(); // Clear existing items
        try {
            DatabaseConnection c = new DatabaseConnection();
            String course = cCourse.getSelectedItem();
            String query = "select branch from course where coursename='" + course + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cBranch.add(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateFeeDetails() {
        try {
            DatabaseConnection c = new DatabaseConnection();
            String course = cCourse.getSelectedItem();
            String semester = cSemester.getSelectedItem();
            String branch = cBranch.getSelectedItem(); // Get selected branch
            String query = "select * from course where coursename='" + course + "' and semester='" + semester + "' and branch='" + branch + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                tfTotalFees.setText(rs.getString("totalFees"));
                tfPaidFees.setText(rs.getString("paidFees"));
                tfDueFees.setText(rs.getString("dueFees"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String course = cCourse.getSelectedItem();
            String semester = cSemester.getSelectedItem();
            String branch = cBranch.getSelectedItem();
            String totalFees = tfTotalFees.getText();
            String paidFees = tfPaidFees.getText();
            String dueFees = tfDueFees.getText();

            try {
                DatabaseConnection c = new DatabaseConnection();
                String query = "update fee set totalFees='" + totalFees + "', paidFees='" + paidFees + "', dueFees='" + dueFees + "' where course='" + course + "' and semester='" + semester + "' and branch='" + branch + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Fee Structure Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateFeeStructure();
    }
}
