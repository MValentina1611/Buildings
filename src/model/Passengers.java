package model;

import java.util.ArrayList;

public class Passengers extends Queue<Person> {

	
	public Passengers(ArrayList<Person> persons)
	{
		Queue<Person> passengers = new Queue<Person>();
		for(int i = 0; i < persons.size(); i++)
		{
			passengers.enqueue(persons.get(i));
		}
	}
	
	//Ascensor va subiendo
	public Person dequeueMinPriority(int currentFloor)
	{
		Person toOut = null;
		Node<Person> aux2 = new Node<>();
		Node<Person> auxh = head;
	
		while(auxh != null)
		{
			if( auxh.getItem().getfutureFloor() >= currentFloor)
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
	
	//Ascensor va bajando
	public Person dequeueMaxPriority( int currentFloor)
	{
		Person toOut = null;
		Node<Person> aux2 = new Node<>();
		Node<Person> auxh = head;
		
		while(auxh != null)
		{
			if( auxh.getItem().getfutureFloor() < currentFloor)
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
	
}
