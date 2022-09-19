package sampletask;

import java.util.*;
import java.io.*;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import com.adventnet.taskengine.*;
import java.lang.Object.*;
import com.adventnet.persistence.*;     //For Row and DataObject
import com.adventnet.ds.query.*;        //For Criteria & Table
import com.adventnet.mfw.bean.BeanUtil;

public class SampleTask implements Task
{  
    @Override
    public void executeTask(TaskContext taskContext) throws TaskExecutionException 
    {   
        try{
            String line = "";  
            String splitBy = ",";  
            //parsing a CSV file into Scanner class constructor  
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdventNetMickeyLite\\AdventNet\\MickeyLite\\webapps\\Students\\WEB-INF\\lib\\update.csv"));  
            while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
                String[] employee = line.split(splitBy);    // use comma as separator  
                System.out.println("Operation=" + employee[0] + ", ID=" + employee[1] );  
                if(employee[0].equals("add")){
                    Row r1 = new Row ("details");
                    r1.set(1, Long.parseLong(employee[1]));
                    r1.set(2,employee[2]);
                    r1.set(3,employee[3]);
                    //r1.set(4,employee[4]);
                    Row r2 = new Row("marks");
                    r2.set(1,Long.parseLong(employee[1]));
                    r2.set(2,Long.parseLong(employee[1]));
                    r2.set(3,Float.parseFloat(employee[5]));
                    r2.set(4,Float.parseFloat(employee[6]));
                    r2.set(5,Float.parseFloat(employee[7]));
                    r2.set(6,Float.parseFloat(employee[8]));
                    r2.set(7,Float.parseFloat(employee[9]));
                    r2.set(8,Float.parseFloat(employee[10]));
                    float cgpa=(Float.parseFloat(employee[5])+Float.parseFloat(employee[6])+Float.parseFloat(employee[7])+Float.parseFloat(employee[8])+Float.parseFloat(employee[9])+Float.parseFloat(employee[10]))/6;
                    r2.set(9,cgpa);
                    
                    DataObject dataObject = new WritableDataObject(); 
                    // Adding Row to DataObject
                    dataObject.addRow(r1);
                    dataObject.addRow(r2);
                    try{
                    DataAccess.update(dataObject);
                    }
                    catch(DataAccessException e){
                    e.printStackTrace(System.err);
                    }

                    System.out.println("1 is verified");
                }

                else if(employee[0].equals("delete")){

                    DataObject d =DataAccess.get("details",(Criteria)null);
                    Criteria c = new Criteria(new Column("details", "STUDENT_ID"),Long.parseLong(employee[1]), QueryConstants.EQUAL); 
                    d.deleteRows("details",c);
                    DataAccess.update(d);


                    System.out.println("2 is verified");


                }
                else if(employee[0].equals("update")){

                    Criteria c1 = new Criteria(new Column(employee[2], "STUDENT_ID"),Long.parseLong(employee[1]), QueryConstants.EQUAL);
                    DataObject d1 =DataAccess.get(employee[2],c1);
                    Row r1 = d1.getRow(employee[2]);
                    if((employee[3].equals("STUDENT_EMAIL"))||(employee[3].equals("STUDENT_NAME")))
                        r1.set(employee[3], employee[4]);
                    else{
                        float sem = Float.parseFloat(r1.get(employee[3]).toString());
                        float cgpa=Float.parseFloat(r1.get(9).toString());
                        r1.set(employee[3], Float.parseFloat(employee[4]));
                        cgpa=(((cgpa*6)-sem)+(Float.parseFloat(employee[4])))/6;
                        r1.set("CGPA",cgpa);
                        d1.updateRow(r1);
                        DataAccess.update(d1);
                    }    
                    System.out.println("3 is verified");
                }
            }  
        }   
        catch (Exception e)   
        {  
            e.printStackTrace();  
        }  
}  

    @Override
    public void stopTask() throws TaskExecutionException{}
}  