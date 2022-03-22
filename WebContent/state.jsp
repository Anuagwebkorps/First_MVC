<%@page import="java.util.ArrayList"%>
<%@page import="pp.ProductDao"%>
<h2 style="background-color:pink;">I am state.jsp page</h2>

<%
String state=request.getParameter("state");
 out.println("welcome to "+state);
ProductDao pd=new ProductDao();
ArrayList<String> al=pd.showcitystate(state);
for(String c:al) //al me city he jo ProductDao se aayi
{
	%>
	City:<option><%=c %></option>
	<%
}
%>
