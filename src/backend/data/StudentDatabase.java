package backend.data;

import backend.data.Database;
import backend.model.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StudentDatabase extends Database {



    public StudentDatabase(String filename) {
        super(filename);
        this.filename="students.txt";

    }

    @Override
    public void createRecordFrom(String[] data) {
        if (data.length == 6) {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int age = Integer.parseInt(data[2]);
            String gender = data[3];
            String department = data[4];
            double gpa = Double.parseDouble(data[5]);

            records.add(new Student(id, name, age, gender, department, gpa));
        }

    }

    @Override
    public String lineRepresentation(Object obj) {
        Student student = (Student) obj;
        return student.lineRepresentation();
    }

    public void add(Student student) {
        records.add(student);

    }

    public void remove(Student student) {
        records.remove(student);

    }

}
