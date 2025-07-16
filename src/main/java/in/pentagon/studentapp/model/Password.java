package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {

	public static void forgot() {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		
		System.out.println("Enter the phone number:");
		long phone =sc.nextLong();
		System.out.println("Enter the mail id:");
		String mail=sc.next();
		
		Student s=sdao.getStudent(phone, mail);
		
		
		if (s != null) {
            
            System.out.println("Enter your new password:");
            String newPassword = sc.next();
            System.out.println("Confirm your new password:");
            String confirmPassword = sc.next();
            

            if (newPassword.equals(confirmPassword)) {
            	s.setPassword(newPassword);
                boolean res = sdao.updateStudent(s);
                if (res) {
                    System.out.println(" Password updated successfully.");
                } else {
                    System.out.println("Failed to update password.");
                }
            } else {
                System.out.println(" Passwords  mismatch.");
            }

        } else {
            System.out.println(" No student found with this email.");
        }
    }
}