package model;

import java.util.ArrayList;

public class Elevator {
	
    private Passengers passengers;
    private boolean rising = true;
    private int [] reachedFloors;
    ArrayList<Person> toOut;
    public Elevator(Passengers passengers)
    {
        rising = true; //  El ascensor empieza en el primer piso
        this.passengers = passengers;
        toOut = new ArrayList<Person>();
    }
    
    public ArrayList<Person> movements()
    {
        
       // System.out.println(floorsNum);
        if(passengers.getPassengers().getHead()!= null)
        {
        	if(rising)
        	{
        		//System.out.println("it's rising");
        		if(passengers.getPassengers().getHead().getItem().getfutureFloor() >= passengers.getPassengers().getHead().getItem().getCurrentFloor() )
        		{
        			
        			toOut.add(passengers.getPassengers().dequeue().getItem());
        			//System.out.println(toOut.size());
        			//System.out.println(toOut.get(toOut.size()-1));
        			movements();
        			
        		}
        		else {
        			rising = false;
        			movements();
        		}
        	}
        	else {
        		if( passengers.getPassengers().getHead().getItem().getfutureFloor() < passengers.getPassengers().getHead().getItem().getCurrentFloor())
        		{
        			//System.out.println("it's going Down");
        			toOut.add(passengers.getPassengers().dequeue().getItem());
        			//System.out.println(toOut.size());
        			movements();

        		}

        	}
        }
        return toOut;
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