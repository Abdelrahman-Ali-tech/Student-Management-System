package backend.data;

import backend.model.Student;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Khaled
 */
public abstract class Database {
    
    protected ArrayList<Object> records = new ArrayList<>();
    protected String filename;

    public Database(String filename) {
        this.filename = filename;
    }

    public abstract void createRecordFrom(String [] line);
    public abstract String lineRepresentation(Object obj);
    
    
    public  void loadFromFile() {
        List<Object> objList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
               createRecordFrom(data);
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No existing student file found,a new one will be created", "Info", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading student data: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }

        
    }
   public ArrayList<Object> returnAllRecords() {
        return (ArrayList<Object>)(Object)records;
    }

    
    
    public  void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            // traditional for loop instead of for-each
            for (int i = 0; i < records.size(); i++) {
                Object s = records.get(i);
                pw.println(lineRepresentation(s));
            }

            JOptionPane.showMessageDialog(null, "student saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving student data: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
