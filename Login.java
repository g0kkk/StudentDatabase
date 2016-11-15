import java.util.*;
import java.io.*;
package login;

public interface Login{
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
		while(!input.equals("")){
      			if(uname.equals(input.split(" ")[0])){
          			if(passwd.equals(input.split(" ")[1])){
					System.out.println("Login successful!");
					return true;
          			}
          			else{
            				System.out.println("Invalid Credentials");
            				return False;
          			}
      			}
      			input = f.readline();
    		}
		System.out.println("Username not found");
		return false;
  	}
}
