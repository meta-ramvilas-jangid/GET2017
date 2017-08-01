import java.util.HashMap;

public class Graph implements Node {
	
	HashMap<String,Entity> map = new HashMap<String,Entity>();
	public Graph(String file){
		String stringOutput[] = file.split("\n");
		for(String s:stringOutput){
			System.out.println("ALEPHA : "+s);
			System.out.println(" "+stringOutput.length+" ");
		}
		Entity entity;
		String str[]={};
		for(int index = 0;index < stringOutput.length ; index ++)
		{
			str = stringOutput[index].split(",");
			if(str[2].equals("user"))
		{
			entity = new User();
			entity.setType(str[2]);
		}
		else{
			entity = new Organization();
			entity.setType(str[2]);
		}
		entity.setId(str[0]);
		entity.setName(str[1]);
		map.put(str[0], entity);
		}
	}
    
	public void createNode(User obj, String name, String id){
		obj.setType("user");
		obj.setName(name);
		obj.setId(id);
		addNode(obj);
	}
	
	public void createNode(Organization obj, String name, String id){
		obj.setType("organization");
		obj.setName(name);
		obj.setId(id);
		addNode(obj);
	}
	
	public void addNode(Entity obj){
		map.put(obj.getId(), obj);
	}
	
	public boolean checkNode(String id){
		
		if(map.containsKey(id)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void editNode(String id,String name){
		map.get(id).setName(name);
	}
	
	public void deleteNode(String id){
		map.remove(map.get(id));
	}
	
	public String printName(String id){
		return map.get(id).getName();
	}
	
}
