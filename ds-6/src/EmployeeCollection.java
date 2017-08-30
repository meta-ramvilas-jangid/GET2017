import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


public class EmployeeCollection {

	Map<String,Employee> map;
	List<Employee> empList;
	
	public EmployeeCollection(){
		map=new HashMap<String, Employee>();
		empList=new ArrayList<Employee>();
	}
	
	public void addEmp(Employee  emp){
		String empid=emp.getEmpid();
		if(map.containsKey(empid)){
			System.out.println("Empid "+empid+" already exist");	
		} else{
			map.put(empid, emp);
			empList.add(emp);
		}
		
	}
	public String toString(){
		String output=" ";
//		for(String str:map.keySet()){
//			output+="\n"+str+"  "+map.get(str) ;
//		}
		output+="\n\nList of employee is :";
		for(Employee e : empList){
			output+="\n"+e;
		}
		return output;
	}
	
	public void sortByName(){
		Collections.sort(empList,new Comparator<Employee>(){

			@Override
			public int compare(Employee arg0, Employee arg1) {
				// TODO Auto-generated method stub
				return  arg0.getName().compareTo(arg1.getName());
			}
			
		});
	}
	
	
	public void sortNatural(){
		Collections.sort(empList,new Comparator<Employee>(){

			@Override
			public int compare(Employee arg0, Employee arg1) {
				// TODO Auto-generated method stub
				return  arg0.getEmpid().compareTo(arg1.getEmpid());
			}
			
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeCollection e=new EmployeeCollection();
		e.addEmp(new Employee("c11","Ram","jodhpur"));
		e.addEmp(new Employee("b15","Karan","Jaipur"));
		e.addEmp(new Employee("a12","Gunjan","Ajmer"));
		e.addEmp(new Employee("9","Satyam","Udaipur"));
		e.addEmp(new Employee("a12","Gunjan","Ajmer"));
		System.out.println(e);
		System.out.println("\nSorted by Natural");
		e.sortNatural();
		System.out.println(e);
        System.out.println("\nSorted by Name");
		e.sortByName();
		System.out.println(e);
	}

}
