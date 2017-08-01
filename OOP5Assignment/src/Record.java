import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Record {
	String name, content, userId, recordId;
	List<Record> recordsList;
	HashMap<String, List<Record>> postOfUsers = new HashMap<String, List<Record>>();

	/**
	 * @return the id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setUserId(String id) {
		this.userId = id;
	}

	/**
	 * @return the id
	 */
	public String getrecordId() {
		return recordId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setrecordId(String id) {
		this.recordId = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 
	 * @param recordId
	 * @param userId
	 * @param content
	 * @param name
	 */
	public void createRecord(String recordId, String userId, String content,
			String name) {
		boolean flag = true;
		Record record = new Record();
		record.setrecordId(recordId);
		record.setUserId(userId);
		record.setContent(content);
		record.setName(name);
		if (postOfUsers.containsKey(userId)) {
			for (Record r : postOfUsers.get(userId)) {
				if (r.getrecordId().equals(recordId)) {
					System.out
							.println("Record Id already exist ! Give a unique id .");
					flag = false;
					break;
				}
			}
			if (flag) {
				postOfUsers.get(userId).add(record);
			}
		} else {
			recordsList = new ArrayList<Record>();
			recordsList.add(record);
			postOfUsers.put(userId, recordsList);
		}
	}

	/**
	 * print records of user
	 * 
	 * @param userId
	 */
	public void printRecords(String userId) {
		recordsList = postOfUsers.get(userId);
		if ((!postOfUsers.containsKey(userId)) || recordsList.isEmpty()) {
			System.out.println("No records to display");
		} else {
			for (Record r : recordsList) {
				System.out.println("recordID : " + r.getrecordId()
						+ " title of post : " + r.getName() + " content : "
						+ r.getContent());
			}
		}
	}

	/**
	 * delete records of user
	 * 
	 * @param recordId
	 * @param userId
	 */
	public void deleteRecord(String recordId, String userId) {
		recordsList = postOfUsers.get(userId);
		boolean flag = true;
		for (Record r : recordsList) {
			if (r.getrecordId().equals(recordId)) {
				recordsList.remove(r);
				System.out.println("Record has been deleted");
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("Record id is invalid");
		}
	}
}
