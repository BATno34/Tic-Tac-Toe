man har kari bekham mikonam bande khoda
package Feb25_BankProject;

public class Customer {
	private String fName;
	private String lName;
	private String city;
	
	//constructor
	public Customer (String fName, String lName, String city) {
		this.fName = fName;
		this.lName = lName;
		this.city = city;
	}
	
	public String toString() {
		String objString;
		
		objString = fName + " " + lName + "\n";
		objString += city;
		
		return objString;
	}
	
}
