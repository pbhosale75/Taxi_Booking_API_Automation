package Serilization;

public class Message {
	private String firstname;
	private String lastname;
	private String subjectID;
	private String id;
	private MessageInfo message;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getID() {
		return id;
	}
	public void setID(String ID) {
		this.id = ID;
	}
	public MessageInfo getMessageInfo() {
	   return message; 
	   } 
	  public void setMessageInfo(MessageInfo message) { 
		  this.message=message; 
		  }

}
