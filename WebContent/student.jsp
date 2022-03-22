<!-- 
jabh onkeyup function chale onload per to value empty valye jaye gi to if conditi
chale gi phale har bar chalo ye to samaj aa gaya.per jabh hum koi number de ge
suppose (3) to wo name me store ho jaye ga phir wahi loop chale ga or [3 field]
print ho jaye gi or uska output addpro.html per ajax ke through apne app chale
jaye ga then Add Product click hoga to action call hogi AddProduct.jsp 
-->
<%
String s=request.getParameter("name"); //3
if(s==null||s.equals(""))
	
{
	out.println("please enter a number");
}
else
{
int n=Integer.parseInt(s); //become interger 3
for(int i=1;i<=n;i++)
{
	%>
	<h2>enter detail for product <%=i %></h2>
	PRODUCT_ID<input type="text" name="pid" /><br>
	PRODUCT_NAME<input type="text" name="name" /><br>
	PRODUCT_PRICE<input type="number" name="price" /><br>
	PRODUCT_CATEGORY<input type="text" name="cat" /><br>
	PRODUCT_COMPANY<input type="text" name="cmp" /><br>
	<%
}
%>
<input type="submit" value="Add Products" />
<h3 style="background-color:lightgreen;">I am Student.jsp</h3>
<%
}
%>
