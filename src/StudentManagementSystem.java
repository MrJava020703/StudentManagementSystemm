import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student 
{
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId()
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getCourse()
    {
        return course;
    }

    public String toString() 
    {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

public class StudentManagementSystem extends JFrame
{
    private ArrayList<Student> students = new ArrayList<>();
    private JTextField idField, nameField, ageField, courseField;
    private JTextArea displayArea;

    public StudentManagementSystem() 
    {
        setTitle("Student Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Course:"));
        courseField = new JTextField();
        panel.add(courseField);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new AddButtonListener());
        panel.add(addButton);

        JButton viewButton = new JButton("View All Students");
        viewButton.addActionListener(new ViewButtonListener());
        panel.add(viewButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private class AddButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String course = courseField.getText();

            Student student = new Student(id, name, age, course);
            students.add(student);
            JOptionPane.showMessageDialog(null, "Student added successfully.");

            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            courseField.setText("");
        }
    }

    private class ViewButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            displayArea.setText("");
            for (Student student : students) 
            {
                displayArea.append(student.toString() + "\n");
            }
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            StudentManagementSystem frame = new StudentManagementSystem();
            frame.setVisible(true);
        });
    }
}
