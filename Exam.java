import java.util.*;
import java.io.*;
package exam;

class Exam{
	int duration, totalmarks;
  	HashMap choices;
  	public exam(int d, int tot){
    		duration = d;
    		totalmarks = tot;
		choices = new HashMap();
  	}
  	public void takeExam(){
    		FileInputStream q = new FileInputStream("questions.txt");
    		String val = q.readline().split(" ")[0];
    		while(!val.equals("")){
      			BufferedInputReader in = new BufferedInputReader (new InputStreamReader(System.in));
      			System.out.println(val);
      			choices.put(val,in.readline());
      			val = q.readline();
    		}
  	}
  	public int calMarks(){
		int sum = 0;
		String answer;
    		FileInputStream q = new FileInputStream("questions.txt");
		Set set = choices.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()){
			answer = q.readline().split(" ")[1]
			Map.Entry x = (Map.Entry)i.next();
			if(x.getValue().equals(answer)){
				sum+ = 1;
			}
		}
  		return sum
	}
}
