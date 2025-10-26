
package backend.model;


public class Student {
    private int studentId;
    private    String fullName;
    private    int age;
    private    String gendeString;
    private    String department; 
    private    double gpa;

    public Student(int studentId, String fullName, int age, String gendeString, String department, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.gendeString = gendeString;
        this.department = department;
        this.gpa = gpa;
    }
    public String lineRepresentation(){
       
        return this.getStudentId() + "," + this.getFullName()+ "," + this.getAge()+ "," + this.getGendeString()+ "," + this.getDepartment()+ "," + this.getGpa();
    }

    public int getStudentId() {
        return this.studentId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getAge() {
        return this.age;
    }

    public String getGendeString() {
        return gendeString;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getGpa() {
        return this.gpa;
    }
    
}



 
