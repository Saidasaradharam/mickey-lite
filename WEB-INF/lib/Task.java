import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
public class Task  
{  
    public static void main(String[] args) throws Exception  
    {   
        try{
            String line = "";  
            String splitBy = ",";  
            //parsing a CSV file into Scanner class constructor  
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdventNetMickeyLite\\AdventNet\\MickeyLite\\webapps\\Students\\WEB-INF\\lib\\update.csv"));  
            while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
                String[] employee = line.split(splitBy);    // use comma as separator  
                System.out.println("Employee [First Name=" + Integer.parseInt(employee[0]) + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");  
            }  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
}  
}  