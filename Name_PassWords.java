import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;

public class Name_PassWords {
    private String UserName;
    private String PassWord;

    public void setUserName(String UserName){
        this.UserName = UserName;
    }
    public void setPassWord(String PassWord){
        this.PassWord = PassWord;
    }
    public String getUserName(){
        return UserName;
    }
    public String getPassWord(){
        return PassWord;
    }
    File file = new File("Admin_Usernames.txt");
    //File file2 = new File("Admin_Passwords.txt");

    public boolean checkUserName_Passwords(String UserName,String PassWord){
        String name;
        String pass;
        try {
            Scanner NameFile = new Scanner(file);
            while(NameFile.hasNextLine()){
                name = NameFile.next();
                pass = NameFile.next();
                if(name.equals(UserName) && pass.equals(PassWord)){
                        return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
