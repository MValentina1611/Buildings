package model;

public class Person implements Comparable<Person>{

	 public String name;
	    private int currentFloor;
	    public int desiredOffice;
	    public boolean isOnOffice;
	    private int futureFloor;
	    public Person(String name,int currentFloor, int desiredOffice, boolean isOnOffice) {
	        this.name = name;
	        this.currentFloor = currentFloor;
	        this.desiredOffice = desiredOffice;
	        this.isOnOffice = isOnOffice;
	    }

	    public Person(Person person, int futureFloor)
	    {
	    	this.futureFloor = futureFloor;
	    }
	    
		public String getName() {
	        return name;
	    }

	    public int getCurrentFloor() {
	        return currentFloor;
	    }

	    public int getDesiredOffice() {
	        return desiredOffice;
	    }

	    public boolean isOnOffice() {
	        return isOnOffice;
	    }

	    public void setOnOffice(boolean onOffice) {
	        isOnOffice = onOffice;
	    }

		@Override
		public int compareTo(Person o) {
			if(this.futureFloor < o.getfutureFloor()) 
			{
				return -1;
			}
			else if(this.futureFloor> o.getfutureFloor()){
				return 1;
			}
			else
			{
				return 0;
			}
		}

		public int getfutureFloor() {
			return futureFloor;
		}
}
