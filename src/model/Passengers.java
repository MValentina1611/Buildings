package model;

import java.util.ArrayList;
import java.util.Currency;

public class Passengers{

	private Queue<Person> passengers;
	private ArrayList<Person> toOut;
	
    public Passengers(ArrayList<Person> people) 
    {  
    	passengers = new Queue<Person>();
    	System.out.println("se crea");
    	toOut = new ArrayList<Person>();
        for(int i = 0; i < people.size(); ++i) 
        {
            passengers.enqueue(people.get(i));
            System.out.println("Se encola ");
            //System.out.println(passengers.getTale());
        }
       System.out.println(passengers.size());
        
    }

    
   
    public void dequeueByPriority(int currentFloor)
	{
		Node<Person> aux2 = new Node<>();
		Node<Person> auxh = passengers.getHead();
		
		System.out.println("Dequeue");
		while(auxh != null)
		{
			System.out.println("distinto de null");
			if( auxh.getItem().getfutureFloor() == currentFloor )
			{
				aux2.setNext(auxh.getNext());
				toOut.add(auxh.getItem());
				System.out.println("Añadio");
			}
			aux2 = auxh;
			auxh = auxh.getNext();
		}
		
	}
    
    /*
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



	public ArrayList<Person> getToOut() {
		return toOut;
	}

	
	
}