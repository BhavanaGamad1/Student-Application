package in.pentagon.studentapp.model;

import java.util.Scanner;


import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Scanner sc = new Scanner(System.in);
		//creation object of pojo class
		Student s =new Student();
		//creating the reference of studentdao interface
		StudentDAO sdao=new StudentDAOImpl();
		
		
		
		System.out.println("<====SIGNUP PAGE====>");
		System.out.println("Enter the name: ");
		//String name=sc.next();
		//s.setName(name);
		s.setName(sc.next());
		System.out.println("Enter the Phone no. : ");
		s.setPhone(sc.nextLong());
		System.out.println("Enter the mail ID: ");
		s.setMail(sc.next());
		System.out.println("Enter the Branch: ");
		s.setBranch(sc.next());
		System.out.println("Enter the Location: ");
		s.setLocation(sc.next());
		System.out.println("Enter the Password: ");
		String password = sc.next();
		System.out.println("Confirm the Password: ");
		String confirmPassword = sc.next();
		if(password.equals(confirmPassword)) {
			s.setPassword(confirmPassword);
			boolean res = sdao.insertStudent(s);
			if(res) {
				System.out.println("Data added successfully");
			}
			else {
				System.out.println("Failed to add the data");
			}
		}else {
			System.out.println("Password mismatch");
		}
		
	}

}