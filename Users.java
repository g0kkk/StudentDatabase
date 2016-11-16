import java.util.*;
import java.lang.*;

public class Users implements Login{
  protected String name;
  protected String password;
}

public Users(String name, String password){
  this.name = name;
  this.password = password;
}
