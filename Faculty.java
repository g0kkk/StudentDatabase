import java.io.*;
import java.lang.*;
import java.util.*;
class MCQ{
	String question;
	String[] options;
	String answer;
	public MCQ(String qn,String[] opn, String ans){
		this.question = qn;
		this.options = opn.clone();
		this.answer = ans;
	}
	public get_question(){
		return this.question;
	}
	public get_options(){
		return this.options;
	}
	public get_answer(){
		return this.answer();
	}
}
public class Faculty implements Login extends User{
	String name;
	String dept;
	int id;
	String course
	ArrayList<MCQ> mcq

	public Faculty(String name, String dept, int id, String course) throws IOException,FileNotFoundException{
		this.name = name;
		this.dept = dept;
		this.id = id;
		this.course = course;
		mcq = new ArrayList<MCQ>();
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("questions.txt")));
		String question = "";
		String[] options;
		String answer;
		do{
			String val = br.readLine();
			question = val.split("|")[0];
			answer = val.split("|")[1];
			for(int i = 0; i < 4; i++){
				options[i] = br.readLine();
			}
			mcq.add(new MCQ(question,options,answer));
		}while(!val.equals(""));
		br.close();
	}
	public void subMenu(){
		System.out.println("1)List questions\n2)Add new question\n3)Edit question\n4)Delete question\n5)Exit\nYour choice:");
	}
	public Boolean findInList(String question){
		Iterator itr = mcq.iterator();
		while(itr.hasNext()){
			MCQ obj = itr.next();
			if(question.equals(obj.get_question()))
				return true;
		}
		return false;
	}
	public void replace(String question,String newquestion, String[] options, String answer){
		ListIterator litr = mcq.listIterator();
                while(litr.hasNext()){
                        MCQ obj = litr.next();
                        if(question.equals(obj.get_question()))
				litr.set(new MCQ(newquestion,options,answer));
		}
	}
	public void remove(String question){
		Iterator itr = mcq.iterator();
                while(itr.hasNext()){
                        MCQ obj = itr.next();
                        if(question.equals(obj.get_question())){
				itr.remove();
				return;
			}
		}
	}
	public void makePaper(){
		BufferedWriter fo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("questions.txt")));
		Iterator itr = mcq.iterator();
		while(itr.hasNext()){
			MCQ obj = itr.next();
			fo.write(obj.get_question()+"\n");
			String ops = obj.get_options();
			int i = 1;
			for(String val:ops){
				fo.write(i+") "+val+"\n");
				i++;
			}
			fo.write(obj.get_answer());
		}
	}
	public void listQuestions(){
		Iterator itr = mcq.iterator();
		int i = 1;
		while(itr.hasNext()){
			MCQ obj = itr.next();
			System.out.printf("Question %1$d :\n%2$s\nOptions",i,obj.get_question());
			String[] options = obj.get_options();
			for(String opt:options){
				int j = 0;
				System.out.printf("%1$) %2$s",j,opt);
			}
		}
	}
	public void addNewQuestion() throws IOException,FileNotFoundException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the new question");
		String question = br.readLine();
		if(findInList(question)){
				System.out.println("Question already exists\nUse edit");
				return;
			}
		}
		System.out.println("Enter the answer");
		String answer = br.readLine();
		System.out.println("Enter the options\n");
                String[] options;
                for(int i = 0; i < 4; i++){
                        System.out.println("Option "+i);
                        options[i] = br.readLine();
                }
		mcq.add(new MCQ(question,options,answer);
		System.out.println("Question added");
	}
	public void editQuestion(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter the question to edit");
		if(!findInList(question)){
			System.out.println("Question not found\nUse add");
			return;
		}
                String question = br.readLine();
		System.out.println("Enter new question");
		String newquestion = br.readLine();
		System.out.println("Enter new options");
		String[] options;
		for(int i = 0; i < 4; i++){
			System.out.println("Option "+i);
			options[i] = br.readLine();
		}
		System.out.println("Enter the answer");
		String answer = br.readLine();
		replace(question,newquestion,options,answer);
		System.out.println("Question changed");
	}
	public void removeQuestion() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter question to remove");
		String question = br.readLine();
		if(!findInList(question)){
			System.out.println("Question not present");
			return;
		}
		remove(question);
		System.out.println("Remove question");
	}
	public void runner() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		subMenu();
		int choice = br.read();
		while(choice != 5){
			switch(choice){
				case 1: listQuestions();break;
				case 2: addNewQuestion();break;
				case 3: editQuestion();break;
				case 4: removeQuestion();break;
				default: System.out.println("Invalid Choice");break;
			}
			choice = br.read();
		}
		if(choice == 5){
			makePaper();
			System.out.println("Returning");
		}
	}
}
