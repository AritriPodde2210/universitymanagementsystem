package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    
    JMenuItem facultyInfo, studentInfo, facultydetails, studentdetails;
    JMenuItem addCourse, viewCourses, addFees, viewFees, conductExam, viewResults, aboutUs;

    Project() {
        // Set size and layout
        setSize(1550, 850);
        setLayout(new BorderLayout());

        // Background Image
        ImageIcon i1 = new ImageIcon("C:\\Documents\\NetBeansProjects\\University.management.system\\icons\\img1.gif");
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // Menu Bar
        JMenuBar mb = new JMenuBar();
        
        // New Information Menu
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // Details Menu
        JMenu details = new JMenu("Show Details");
        details.setForeground(Color.BLUE);
        mb.add(details);

        facultydetails = new JMenuItem("Show Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        studentdetails = new JMenuItem("Show Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        // Update Info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);
        
        // Courses Menu
        JMenu courses = new JMenu("Courses");
        courses.setForeground(Color.BLUE);
        mb.add(courses);
        
        addCourse = new JMenuItem("Add Course");
        addCourse.setBackground(Color.WHITE);
        addCourse.addActionListener(this);
        courses.add(addCourse);
        
        viewCourses = new JMenuItem("View Courses");
        viewCourses.setBackground(Color.WHITE);
        viewCourses.addActionListener(this);
        courses.add(viewCourses);
        
        // Fees Menu
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        // Examination Menu
        JMenu examination = new JMenu("Examination");
        examination.setForeground(Color.BLUE);
        mb.add(examination);
        
        conductExam = new JMenuItem("Conduct Examination");
        conductExam.setBackground(Color.WHITE);
        conductExam.addActionListener(this);
        examination.add(conductExam);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        examination.add(entermarks);
        
        viewResults = new JMenuItem("View Results");
        viewResults.setBackground(Color.WHITE);
        viewResults.addActionListener(this);
        examination.add(viewResults);
        
        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        // About Us Menu
        JMenu about = new JMenu("About Us");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        aboutUs = new JMenuItem("About Us");
        aboutUs.setBackground(Color.WHITE);
        aboutUs.addActionListener(this);
        about.add(aboutUs);
        
        // Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        // Set menu bar
        setJMenuBar(mb);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        
        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("Show Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("Show Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Add Course")) {
            new AddCourse();
        } else if (msg.equals("View Courses")) {
//            new ViewCourses();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("Student Fee Form")) {
//            new StudentFeeForm();
        } else if (msg.equals("Conduct Examination")) {
//            new ConductExamination();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals("View Results")) {
            new ExamDetails();
        } else if (msg.equals("About Us")) {
            new AboutUs();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
