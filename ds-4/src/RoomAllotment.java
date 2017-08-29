import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class RoomAllotment {
	BufferedReader bufferedReader = null;
	public RoomAllotment() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args) {
		RoomAllotment roomAllotment = new RoomAllotment();
		try{
			GuestHouse guestHouse = new GuestHouse("Test Guest House", 97);
			List<Character> roomsList = guestHouse.assignRoomNumbers();
			
			char userPermission = '\0';
			int roomsOccupied = 0;
			do {
				System.out.println("Welcome to "+ guestHouse.getGuestHouseName());
				String guestName = roomAllotment.getUserStringInput("Please enter your name");
				int guestAge = roomAllotment.getUserIntegerInput("Please enter your age");

				Guest guest = new Guest(guestName , guestAge);
				
                int roomAlloted = roomAllotment.allotRoomNumberToGuest(roomsList , guestAge , roomsOccupied);
                System.out.println("Hwllo");
				// increment the rooms occupied variable 
				roomsOccupied++;

				// displaying result
				if(roomAlloted == -1) {
					System.out.println(guest.getGuestName()+" Cannot assign room.All the rooms are occupied");
				} else{
					System.out.println("Thank you "+ guest.getGuestName() +"The room alloted to you is: "+roomAlloted);
				}

				// taking user permission to continue
				userPermission = roomAllotment.getUserStringInput("Press Y or y to continue").charAt(0);
			}while(userPermission == 'y' || userPermission == 'Y');
			
			for(int i = 0 ; i < 97 ; ++i ) {
				System.out.print(roomsList.get(i));;
			}
		}
		catch(Exception ex){
			System.out.println("Something went wrong: "+ex.getMessage());
		}		
	}

	/**
	 * This method computes for alloted room , if empty then returned else incremented until 
	 * alloted room is not empty(Linear)
	 * @param roomsList
	 * @param guestAge
	 * @return alloted room
	 */
	public int allotRoomNumberToGuest(List<Character> roomsList , int guestAge , int roomsOccupied) {	
		if(roomsOccupied >= roomsList.size()) {
			return -1;
		}

		int allotedRoom = (guestAge % roomsList.size());
	    // until alloted room is not empty
		 System.out.println(allotedRoom+"Hwllo");
		while(roomsList.get(allotedRoom) != '-') {
			// increment 
			 System.out.println(allotedRoom+"Hwlloin");
			allotedRoom++;

			// if greater than size of rooms then 0 it
			if(allotedRoom == roomsList.size()){
				allotedRoom = 0;
			}
		}
		roomsList.set(allotedRoom, 'F');
		return allotedRoom;
	}

	public String getUserStringInput(String message){			
		String userInput = "";
		try{
			System.out.println(message);
			userInput = bufferedReader.readLine();
		}
		catch(Exception ex){
			System.out.println("Invalid Input : "+ex.getMessage());
			getUserStringInput(message);
		}
		return userInput;
	}

	public int getUserIntegerInput(String message) {
		int userInput = 0;
		try{
			System.out.println(message);
			userInput = Integer.parseInt(bufferedReader.readLine());
		}
		catch(Exception ex){
			System.out.println("Invalid Input : "+ex.getMessage());
			getUserIntegerInput(message);

		}
		return userInput;
	}
}