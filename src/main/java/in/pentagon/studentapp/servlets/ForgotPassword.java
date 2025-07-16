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
@WebServlet("/password")
public class ForgotPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO sdao=new StudentDAOImpl();
		PrintWriter out = resp.getWriter();
		Student s = sdao.getStudent(Long.parseLong(req.getParameter("phone")), req.getParameter("mail"));
		String password = req.getParameter("password");
		if(s!=null) {
			if(password.equals(req.getParameter("conform"))) {
				s.setPassword(password);
				boolean res = sdao.updateStudent(s);
				if(res) {
					//out.println("<h1>Password Updated Successfully</h1>");
					req.setAttribute("success", "password updated successfully");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}
				else {
					//out.println("<h1>Failed To Update</h1>");
					req.setAttribute("error", "Failed to update the password");
					RequestDispatcher rd=req.getRequestDispatcher("password.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				//out.println("<h1>Password Mismatch!</h1>");
				req.setAttribute("error", "password mismatch");
				RequestDispatcher rd=req.getRequestDispatcher("password.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1>Student data not found</h1>");
			req.setAttribute("error", "Student not found");
			RequestDispatcher rd=req.getRequestDispatcher("password.jsp");
			rd.forward(req, resp);
		}


	}

}
