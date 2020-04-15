import java.util.*;
import java.util.Locale;
import java.lang.String;

public class Course extends Semester
{
    private String courseName;
    private String instructor;
    private String grade;
    private double creditValue;
    private double qualityPoint;
    private String semName;

    public static String[] gradeList = {"F","D-","D","D+","C-","C","C+","B-","B","B+","A-","A","A+"};

    public Course(){
        super();
        Scanner name = new Scanner(System.in);  
        System.out.println("Enter Course Name");
        this.courseName = name.nextLine();
        Scanner iName = new Scanner(System.in);  
        System.out.println("Enter Instructor Name");
        this.instructor = iName.nextLine();
        Scanner cGrade = new Scanner(System.in);  
        System.out.println("Enter Grade");
        this.grade = cGrade.nextLine();
        Scanner weight = new Scanner(System.in);  
        System.out.println("Enter Credit Value");
        this.creditValue = weight.nextDouble();  
        boolean success = false;
        for (int i=0;i<gradeList.length;i++){
            if (grade.equals(gradeList[i])) {double j = i; this.qualityPoint = j * creditValue; success=true;}
        }
        if (success) {System.out.println("Successfull");}
        else {System.out.println("Error! Unsuccessfull");}
    }

    public double getQualityPoint(){
        return qualityPoint;
    }

    public double getCreditValue(){
        return creditValue;
    }

    public String getGrade(){
        return grade;
    }
    
    public void setGrade(){
        Scanner cGrade = new Scanner(System.in);  
        System.out.println("Enter Grade");
        this.grade = cGrade.nextLine();
        boolean success = false;
        for (int i=0;i<gradeList.length;i++){
            if (grade.equals(gradeList[i])) {double j = i; this.qualityPoint = j * creditValue; success=true;}
        }
        if (success) {System.out.println("Successfull");}
        else {System.out.println("Error! Unsuccessfull");}
        
    }

    public void printAll(){
        System.out.println("Course Name: "+courseName);
        System.out.println("Instructor Name: "+instructor);
        System.out.println("Grade: "+grade);
        System.out.println("Credit Value: "+creditValue);
    }

    public void setSem(String name){
        this.semName = name;
    }
}