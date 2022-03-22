
////**********************Day 1 Start :)**************************************

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pp.Product;
import pp.ProductDao;

@WebServlet("/Dele")
public class Dele extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		Product p=new Product(); 
		p.setName(name);
		// int i=ps.executeUpdate(); --> isliye use nahi kiya ku ki wo hum Dao me bna chuke he
		ProductDao d=new ProductDao();
		try {
			int i=d.delproduct(p); //addProduct method he or p ref variable he Product class ka
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			if(i>0)
			{
				rd.include(request, response);
				out.println("<script>window.alert('delete');</script>");
			}
			else
			{  
				rd.include(request, response);
				out.println("<script>window.alert('not delete');</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
	}

}
//**********************Day 1 End :)**************************************
