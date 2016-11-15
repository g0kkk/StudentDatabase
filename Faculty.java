public class Faculty implements Login extends User{
	String name;
	String dept;
	int id;
	String course

	public Faculty(String name, String dept, int id, String course){
		this.name = name;
		this.dept = dept;
		this.id = id;
		this.course = course;
	}
	public void subMenu(){
		System.out.println("1)List questions\n2)Add new question\n3)Edit question\n4)Delete question\n5)Exit\nYour choice:");
	}
	public void listQuestions() throws IOException,FileNotFoundException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("questions.txt")));
		System.out.println("<Question> : <Answer>");
		String val = br.readLine();
		while(!val.equals("")){
			System.out.printf("%1$s : %2$s",val.split("|")[0],val.split("|")[1]);
			val = br.readLine();
		}
	}
	public void addNewQuestion() throws IOException,FileNotFoundException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fi = new BufferedReader(new InputStreamReader(new FileInputStream("questions.txt")));
		System.out.println("Enter the new question");
		String question = br.readLine();
		String val = fi.readLine();
		while(!val.equals("") && !val.equals(question)){
			val = fi.readLine();
		}
		if(!val.equals("")){
			System.out.println("Question already exists\nUse edit option\n");
			return;
		}
		System.out.println("Enter the answer");
		String answer = br.readLine();
		BufferedWriter fo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("questions.txt")));
		fo.write(question+"|"+answer+"\n");
		System.out.println("Enter the options\n");
                String option;
                for(int i = 0; i < 4; i++){
                        System.out.println("Option "+i);
                        option = br.readLine();
			fo.write(i+")"+option+"\n");
                }
		System.out.println("Question added");
	}
	public void editQuestion(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fi = new BufferedReader(new InputStreamReader(new FileInputStream("questions.txt")));
                System.out.println("Enter the question to edit");
                String question = br.readLine();
                String val = fi.readLine();
                while(!val.equals("") && !val.equals(question)){
                        val = fi.readLine();
                }
                if(val.equals("")){
                        System.out.println("Question does not exist\nAdd question first\n");
                       return;
                }
		System.out.println("Enter new question");
		String newquestion = br.readLine();
		System.out.println("Enter new options");
		String[] options;
		for(int i = 0; i < 4; i++){
			System.out.println("Option "+i);
			options[i] = br.readLine();
		}
		
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
	}
}
