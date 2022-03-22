<jsp:useBean id="pd" class="pp.ProductDao"></jsp:useBean>
<%@page import="pp.Product"%>
<%@page import="java.util.List"%>
<h2 style="background-color:pink;">I am search.jsp page</h2>
<table align="center" border="1px">
<% String name=request.getParameter("name");
	List<Product> al=pd.search(name);
	if(al.isEmpty())
	{
		out.println("no data found");	
	}
	
	else
	{
	for(Product p:al)
	{
		%>
		<tr>
		<td><%=p.getPid() %></td>
		<td><%=p.getName() %></td>
		<td><%=p.getPrice() %></td>
		<td><%=p.getCat() %></td>
		<td><%=p.getCmp() %></td>
		</tr>
		<%
	}
	}
%>
</table>