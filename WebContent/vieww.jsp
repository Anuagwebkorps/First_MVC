<!-- *********Dynamic Pagination**** -->
<%@page import="pp.ProductDao"%>
<%@page import="pp.Product"%>
<%@page import="java.util.List"%>
<table align="center" border="2px">
<%
ProductDao pd=new ProductDao();
String t=request.getParameter("id");
int id=Integer.parseInt(t);
int total=5;
if(id==1)
{
	id=id-1;
}
else
{
	id=id-1;
	id=id*total;
}
List<Product> al=pd.showpage(id, total); //0,5
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
int l=pd.showw().size(); // l=me total data ,row aa gaii
int c=1;
out.println("Total no of row in showw method:"+l);
%>
<tr>

<%
for(int i=1;i<=l;i=i+5)//i=1,6,11,16,21,26,(31=false)          //l=30
{
	%>
	<td>
		<a href="vieww.jsp?id=<%=c %>"><%=c %></a> <!-- 1, -->
	</td>
	
	<%
	c++;
}
%>
</tr>
</table>