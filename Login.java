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
    		for(String val: input.split(" ")){
      			if(uname.equals(val)){
          			if(passwd.equals(input.split(" ")[1])){
            				auth=True;
					break;
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
		return auth;
  	}
}
