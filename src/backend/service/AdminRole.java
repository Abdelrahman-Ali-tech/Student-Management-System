package backend.service;

import java.util.ArrayList;
import backend.data.StudentDatabase;
import backend.model.Student;

public class AdminRole {

    private StudentDatabase studentDatabase;

    public AdminRole(String fileName) {
        /* this.studentDatabase = new StudentDatabase(fileName);
        studentDatabase.readFromFile();*/
    }

    public String AddStudent(String studentId, String fullName, int age, String gendeString, String department, float gpa) {
        int validId;
        if (!Validation.isValidName(fullName)) {
            return "Not valid Name";
        }

        if (!Validation.isValidId(studentId)) {
            return "Not valid ID";
        } else {
            validId = Integer.parseInt(studentId);
        }

        if (studentDatabase.contains(studentId)) {
            return "this id already exists";
        }

        Student record = new Student(int validId
        ,String fullName,
        int age, String gendeString
        ,String department,
        float gpa
        );
         studentDatabase.add(record);
         studentDatabase.saveToFile();
        return "Successfully added";
    }
  

     public ArrayList<Student> ِviewStudents() {
        return studentDatabase;
    }

    public ArrayList<Student> search(String target, String type_of_search) {
        ArrayList<Student> records = new ArrayList<>();
        for (Student rStudent : records) {
            if (contains(rStudent, target, type_of_search)) {
                records.add(rStudent);
            }
        }
        return records;
    }

    public boolean contains(Student Student, String target, String type_of_search) {
        boolean result;
        if (type_of_search == "name") {
            result = Student.getName().equales(targetName);
        }

        if (type_of_search == "ID") {
            result = (Student.getId() == Integer.parseInt(target));
        }

        return result;

    }
    
    public String deleteStudent(Student student)
    {
    studentDatabase.remove(student);
    return "Successfully removed ";
    }
    
    public String updateStudent(Student student,String studentId, String fullName, int age, String gendeString, String department, float gpa)
    {
        deleteStudent(student);
        AddStudent( studentId,  fullName,  age,  gendeString,  department,  gpa);
       return "Successfully update "; 
    }
}
