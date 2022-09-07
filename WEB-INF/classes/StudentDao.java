package student;


public class StudentDao {

	public int registerUser(Student student) throws ClassNotFoundException {
		
        System.out.println(student.getname());
        System.out.println(student.getemail());
        System.out.println("Inside Register User function of StudentDao Class");
        return 1;

	}

}