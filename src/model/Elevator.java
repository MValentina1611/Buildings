package model;

import java.util.ArrayList;

public class Elevator {
	
    private Passengers passengers;
    private boolean rising = true;

    public Elevator(Passengers passengers)
    {
        rising = true; //  El ascensor empieza en el primer piso
        this.passengers = passengers;
        
    }
    
    public ArrayList<Person> movements(int floorsNum)
    {
        ArrayList<Person> toOut = new ArrayList<Person>();
        int currentFloor = 1;
        System.out.println(floorsNum);
        
        if(rising)
        {
        	System.out.println("it's rising");
            if(passengers.getPassengers().getHead().getItem().getfutureFloor() >= currentFloor)
            {
            	
            	System.out.println(passengers.dequeueMinPriority(currentFloor).toString());
            	
            	if(currentFloor== floorsNum)
            	{
            		System.out.println("Llegó arriba");
            		rising = false;
            		movements(currentFloor);
            	}
            }
            else {
            	movements(currentFloor+1);
            }
        }
        else {
            if(passengers.getPassengers().getHead().getItem().getfutureFloor() < currentFloor)
            {
            	System.out.println("Bajando y sacando a");
            	System.out.println(passengers.dequeueMaxPriority(currentFloor).toString());
            }
            else
            {
            	movements(currentFloor-1);
            }
            
        }
        return toOut;
    }
    
    public Passengers getPassengers() {
        return this.passengers;
    }
    
    
}