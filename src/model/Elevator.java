package model;

import java.util.ArrayList;

public class Elevator {
	
    private Passengers passengers;
    private boolean rising = true;
    private int floorsNum;
    //ArrayList<Person> toOut;
    public Elevator(Passengers passengers, int floorsNum)
    {
        rising = true; //  El ascensor empieza en el primer piso
        this.passengers = passengers;
        //toOut = new ArrayList<Person>();
        this.floorsNum = floorsNum;
        
    }
    
    public void movements(int currentFloor)
    {
       // System.out.println(floorsNum);
        if(passengers.getPassengers().getHead()!= null)
        {
        	if(rising)
        	{
        		System.out.println("it's rising");
        		if(currentFloor <= floorsNum)
        		{
        			passengers.dequeueByPriority(currentFloor);
        			//System.out.println(toOut.size());
        			//System.out.println(toOut.get(toOut.size()-1));
        			System.out.println(passengers.getToOut().get(passengers.getToOut().size()-1).toString());
        			movements(currentFloor+1);	
        		}
        		if( currentFloor == floorsNum)
        		{
        			rising = false;
        			movements(currentFloor--);
        		}
        	}
        	else {
        		System.out.println("it's going Down");
        		//passengers.dequeueByPriority(currentFloor);
        		//System.out.println(toOut.size());
        		//movements(currentFloor--);

        		}

        	}
        }
    
    
    /*
    public boolean verifyReachedFloors(int floorToVerify)
    {
    	boolean reachedFloor = false;
    	
    	for(int i = 0; i < reachedFloors.length; i++)
    	{
    		if(reachedFloors[i] == floorToVerify)
    		{
    			reachedFloor = true;
    			break;
    		}
    	}
    	
    	return reachedFloor;
    }
   */
    
    
    public Passengers getPassengers() {
        return this.passengers;
    }
    
    
}