import java.util.*;
import java.io.*;

class login{
  String username, password;
  Boolean auth;
  public static Boolean login(){
    String uname, passwd;
    BufferedInputReader inp = new BufferedInputReader (new InputStreamReader(System.in));
    System.out.println("Enter username and password.");
    uname = inp.readline();
    passwd = inp.readline();
    FileInputStream f = new FileInputStream("creds.txt");
    String input = f.readline()
    for(String val: input.split(" ")){
      if(uname.equals(val)){
          if(passwd.equals(input.split(" ")[1])){
            auth=True;
          }
          else{
            System.out.println("Invalid Credentials");
            return False;
          }
      }
      input = f.readline();
    }
    if(auth == True){
        System.out.println("Login successful");
    }
    else{
      System.out.println("No such username");
    }
  }
}

class exam{
  int duration, totalmarks;
  Map choices;
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
      val = f.readline();
    }
  }
  public int calMarks(){
    FileInputStream q = new FileInputStream("key.txt");
    for(String value: choices.)
  }
}
