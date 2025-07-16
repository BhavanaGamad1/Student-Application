package in.pentagon.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class signup extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Creation of pojo class object
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImpl();
		PrintWriter out=resp.getWriter();
		//collecting the data from the UI
		//String name=req.getParameter("name");
		//s.setName(name);
		s.setName(req.getParameter("name"));
		
		//String phone=req.getParameter("phone");
		//long phone_no=Long.parseLong(phone);
		//s.setPhone(phone_no);
		
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLocation(req.getParameter("location"));
		if(req.getParameter("password").equals(req.getParameter("conform"))) {
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.insertStudent(s);
			if(res) {
				//out.println("<h1>Data saved successfully</h1>");
				req.setAttribute("success", "Account Created successfully");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}else {
				//out.println("<h1>Failed to save the data</h1>");
				req.setAttribute("error", "Failed to create an account");
				RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				rd.forward(req, resp);
			}
			
		}else {
			//out.println("<h1>Password mismatch</h1>");
			req.setAttribute("error", "password updated successfully");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}

	}

}
