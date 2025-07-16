package in.pentagon.studentapp.model;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("Welcome to student app");
		
		do {
			System.out.println("1. SIGNUP");
			System.out.println("2. lOGIN");
			System.out.println("3. FORGOT PASSWORD");
			System.out.println("4. EXIT");
			
			choice=sc.nextInt();
			switch(choice) {
			case 1: Signup.signup();
			break;
			
			case 2:Login.login();
			break;
			
			case 3:Password.forgot();
			break;
			
			case 4: System.out.println("thank you");
			break;
			
			default: System.out.println("please enter valid choice");
			break;
			}
			
		}while(choice!=4);

	}

}
