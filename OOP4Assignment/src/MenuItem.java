public abstract class MenuItem {
	protected String name;
	protected Menu parent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
}
