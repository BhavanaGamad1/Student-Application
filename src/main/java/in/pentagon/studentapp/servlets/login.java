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
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet  {
	  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO sdao=new StudentDAOImpl();
		HttpSession session=req.getSession(true);
//		PrintWriter out=resp.getWriter();
		
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		
		Student s=sdao.getStudent(mail, password);
		if(s!=null) {
			//out.println("<h1>Login successfull </h1>"+ s.getName());
			//req.setAttribute("student", s);
			session.setAttribute("student", s);
			req.setAttribute("success", "login successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}else {
			//out.println("<h1>Failed to Login </h1>");
			req.setAttribute("Error", "Failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
