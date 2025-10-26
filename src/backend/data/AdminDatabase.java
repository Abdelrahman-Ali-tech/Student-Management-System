package backend.data;

import backend.data.Database;
import backend.model.Admin;
import backend.model.Student;
import java.util.ArrayList;

public class AdminDatabase extends Database {

    
    
    public AdminDatabase(String filename) {
        super(filename);
        this.filename= "admins.txt";

    }
    @Override
    public void createRecordFrom(String[] data) {
        if (data.length == 2) {
            String userName = data[0];

            String password = data[1];

            records.add(new Admin(userName,password));
        }

    }
    @Override
    public String lineRepresentation(Object obj) {
        Admin admin=(Admin) obj;
       return admin.lineRepresentation();
    }
}







    


