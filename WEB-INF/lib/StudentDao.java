package student;

import java.util.*;
import java.io.*;
import java.lang.Object.*;
import com.adventnet.persistence.*;     //For Row and DataObject
import com.adventnet.ds.query.*;        //For Criteria & Table
import com.adventnet.mfw.bean.BeanUtil;

public class StudentDao {

        public int registerUser(Student student) throws ClassNotFoundException,DataAccessException {
                long studentId = student.getstudentid();
                String name = student.getname();
                String email = student.getemail();
                float semester1 = student.getsem1();
                float semester2 = student.getsem2();
                float semester3 = student.getsem3();
                float semester4 = student.getsem4();
                float semester5 = student.getsem5();
                float semester6 = student.getsem6();
                float cgpa = (semester1+semester2+semester3+semester4+semester5+semester6)/6;
                System.out.println(name);
                System.out.println(email);
                System.out.println("Inside Register User function of StudentDao Class");
                //Table Details = new Table("Details");
                Row r1 = new Row ("details");
                r1.set(1, new Long(studentId));
                r1.set(2,name);
                r1.set(3,email);
                //Table Details = new Table("Marks");
                Row r2 = new Row("marks");
                r2.set(1,studentId);
                r2.set(2,studentId);
                r2.set(3,semester1);
                r2.set(4,semester2);
                r2.set(5,semester3);
                r2.set(6,semester4);
                r2.set(7,semester5);
                r2.set(8,semester6);
                r2.set(9,cgpa);
                // Creating (or) Fetching a DataObject
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
                return(1);
                }


        public void deleteStudent(long studentId){
                try{
                        DataObject d =DataAccess.get("details",(Criteria)null);
                        Criteria c = new Criteria(new Column("details", "STUDENT_ID"),studentId, QueryConstants.EQUAL); 
                        d.deleteRows("details",c);

                        //Persists the changes done in the given dataObject into the database.
                        DataAccess.update(d);
                }catch(Exception e){
                        e.printStackTrace();
                }
                
        }

        public Student selectStudent(long studentId){
                
                try{
                        DataObject d =DataAccess.get("details",(Criteria)null);
                        DataObject d2 =DataAccess.get("marks",(Criteria)null);
                        Criteria c = new Criteria(new Column("details", "STUDENT_ID"),studentId, QueryConstants.EQUAL); 
                        Criteria c2 = new Criteria(new Column("marks", "STUDENT_ID"),studentId, QueryConstants.EQUAL); 
                        Row r1 = d.getRow("details",c);
                        Row r2 = d2.getRow("marks",c2);
                        String name =(String)r1.get(2);
                        String email = (String)r1.get(3);
                        float semester1=Float.parseFloat(r2.get(3).toString());
                        float semester2=Float.parseFloat(r2.get(4).toString());
                        float semester3=Float.parseFloat(r2.get(5).toString());
                        float semester4=Float.parseFloat(r2.get(6).toString());
                        float semester5=Float.parseFloat(r2.get(7).toString());
                        float semester6=Float.parseFloat(r2.get(8).toString());
                        float cgpa=Float.parseFloat(r2.get(9).toString());
                        Student existingStudent = new Student(studentId,name,email,semester1,semester2,semester3,semester4,semester5,semester6,cgpa);
                        return(existingStudent);
                }catch(Exception e){
                        e.printStackTrace();
                        return((Student)null);
                }
        }

        public void updateStudent(Student updateStudent){
                long studentId = updateStudent.getstudentid();
                String name = updateStudent.getname();
                String email = updateStudent.getemail();
                float semester1 = updateStudent.getsem1();
                float semester2 = updateStudent.getsem2();
                float semester3 = updateStudent.getsem3();
                float semester4 = updateStudent.getsem4();
                float semester5 = updateStudent.getsem5();
                float semester6 = updateStudent.getsem6();
                float cgpa = updateStudent.getcgpa();
                Criteria c1 = new Criteria(new Column("details", "STUDENT_ID"),studentId, QueryConstants.EQUAL);
                Criteria c2 = new Criteria(new Column("marks", "STUDENT_ID"),studentId, QueryConstants.EQUAL);
                try{
                        DataObject d1 =DataAccess.get("details",c1);
                        DataObject d2 =DataAccess.get("marks",c2);
                        Row r1 = d1.getRow("details");
                        Row r2 = d2.getRow("marks");

                        r1.set(1, studentId);
                        r1.set(2,name);
                        r1.set(3,email);
                        r2.set(1,studentId);
                        r2.set(2,studentId);
                        r2.set(3,semester1);
                        r2.set(4,semester2);
                        r2.set(5,semester3);
                        r2.set(6,semester4);
                        r2.set(7,semester5);
                        r2.set(8,semester6);
                        r2.set(9,cgpa);

                        //update the modified row in DO
                        d1.updateRow(r1);
                        d2.updateRow(r2);
                        //Persists the changes done in the given dataObject into the database.
                        DataAccess.update(d1);
                        DataAccess.update(d2);
                
                }catch(DataAccessException e){
                        e.printStackTrace(System.err);
                }

        }


         public List<Student> showStudent(String email) throws DataAccessException{
                List<Student> studentslist = new ArrayList<>();
                try{
                        
                        Table Details = new Table("Details");
                        
                        Criteria c1 = new Criteria(new Column("details", "STUDENT_EMAIL"),email, QueryConstants.EQUAL);
                        DataObject dataObject = DataAccess.get("details",c1);
                        Iterator it=dataObject.getRows("details");
                        System.out.println("Inside get single student details!");
                        System.out.println("Inside ShowAll Function");
                        while(it.hasNext())
                        {       
                                Row r=(Row)it.next();
                                long studentId =Long.parseLong(r.get(1).toString());
                                String name =(String)r.get(2);
                                SelectQuery query = new SelectQueryImpl(Table.getTable("marks"));
                                query.addSelectColumn(Column.getColumn(null,"*"));
                                Criteria c = new Criteria(new Column("marks", "STUDENT_ID"),studentId, QueryConstants.EQUAL);
                                query.setCriteria(c);
                                
                                Persistence per= (Persistence)BeanUtil.lookup("Persistence");
                                DataObject d1 = per.get(query);
                                //DataObject d1= DataAccess.get(c);
                                Row markRow = d1.getFirstRow("marks");
                                // to return each column value of the row
                                float semester1=Float.parseFloat(markRow.get(3).toString());
                                float semester2=Float.parseFloat(markRow.get(4).toString());
                                float semester3=Float.parseFloat(markRow.get(5).toString());
                                float semester4=Float.parseFloat(markRow.get(6).toString());
                                float semester5=Float.parseFloat(markRow.get(7).toString());
                                float semester6=Float.parseFloat(markRow.get(8).toString());
                                float cgpa=Float.parseFloat(markRow.get(9).toString());

                               studentslist.add(new Student(studentId,name,email,semester1,semester2,semester3,semester4,semester5,semester6,cgpa));
                                
                        }
                }catch(DataAccessException e){
                         e.printStackTrace(System.err);
                }catch(Exception e){
                        e.printStackTrace();
                }
                return(studentslist);
        }


        public List<Student> showAll() throws DataAccessException{
                List<Student> studentslist = new ArrayList<>();
                try{
                        
                        Table Details = new Table("Details");
                        // SelectQuery selectQuery = new SelectQueryImpl(Details);
                        // Column c1 = new Column("Details","STUDENT_ID");
                        // Column c2 = new Column("Details","STUDENT_NAME");
                        // Column c3= new Column("Details","STUDENT_EMAIL");
                        // Column c4= new Column("Details","CITY");
                        // Column c5 = new Column("Marks","SEM_1");
                        // Column c6 = new Column("Marks","SEM_2");
                        // Column c7= new Column("Marks","SEM_3");
                        // Column c8= new Column("Marks","SEM_4");
                        // Column c9 = new Column("Marks","SEM_5");
                        // Column c10 = new Column("Marks","SEM_6");
                        // Column c11= new Column("Marks","CGPA");
                        
                        // selectQuery.addSelectColumn(c1);
                        // selectQuery.addSelectColumn(c2);
                        // selectQuery.addSelectColumn(c3);
                        // selectQuery.addSelectColumn(c4);
                        // selectQuery.addSelectColumn(c5);
                        // selectQuery.addSelectColumn(c6);
                        // selectQuery.addSelectColumn(c7);
                        // selectQuery.addSelectColumn(c8);
                        // selectQuery.addSelectColumn(c9);
                        // selectQuery.addSelectColumn(c10);
                        // selectQuery.addSelectColumn(c11);
                        // Join join = new Join("Details", "Marks", new String[]{"STUDENT_ID"}, new String[]{"STUDENT_ID"}, Join.INNER_JOIN);
                        // selectQuery.addJoin(join);
                        DataObject dataObject = DataAccess.get("details",(Criteria)null);
                        Iterator it=dataObject.getRows("details");
                        //System.out.println(dataObject);
                        System.out.println("Inside ShowAll Function");
                        while(it.hasNext())
                        {       
                                Row r=(Row)it.next();
                                long studentId =Long.parseLong(r.get(1).toString());
                                String name =(String)r.get(2);
                                String email = (String)r.get(3);
                                SelectQuery query = new SelectQueryImpl(Table.getTable("marks"));
                                query.addSelectColumn(Column.getColumn(null,"*"));
                                Criteria c = new Criteria(new Column("marks", "STUDENT_ID"),studentId, QueryConstants.EQUAL);
                                query.setCriteria(c);
                                
                                Persistence per= (Persistence)BeanUtil.lookup("Persistence");
                                DataObject d1 = per.get(query);
                                //DataObject d1= DataAccess.get(c);
                                Row markRow = d1.getFirstRow("marks");
                                // to return each column value of the row
                                float semester1=Float.parseFloat(markRow.get(3).toString());
                                float semester2=Float.parseFloat(markRow.get(4).toString());
                                float semester3=Float.parseFloat(markRow.get(5).toString());
                                float semester4=Float.parseFloat(markRow.get(6).toString());
                                float semester5=Float.parseFloat(markRow.get(7).toString());
                                float semester6=Float.parseFloat(markRow.get(8).toString());
                                float cgpa=Float.parseFloat(markRow.get(9).toString());

                               studentslist.add(new Student(studentId,name,email,semester1,semester2,semester3,semester4,semester5,semester6,cgpa));
                                
                        }
                }catch(DataAccessException e){
                         e.printStackTrace(System.err);
                }catch(Exception e){
                        e.printStackTrace();
                }
                return(studentslist);
        }

}