//hum ye phale servlet me ye programm nahii bante thae .hum ise isliye bana rah he kukii hume code pura  object oriented chiyee for sceurity purpose.    
//private humne isliye rakha ku ki koi or excese na ker paye.isliye humne 
//setter getter ka use kiya he jab bhi hum pid,name,price.. chiye hoga hum
//simply use ker le ge.
//this ==>  current object refer ker raha he
//*****ye he main funda spring kaaa *********
//The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. To achieve this, you must:
// 1) declare class variables/attributes as private
// 2) provide public get and set methods to access and update the value of a private variable
// link for more about seteer and getter:-https://www.w3schools.com/java/java_encapsulation.asp
//pp package me rakhna he bus rakhna he 
package pp;

public class Product {
	private String pid;
	private String name;
	private int price;
	private String cat;
	private String cmp;
	
	//setter getter
	public String getPid() { //Getter or Accessor methods are used to retrieve the values of a private variable.They must have a return type
		return pid;
	}
	public void setPid(String pid) {//Setter or Mutator methods are used to change the value of private variables. They do not have return types.
		this.pid = pid; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getCmp() {
		return cmp;
	}
	public void setCmp(String cmp) {
		this.cmp = cmp;
	}
	
}
