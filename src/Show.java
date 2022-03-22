

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pp.Product;
import pp.ProductDao;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ProductDao rd=new ProductDao();
		try {
			List<Product> al=rd.showw(); //al -->reference variable he ArrayList ka 
			out.println("<table align=center border=1px>");
			for(Product p:al)
			{
				out.println("<tr>");
				out.println("<td>");
				out.println(p.getPid());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getName());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getPrice());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getCat());
				out.println("</td>");
				out.println("<td>");
				out.println(p.getCmp());
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
