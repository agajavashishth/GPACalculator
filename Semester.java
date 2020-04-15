import java.util.*;
import java.util.Locale;
import java.lang.String;

public class Semester
{
    public static String[] termPeriod = {"summer","fall","winter"};

    private int semNum;
    private String semName;
    private double semCredits;
    private double semGPA;
    private ArrayList<Course> courses;
    private int courseCount;
    private double qpTotal;
    private String year;

    public void Semester(){
        Scanner name = new Scanner(System.in);  
        System.out.println("Enter Semester Name");
        semName = name.nextLine();
        semName = semName.toLowerCase();
        boolean success = false;
        for (int i=0;i<termPeriod.length;i++){
            if (semName.contains(termPeriod[i])) {this.semNum = i; this.semName = semName;success=true;}
        }
        if (success) {System.out.println("Successfull");}
        else {System.out.println("Error! Unsuccessfull");}
        this.semCredits = 0;
        this.semGPA = 0;
        this.courses = new ArrayList<Course>();
        this.courseCount = 0;
        this.qpTotal = 0.0;
    }

    public void addCourse(Course course){
        
        course.setSem(semName);
        courses.add(course);
        update();

    }

    public void removeCourse(Course course){

        courses.remove(course);
        course.setSem("default");
        update();

    }

    public void update(){
        semCredits= 0.0;
        qpTotal = 0.0;
        courseCount = 0;
        for (Course x : courses) {
            courseCount++;
            semCredits += x.getCreditValue();
            qpTotal += x.getQualityPoint();
        }
        semGPA = qpTotal / semCredits;
    }

    public void calculateSemGPA(){
        update();
        System.out.println(semName.toUpperCase() +" semester GPA is: " + semGPA + ".");
    }

    public double getSemCredits(){
        update();
        return semCredits;
    }

    public double getQPTotal(){
        update();
        return qpTotal;
    }

    public void printAll(){
        update();
        System.out.println("Semester Name: "+semName);
        System.out.println("Credits Attempted: "+semCredits);
        System.out.println("Semester GPA: "+semGPA);
        for (Course x : courses) {x.printAll();}
    }

    public double getSemNum(){
        update();
        return semNum;
    }

    public void setYear(String year){
        update();
        this.year = year;
    }
}
