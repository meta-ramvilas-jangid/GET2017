public interface Node {
	
	public void createNode(User obj, String name, String id);

	public void createNode(Organization obj, String name, String id);
		
	public void addNode(Entity obj);
	
	public boolean checkNode(String id);
	
	public void editNode(String id,String name);
	
	public void deleteNode(String id);
	
}
