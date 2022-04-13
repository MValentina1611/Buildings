package model;

public class Office {

	private boolean occupied;
	private Person personInOffice;
	private int officeNum;
	
	public Office(int officeNum)
	{
		this.occupied = false;
		this.personInOffice = null;
		this.officeNum = officeNum;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied, Person personInOffice) {
		this.occupied = occupied;
		Person newPerson = new Person(personInOffice.name,personInOffice.getCurrentFloor(),personInOffice.getDesiredOffice(),personInOffice.isOnOffice,personInOffice.getfutureFloor());
		this.personInOffice = newPerson;
		
	}

	/*
	public Person getPersonInOffice() {
		return personInOffice;
	}

	public void setPersonInOffice(Person personInOffice) {
		this.personInOffice = personInOffice;
	}
	*/
	public int getOfficeNum() {
		return officeNum;
	}

	public void setOfficeNum(int officeNum) {
		this.officeNum = officeNum;
	}
	
	public String toString()
	{
		
		return "OFFICE "+officeNum+":\n\tIs OCCUPIED: "+isOccupied()+"\n\tPERSON: "+personInOffice;
	}
}
