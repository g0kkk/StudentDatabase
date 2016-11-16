import java.io.*;
import java.util.*;
import java.lang.*;
package exam;

class Runner {
	public static void printMenu(){
		System.out.println("1)Student Login\n2)Faculty Login\n3)Exit\nYour Choice:");
	}
	public static void main(String[] args) throws IOException,FileNotFoundException{
		File f = new File("questions.txt");
		File q = new File("creds.txt");
		if(f.exists() && !f.isDirectory() && q.exists() && !q.isDirectory()) {
			System.out.println("Could not find required files\nExiting...\n");
			System.exit();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		printMenu();
		int choice = br.read();
		while(choice != 3){
			switch(choice){
				case 1: System.out.println("Enter details:\nName:");
					String name = br.readLine();
					System.out.println("Department");
					String dept = br.readLine();
                                        System.out.println("ID:");
                                        int id = br.read();
					Student s = new Student(name,dept,id);
					if(!s.login()){
						System.exit();
					}
					s.runner();
					break;
				case 2: System.out.println("Enter details:\nName:");
					String name = br.readLine();
					System.out.println("Department:")
					String dept = br.readLine();
					System.out.println("ID:");
					int id = br.read();
					System.out.println("Course:")
					String course = br.readLine();
					Faculty f = new Faculty(name,dept,id,course);
					if(!f.login()){
						System.exit();
					}
					f.runner();
					break;
				default:System.out.println("Invalid Choice");
					break;
			}
			printMenu();
			choice = br.read();
		}
	}
}
