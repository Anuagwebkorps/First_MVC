	//***************Day 1 Start :)************************
package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.apache.jasper.tagplugins.jstl.core.Out;

public class ProductDao {
	Connection con; //con is reference variable connection interface
	PreparedStatement ps;
	public Connection getCon() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");//Driver load
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/firstmvc","root","");//Connection stablish
	}
	public int addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		con=getCon();
		String qr="insert into product values(?,?,?,?,?)";
		ps=con.prepareStatement(qr); //PreparedStatement ps =con.prepareStatement(qr);
		ps.setString(1, p.getPid()); //	ps.setString(1, id);
		ps.setString(2, p.getName());
		ps.setInt(3, p.getPrice());
		ps.setString(4, p.getCat());
		ps.setString(5, p.getCmp());
		
		return ps.executeUpdate();
	}
	//***************Day 1 end :)************************
	
	//***************Day 2 Start :)************************
	          //generic        //showw :- method he list me ese likhte he
	public List<Product> showw() throws ClassNotFoundException, SQLException //List is an interface whereas ArrayList is the implementation class of List.
	{
		con=getCon();
		String qr="select * from product";
		Statement st=con.createStatement(); //It is used to sending a SQL query to database  //con= is a variable of connection interface
		ResultSet rs=st.executeQuery(qr);
		ArrayList<Product> al=new ArrayList<Product>();//creating new generic arraylist  -->humne specifay ker diya ki Product type ka obj use hogaa
		while(rs.next())
		{
			Product p=new Product();
			p.setPid(rs.getString("pid"));//hum isko ese bhi likh skte he String id=(rs.getString("pid"));
		    p.setName(rs.getString("name")); //String name=rs.getString("name");
			p.setPrice(rs.getInt("price"));    
			p.setCat(rs.getString("cat"));
			p.setCmp(rs.getString("cmp"));
			al.add(p);
		}
		return al;
	}

//***************Day 2 end :)************************

//***************Day 3 Start :)************************
	                 // s=starting t=total 
public List<Product> showpage(int s,int t) throws ClassNotFoundException, SQLException
{
	con=getCon();
	Statement st=con.createStatement();
	String qr="select * from product limit "+s+","+t; //hum jitna data show kerna chye sirf utna hi ker skte he limit query ki help se
	ResultSet rs=st.executeQuery(qr);
	ArrayList<Product> al=new ArrayList<Product>();
	while(rs.next())
	{
		Product p=new Product();
		p.setPid(rs.getString("pid"));
		p.setName(rs.getString("name"));
		p.setPrice(rs.getInt("price"));
		p.setCat(rs.getString("cat"));
		p.setCmp(rs.getString("cmp"));
		al.add(p);
	}
	return al;

}

//***************Day 3 end :)************************

//***************Day 4 Start :)************************
public List<Product> search(String name) throws ClassNotFoundException, SQLException
{
	con=getCon();
	String qr="select * from  product where name like '"+name+"%'";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(qr);
	ArrayList<Product> al=new ArrayList<Product>();
	while(rs.next())
	{
		Product p=new Product();
		p.setPid(rs.getString("pid"));
		p.setName(rs.getString("name"));
		p.setPrice(rs.getInt("price"));
		p.setCat(rs.getString("cat"));
		p.setCmp(rs.getString("cmp"));
		al.add(p);
	}
	return al;
}


//***************Day 4 end :)************************
//***************Day 5 start :)************************

public ArrayList<String> showcitystate(String state) throws ClassNotFoundException, SQLException
{
	con=getCon();
	String qr="select * from citystate where state=?";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1, state);
	ResultSet rs=ps.executeQuery();
	ArrayList<String> al=new ArrayList<String>();//String isliye aye ga hum product mese abb nahi le rahe data
	while(rs.next())
	{
		al.add(rs.getString("city")); //add isliye use kiya ku city ajaye uss state kii
	}
	return al; //ab al me city aagaii
}
public int delproduct(Product p) throws ClassNotFoundException, SQLException
{
	con=getCon();
	String qr="delete from product where name=?";
	ps=con.prepareStatement(qr); //PreparedStatement ps =con.prepareStatement(qr);
	ps.setString(1, p.getName());
	return ps.executeUpdate();
}
 }
//***************Day 5 end :)************************

















