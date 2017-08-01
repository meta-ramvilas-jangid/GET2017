
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Connection {

	HashMap<String, List<String>> connectionMap = new HashMap<String, List<String>>();

	/**
	 * constructor to get list of connections
	 * 
	 * @param file
	 */
	public Connection(String file) {
		String stringOutput[] = file.split("\n");
		for (int index = 0; index < stringOutput.length; index++) {
			List<String> listOfFriends = new ArrayList<String>();
			String str[] = stringOutput[index].split(",");
			for (int jindex = 1; jindex < str.length; jindex++) {
				listOfFriends.add(str[jindex]);
			}
			connectionMap.put(str[0], listOfFriends);
		}
	}

	/**
	 * add connection to a userId
	 * 
	 * @param friendId
	 * @param userID
	 */
	public void addConnection(String friendId, String userID) {
		// TODO Auto-generated method stub
		if (connectionMap.containsKey((userID))) {
			if (connectionMap.get(userID).contains(friendId)) {
				System.out.println("Already your friend");
			} else {
				connectionMap.get(userID).add(friendId);
				if (connectionMap.containsKey((friendId))) {
					connectionMap.get(friendId).add(userID);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(userID);
					connectionMap.put(friendId, list);
				}
			}
		} else {
			List<String> list = new ArrayList<String>();
			list.add(friendId);
			connectionMap.put(userID, list);
		}
	}

	/**
	 * remove the connection from user
	 * 
	 * @param friendId
	 * @param userID
	 */
	public void removeConnection(String friendId, String userID) {
		// TODO Auto-generated method stub
		if (connectionMap.get(userID).contains(friendId)) {
			connectionMap.get(userID).remove(friendId);
			connectionMap.get(friendId).remove(userID);
			System.out.println("Connection successfully removed");
		} else {
			System.out.println("Id does not exist in your Friend List ");
		}
	}

	/**
	 * print all connections of user
	 * 
	 * @param userId
	 */
	public void printConnections(String userId) {
		if (connectionMap.containsKey(userId)
				&& (!connectionMap.get(userId).isEmpty())) {
			System.out.println(userId + " = " + connectionMap.get(userId));
		} else {
			System.out.println("No Friends available");
		}
	}

	/**
	 * print social network
	 */
	public void printNetwork() {
		Iterator itr = connectionMap.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}
	}
}