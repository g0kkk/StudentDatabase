import java.util.*;
import java.time.LocalDate;
public class Student implements Login extends User,Exam{
  Date dateBirth;
  int marks;
  public getExam(){
    takeExam();
  }
  public viewMarks(){
    calMarks();
    System.out.println("Total marks is" + sum + "!");
  }
  }
