package student;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
    private long studentId;
    private String name;
    private String email;
    private String city;
    private float semester1;
    private float semester2;
    private float semester3;
    private float semester4;
    private float semester5;
    private float semester6;
	private float cgpa;

	public Student(){}

	public Student(long studentId, String name, String email, String city, float semester1, float semester2, float semester3, float semester4, float semester5, float semester6){
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.city = city;
		this.semester1 = semester1;
		this.semester2 = semester2;
		this.semester3 = semester3;
		this.semester4 = semester4;
		this.semester5 = semester5;
		this.semester6 = semester6;
	}

	public Student(long studentId, String name, String email, String city, float semester1, float semester2, float semester3, float semester4, float semester5, float semester6, float cgpa){
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.city = city;
		this.semester1 = semester1;
		this.semester2 = semester2;
		this.semester3 = semester3;
		this.semester4 = semester4;
		this.semester5 = semester5;
		this.semester6 = semester6;
		this.cgpa = cgpa;
	}

    public long getstudentid() {
		return studentId;
	}
	public void setstudentid(long studentId) {
		this.studentId = studentId;
        System.out.println("Student ID set successfully");
	}

	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}

	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}

	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}

	public void setsem1(float semester1) {
		this.semester1 = semester1;
	}
    public float getsem1() {
		return semester1;
	}

	public void setsem2(float semester2) {
		this.semester2 = semester2;
	}
    public float getsem2() {
		return semester2;
	}

	public void setsem3(float semester3) {
		this.semester3 = semester3;
	}
    public float getsem3() {
		return semester3;
	}

	public void setsem4(float semester4) {
		this.semester4 = semester4;
	}
    public float getsem4() {
		return semester4;
	}

    public void setsem5(float semester5) {
		this.semester5 = semester5;
	}
    public float getsem5() {
		return semester5;
	}
	
	public void setsem6(float semester6) {
		this.semester6 = semester6;
	}
    public float getsem6() {
		return semester6;
	}

	public void setcgpa(float cgpa) {
		this.cgpa = cgpa;
	}
    public float getcgpa() {
		return cgpa;
	}
}