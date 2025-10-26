/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Khaled
 */
public class Database {
    private static final String FILE_NAME = "students.txt";

    public static void saveToFile(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            // traditional for loop instead of for-each
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                pw.println(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getGender() + "," + s.getDepartment() + "," + s.getGpa());
            }

            JOptionPane.showMessageDialog(null, "student saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving student data: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static List<Student> loadFromFile() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String gender = data[3];
                    String department = data[4];
                    double gpa = Double.parseDouble(data[5]);

                    students.add(new Student(id, name, age, gender, department, gpa));
                }
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No existing student file found,a new one will be created", "Info", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading student data: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }

        return students;
    }
}
