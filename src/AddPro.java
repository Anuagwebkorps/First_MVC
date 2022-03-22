
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

@WebServlet("/AddPro")
public class AddPro extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String pid=request.getParameter("pid");
		String name=request.getParameter("name");
		String p1=request.getParameter("price");
		int price=Integer.parseInt(p1);
		String cat=request.getParameter("cat");
		String cmp=request.getParameter("cmp");

		Product p=new Product(); 
		
		p.setPid(pid);  // pid="1"       
		p.setName(name);
		p.setPrice(price);
		p.setCat(cat);
		p.setCmp(cmp);
		// int i=ps.executeUpdate(); --> isliye use nahi kiya ku ki wo hum Dao me bna chuke he
		ProductDao d=new ProductDao();
		try {
			int i=d.addProduct(p); //addProduct method he or p ref variable he Product class ka
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			if(i>0)
			{
				rd.include(request, response);
				out.println("<script>window.alert('added');</script>");
			}
			else
			{
				rd.include(request, response);
				out.println("<script>window.alert('not added');</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
	}

}
//**********************Day 1 End :)**************************************
