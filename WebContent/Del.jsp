<%@page import="pp.ProductDao"%>
<%@page import="pp.Product"%>
<%
String name=request.getParameter("name");
Product p=new Product(); 
p.setName(name);//setName hum isliye use ker ku ki abb Dao me get kerwana pafegii na
ProductDao d=new ProductDao();
try {
	int i=d.delproduct(p); //delproduct method he or p ref variable he Product class ka 
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
%>