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
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputReader("questions.txt")));
		System.out.println("<Question> : <Answer>");
		String val = br.readLine();
		while(!val.equals("")){
			System.out.printf("%1$s : %2$s",val.split(" ")[0],val.split(" ")[1]);
			val = br.readLine();
		}
	}
	public void runner()throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		subMenu();
		int choice = br.read();
		while(choice != 5){
			switch(choice){
				case 1:
