/**
 * Student
 */
import java.io.*;
import java.util.*;
public class Student {
    int admno;
    String name;
    double feesBalance;
    String major;

    Student (int admno, String name, double feesBalance, String major) {
        this.admno = admno;
        this.name = name;
        this.feesBalance = feesBalance;
        this.major = major;
    }

    Student (){

    }

    void displayName(ArrayList<Student> std){
        for(Student student: std ){ 
            System.out.println("Student name: " + student.name);    
        } 
    }

    void feesBalance(ArrayList<Student> std){
        double sum=0;
        for(Student student: std){
            sum = sum + student.feesBalance;
        }
        System.out.println("Total Fees Balance: " + sum);
        System.out.println("Average Fees Balance: " + sum/(std.size()));
    }

    static void getMode(ArrayList<Student> std){
        int max = 0;
        // hashmap to store the frequency of the Majors
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for(Student student : std){
            Integer j = hm.get(student.major);
            hm.put(student.major, (j == null) ? 1 : j + 1);
        }
 
        // displaying the occurrence of elements in the arraylist
        for (Map.Entry<String, Integer> val : hm.entrySet()) {
            if(max < val.getValue()){
                max = val.getValue();
            }
        } 

        for (Map.Entry<String, Integer> val : hm.entrySet()){
            if(val.getValue() == max){
                System.out.println("The major with the most students is: "+ val.getKey());
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Student std1 = new Student(8145, "John", 70000, "CS");
        Student std2 = new Student(8190, "Amy", 70630, "CS");
        Student std3 = new Student(8121, "Jane", 75600, "Medicine");
        Student std4 = new Student(8134, "Kojo", 34000, "Geology");
        Student std5 = new Student(9033, "Jen", 8000, "Law");

        List<Student> student = new ArrayList<Student>();
        student.add(std1);
        student.add(std2);
        student.add(std3);
        student.add(std4);
        student.add(std5);

        Student temp = new Student();
        temp.displayName((ArrayList<Student>) student);
        temp.feesBalance((ArrayList<Student>) student);
        getMode((ArrayList<Student>) student);
    }
}