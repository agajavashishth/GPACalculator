import java.util.*;

public class Year
{
    private String year;
    private int semesterCount;
    private ArrayList<Semester> sem;
    private double credits;
    private double GPA;
    private double QPs;

    public static int MAX_SEMESTER = 5;
    public static int CLASS_LIMIT = 5;

    public void Year(){
        this.year = "1";
        this.semesterCount = 0;
        this.sem = new ArrayList<Semester>();
        this.credits = 0.0;
        this.GPA = 0.0;
        this.QPs = 0.0;
    }

    public void addSem(Semester term){
        
        term.setYear(year);
        sem.add(term);
        update();

    }
    
    public void removeSem(Semester term){
        
        sem.remove(term);
        term.setYear("default");
        update();
    }

    public void getCredits(){
        update();
        System.out.println("Credits Attempted: " + credits);
    }

    public void update(){
        for (Semester x: sem){
            x.update();
            semesterCount++;
            credits += x.getSemCredits();
            QPs += x.getQPTotal();
        }
        GPA = QPs / credits;  
    }

    public void showGPA(){
        update();
        System.out.println("Total GPA: " + GPA);
    }

    public void showAll(){
        update();
        for(Semester x : sem){x.printAll();}
    }

}
