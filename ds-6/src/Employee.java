 	
public class Employee {
	
	private String empid;
	private String name;
	private String address;
	
	public Employee(String empid, String name, String address){
		this.empid=empid;
		this.name=name;
		this.address=address;
		
	}
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String toString(){
		String str=" empid "+empid+" name "+name+" address "+address;
		return str;
		
		
	}
}
