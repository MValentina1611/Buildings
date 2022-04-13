package model;

import java.util.ArrayList;

import strcs.Queue;


public class Passengers{

	private Queue<Person> passengers;
	
    public Passengers(ArrayList<Person> people) 
    {  
    	passengers = new Queue<Person>();
    	//System.out.println("se crea");
    	
        for(int i = 0; i < people.size(); ++i) 
        {
            passengers.enqueue(people.get(i));
            //System.out.println("Se encola ");
            //System.out.println(passengers.getTale());
        }
       //System.out.println(passengers.size());
        
    }

    
    /*
    public Person dequeueMinPriority(int currentFloor, boolean reachedFloor)
	{
		Person toOut = null;
		Node<Person> aux2 = new Node<>(toOut);
		Node<Person> auxh = passengers.getHead();
		
		while(auxh != null)
		{
			if( auxh.getItem().getfutureFloor() >= auxh.getItem().getCurrentFloor() && ( auxh.getItem().getfutureFloor() == currentFloor || reachedFloor == true) )
			{
				aux2.setNext(auxh.getNext());
				toOut = auxh.getItem();
				break;
			}
			aux2 = auxh;
			auxh = auxh.getNext();
		}
		return toOut;
		
	}
    public Person dequeueMaxPriority(int currentFloor)
	{
		Person toOut = null;
		Node<Person> aux2 = new Node<>();
		Node<Person> auxh = passengers.getHead();
		
		while(auxh != null)
		{
			if( auxh.getItem().getfutureFloor() < auxh.getItem().getCurrentFloor() && (currentFloor == auxh.getItem().getCurrentFloor()    )
			{
				aux2.setNext(auxh.getNext());
				toOut = auxh.getItem();
				break;
			}
			aux2 = auxh;
			auxh = auxh.getNext();
		}	
		return toOut;
				
	}
    */
	public Queue<Person> getPassengers() {
		return passengers;
	}

	
	
}