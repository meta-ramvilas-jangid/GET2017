/*
 *  class to define guest
 */
public class Guest {
	
	private String name;
	private int age;
	
	/**
	 * Parameterized constructor for setting guest name and guest age
	 * @param guestName
	 * @param guestAge
	 */
	public Guest(String name , int age)	{	
		this.name = name;
		this.age = age;
	}
	
	public String getGuestName() {	
		return this.name;
	}
	
	public int getGuestAge() {
		return this.age;
	}

}