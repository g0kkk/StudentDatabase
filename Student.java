import java.util.*;
public class Student implements Login extends User,Exam{
  int marks;
  public void runner() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		subMenu();
		int choice = br.read();
		while(choice != 3){
			switch(choice){
				case 1: getExam();break;
				case 2: viewMarks();break;
				default: System.out.println("Invalid Choice");break;
			}
			choice = br.read();
		}
		if(choice == 3){
			System.out.println("Returning");
		}
  }
  public getExam(){
    takeExam();
  }
  public viewMarks(){
    marks = calMarks();
    System.out.println("Total marks is" + marks + "!");
  }
  }

  public void subMenu(){
		System.out.println("1)Take Exam\n2)View mark3)Exit\nYour choice:");
	}
