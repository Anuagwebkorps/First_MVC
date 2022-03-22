                  <%--***********Pagination*********** --%>
 <%-- Is hume har page per data mil jaye ga but ek problem he ye dynamic nahii--%>    
 <!-- Hee line (42) per humne 5 page banye to utna hi data batyee ga vieww.jsp dynamic he  -->             
<%@page import="pp.ProductDao"%>
<%@page import="pp.Product"%>
<%@page import="java.util.List"%>
 
<table align="center" border="1px">
<td>id</td>
<td>name</td>
<td>PRICE</td>
<td>CATEGORY</td>
<td>COMPANY</td>
<%
ProductDao pd=new ProductDao(); //ProductDao ka obj isliye banya ku ki hume showpage() method chiye thi[line 20]
String t=request.getParameter("id");
int id=Integer.parseInt(t); //number-->String
int total=5;
if(id==1)  // 1=1     //id=1 de rah he urlRewriting se index.html me
{
	id=id-1; //id=1-1=0
}
else
{
	id=id-1;
	id=id*total;
}
List<Product> al=pd.showpage(id, total); //(id=0,total=5) iska matlab humne limit set ker di ab 0 se 5 tk ke data hi show hoge
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
%>
<tr>
<td>
<a href="view.jsp?id=1">1</a>
<a href="view.jsp?id=2">2</a>
<a href="view.jsp?id=3">3</a>
<a href="view.jsp?id=4">4</a>
<a href="view.jsp?id=5">5</a>

</td>
</tr>
</table>