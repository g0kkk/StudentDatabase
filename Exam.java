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
    		String val = q.readline();
    		while(!val.equals("")){
      			BufferedInputReader in = new BufferedInputReader (new InputStreamReader(System.in));
      			System.out.println(val);
      			choices.put(val,in.readline());
      			val = q.readline();
    		}
  	}
  	public int calMarks(){
    		FileInputStream q = new FileInputStream("key.txt");
		Set set = choices.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()){
			Map.Entry x = (Map.Entry)i.next();
			
		}
  	}
}
