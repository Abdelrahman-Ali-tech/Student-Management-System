package backend.service;

import java.util.ArrayList;
import backend.data.StudentDatabase;
import backend.model.Student;

public class AdminRole {

    private StudentDatabase studentDatabase;
    private ArrayList<Student> records;
    
    public  AdminRole(String fileName) {
        this.studentDatabase = new StudentDatabase(fileName);
        studentDatabase.loadFromFile();

        
    }
   



    public String AddStudent(int studentId, String fullName, int age, String gendeString, String department, float gpa) {
        String validId=String.valueOf(studentId);
        if (!Validation.isValidName(fullName)) {
            return "Not valid Name";
        }

        if (!Validation.isValidId(validId)) {
            return "Not valid ID";
        } 

        if (!search(validId, "ID").isEmpty()) {
            return "this id already exists";
        }

        Student record = new Student(studentId, fullName, age,  gendeString, department, gpa);
         studentDatabase.add(record);
         studentDatabase.saveToFile();
        return "Successfully added";
    }
  


     public ArrayList<Object> viewStudents() {
        return studentDatabase.returnAllRecords();
    }
    public ArrayList<Student> search(String target, String type_of_search) {
        ArrayList<Student> targetrecords = new ArrayList<>();
        this.records = (ArrayList<Student>)(Object) studentDatabase.returnAllRecords();
        for (Student rStudent : records) {
            if (contains(rStudent, target, type_of_search)) {
                targetrecords.add(rStudent);
            }
        }
        return targetrecords;
    }

    public boolean contains(Student student, String target, String type_of_search) {
        boolean result=false;
        if (type_of_search.equals("name")) {
            result = student.getFullName().equals(target);
        }

        if (type_of_search.equals("ID")) {
            result = (student.getStudentId()== Integer.parseInt(target));
        }

        return result;

    }
    
    public String deleteStudent(Student student)
    {
    studentDatabase.remove(student);
    studentDatabase.saveToFile();
    return "Successfully removed ";
    }
    
    public String updateStudent(Student student,int studentId, String fullName, int age, String gendeString, String department, float gpa)
    {
        deleteStudent(student);
        AddStudent( studentId,  fullName,  age,  gendeString,  department,  gpa);
       return "Successfully update "; 
    }
}


