package model;

import java.util.ArrayList;

public class Elevator {

	private Passengers passengers;//Gente que sube y baja
	private boolean rising; //False si baja true si sube
	
	
	//Se pasa como parámetro la lista con las personas ordenadas por piso, primero se agregan las del piso uno, luego las del piso 2,...
	public Elevator(Passengers passengers)
	{
		rising = true; //  El ascensor empieza en el primer piso 
	}
		
	public ArrayList<Person> movements(int floorsNum)
	{
		ArrayList<Person> toOut = new ArrayList<Person>(); 
		if(rising)
		{
			for(int i = 1; i <= floorsNum; i++ )
			{
				toOut.add(passengers.dequeueMinPriority(i));
			}
			rising = false;
		}
		else {
			for(int i = floorsNum; i >= 1; i++ )
			{
				toOut.add(passengers.dequeueMaxPriority(i));
			}
		}
		return toOut;
	}

	public Passengers getPassengers() {
		return passengers;
	}

	
	 
	
}
