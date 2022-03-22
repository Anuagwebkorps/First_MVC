<!-- 
jabh hum name form ya input field me same rakhte he tab usko get kerne 
ke liye ==>getParameterValues() use kerte he same value ek hi parameter me use hogii
isliye Array use kere ge
-->
<%@page import="pp.ProductDao"%>
<%@page import="pp.Product"%>
<%
String pid[]=request.getParameterValues("pid");
String name[]=request.getParameterValues("name");
String price[]=request.getParameterValues("price");
String cat[]=request.getParameterValues("cat");
String cmp[]=request.getParameterValues("cmp");
String t1=request.getParameter("t1");
int n=Integer.parseInt(t1); //name="t1" ye
int t=0;
ProductDao pd=new ProductDao();
for(int i=0;i<n;i++)
{
	Product p=new Product();
	p.setPid(pid[i]);
	p.setName(name[i]);
	p.setPrice(Integer.parseInt(price[i]));
	p.setCat(cat[i]);
	p.setCmp(cmp[i]);
	t=t+pd.addProduct(p); //method
}
out.println(t+" products added successfully");
%>