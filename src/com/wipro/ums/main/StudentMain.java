package com.wipro.ums.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;
import com.wipro.ums.bean.SchoolStudentBean;
import com.wipro.ums.service.StudentService;

public class StudentMain {
    //private static final int  = 0;

	public static void main(String[] args) {
        /*String studentName = "Robin";
        char studentType = 'S';
        int studentAge = 17;
        int studentAdmNo = 12548;
        int[] studentMarks = {44, 88, 67, 90, 0, 0};
        SchoolStudentBean st = new SchoolStudentBean(studentName,studentType, studentAge, studentAdmNo, studentMarks);
        //String result = new StudentService().addStudent(studentName, studentType, studentAge, studentAdmNo, studentMarks);
        //String result = new StudentService().validateStudent(studentName,studentType, studentAge, studentAdmNo, studentMarks);
        int result= st.calcGradePoint(studentMarks);
        System.out.println(result); */
    	
    	        Scanner scanner = new Scanner(System.in);

    	        // Get student details from the user
    	        //System.out.print("Enter the id of the Student:");
    	        //int id = scanner.nextInt();
    	        System.out.print("Enter student name: ");
    	        
    	        String name = scanner.next();

    	        System.out.print("Enter student type (S / C) : ");
    	        char type = scanner.next().charAt(0);
    	        System.out.print("Enter the Gender of Student(M/F) : ");
    	        String gender=scanner.next();

    	        System.out.print("Enter student age: ");
    	        int age = scanner.nextInt();

    	        System.out.print("Enter student admission number: ");
    	        int admissionNumber = scanner.nextInt();

    	        int[] marks = new int[6];
    	        System.out.println("Enter student marks for 6 subjects: ");
    	        for (int i = 0; i < 6; i++) {
    	            System.out.print("Subject " + (i + 1) + ": ");
    	            marks[i] = scanner.nextInt();
    	        }

    	        // Create an instance of StudentService and invoke the addStudent() method
    	        SchoolStudentBean st = new SchoolStudentBean(name,type,age,admissionNumber,marks);
    	        String result = new StudentService().validateStudent(name,type,age,admissionNumber,marks);
    	        int result1= st.calcGradePoint(marks);
    	        System.out.println(result);
    	        System.out.println(result1);
    	        
    	        //StudentService studentService = new StudentService();
    	        //String result = studentService.addStudent(name, type, age, admissionNumber, marks);

    	      
  
        
        try{  
        	//step1 load the driver class  
        	Class.forName("oracle.jdbc.driver.OracleDriver");  
        	  
        	//step2 create  the connection object  
        	Connection con=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@localhost:1521:xe","system","admin");  
        	  
        	/*//step3 create the statement object  
        	//Statement stmt=con.createStatement();  
        	  
        	//step4 execute query 
        	//stmt.executeUpdate("insert into STUD_DETAILS values('s4','kumar',20,'M',532,10)"); */
        	PreparedStatement p= con.prepareStatement("insert into STUD_DETAILS values(?,?,?,?,?,?)");
        	p.setInt(1,generateId());
        	p.setString(2,name);
        	p.setInt(3,age);
        	p.setString(4,gender);
        	p.setInt(5,admissionNumber);
        	p.setInt(6,result1);
        	p.executeUpdate();
        	
        	Statement stmt=con.createStatement();
        	ResultSet rs=stmt.executeQuery("select * from STUD_DETAILS"); 
        	
        	while(rs.next())  {
        	System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+ " "+rs.getString(4)+ " " +rs.getInt(5) + " "+rs.getInt(6));  
        	  
        	//step5 close the connection object  
        	System.out.println(st.calcGrade(rs.getInt(6)));
        	}
        	con.close();  
        	  
        	}catch(Exception e){ System.out.println(e);}  
        
        	  
}
	public static int generateId( ) {
		int cid=0;
		try {
			Connection con=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@localhost:1521:xe","system","admin");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select STUD_SEQ.NEXTVAL from dual");

		if(rs!=null && rs.next())

		cid = rs.getInt(1);
		}

		catch (SQLException e) {

		e.printStackTrace();
		}

		return cid;
		
	}
	
}