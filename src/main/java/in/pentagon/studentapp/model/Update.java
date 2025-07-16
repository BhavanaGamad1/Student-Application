package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Update {

	public static void update(Student s) {
		 Scanner sc=new Scanner(System.in);
		 StudentDAO sdao=new StudentDAOImpl();
		 int choice=0;
		 System.out.println("Enter the field, you would like to update:");
		 
		 do {
			 
			 System.out.println("1. NAME");
			 System.out.println("2. PHONE");
			 System.out.println("3. MAIL");
			 System.out.println("4. BRANCH");
			 System.out.println("5. LOCATION");
			 System.out.println("6. BACK");
			 choice=sc.nextInt();
			 switch(choice) {
			 case 1: System.out.println("Enter the name to be updated:");
			 s.setName(sc.next());
			 break;
			 case 2: System.out.println("Enter the new Phone number");
			 s.setPhone(sc.nextLong());
			 break;
			 case 3: System.out.println("Enter the mail");
			 s.setMail(sc.next());
			 break;
			 case 4: System.out.println("Enter the Branch");
			 s.setBranch(sc.next());
			 break;
			 case 5: System.out.println("Enter the location:");
			 s.setLocation(sc.next());
			 break;
			 case 6: System.out.println("Main Menu");
			 break;
			 default:System.out.println("Invalid choice!");
			 break;
			 }
			 boolean res=sdao.updateStudent(s);
			 if(res) {
			 System.out.println("account updated");
			 }else {
			 System.out.println("Failed to update the data");
			 } 
		 }
			 while(choice!=6);
			}
		}



