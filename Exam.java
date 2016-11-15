import java.util.*;
import java.io.*;
import java.lang.*;
package Exam;

class Exam{
	int duration, totalmarks;
	boolean tofinish;
  	HashMap<String,String> choices;
  	public Exam(int d, int tot){
    		duration = d;
    		totalmarks = tot;
		choices = new HashMap<String,String>();
		tofinish = false;
  	}
  	public void takeExam() throws IOException,FileNotFoundException{
    		BufferedReader q = new BufferedReader(new InputStreamReader(new FileInputStream("questions.txt")));
      		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
    		String question = q.readLine().split("|")[0];
		long startTime = System.nanoTime();
    		while(!question.equals("")){
      			System.out.println(question);
			for(int i = 0; i < 4; i++){
				String option = q.readLine();
				System.out.println(option);
			}
			System.out.println("Your choice:");
      			choices.put(question,in.readLine());
			tofinish = (System.nanoTime() - startTime >= duration);
			if(tofinish){
				System.out.println("Time's up!");
				return;
			}
      			question = q.readLine().split("|")[0];
    		}
  	}
  	public int calMarks() throws IOException,FileNotFoundException{
		int sum = 0;
		String answer;
    		BufferedReader q = new BufferedReader(new InputStreamReader(new FileInputStream("questions.txt")));
		Set set = choices.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()){
			answer = q.readLine().split("|")[1];
			Map.Entry x = (Map.Entry)i.next();
			if(x.getValue().equals(answer)){
				sum = sum + 1;
			}
		}
  		return sum;
	}
}
