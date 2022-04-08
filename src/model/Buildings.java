package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Buildings {
    public String buildingName;
    private double officesTotal;
    private double officesPerFloor;
    public HashMap<Integer, Double> buildingHm;
    private Elevator elevator;
    public int floors_num;

    public Buildings(String buildingName, int offices_num) {
        this.buildingName = buildingName;
    }

    public void createBuilding(int floors_num, double offices_num) {
        this.buildingHm = new HashMap();

        for(int i = 1; i <= floors_num; ++i) {
            this.buildingHm.put(i, offices_num);
        }

        this.officesTotal = (double)floors_num * offices_num;
        this.officesPerFloor = offices_num;
    }

    public void sortToOffices(ArrayList<Person> personArrayList) {

        for(int i = 0; i < personArrayList.size(); ++i) {
            int floor2Go = this.which_Floor((double)((Person)personArrayList.get(i)).getDesiredOffice());
            System.out.println(personArrayList.get(i));
            System.out.println(floor2Go);
            if (floor2Go != 0 && (Double)this.buildingHm.get(floor2Go) != 0.0D) {
                ((Person)personArrayList.get(i)).setOnOffice(true);
                this.buildingHm.put(floor2Go, (Double)this.buildingHm.get(floor2Go) - 1.0D);
            }
        }

    }

    public int which_Floor(double desiredOffice) {
        if (desiredOffice <= this.officesTotal && desiredOffice > 0.0D) {
            double floor = desiredOffice / this.officesPerFloor;
            int whole = (int)floor;
            //System.out.println(whole);
            double decimal = floor - (double)whole;
            if (decimal >= 0.1D && decimal <= 0.9D) {
                ++whole;
            }

            return whole;
        } else {
            return 0;
        }
    }

    public String getBuildingName() {
        return this.buildingName;
    }

    public void createElevator(ArrayList<Person> personArrayList) {
    	System.out.println("Sin ordenar");
    	printArrayList(personArrayList);
    	System.out.println("Ordenado");
        Collections.sort(personArrayList);
        printArrayList(personArrayList);
        System.out.println("----------------------------");
        
        Passengers passengers = new Passengers(personArrayList);
        System.out.println("Se Crea el passengers");
        //printQueue(passengers);
        this.elevator = new Elevator(passengers);
        System.out.println("Creo elevator");
    }

    public void printArrayList(ArrayList<Person> toPrint)
    {
    	for(int i = 0; i < toPrint.size(); i ++)
    	{
    		System.out.println(toPrint.get(i));
    	}
    }
    
    /*
    public void printQueue(Passengers passengers)
    {
    	for(int i =0; i < passengers.size(); i++)
    	{
    		System.out.println(passengers.dequeue());
    	}
    }
    */
    
    public Elevator getElevator() {
        return this.elevator;
    }

    public void setFloors_num(int floors_num) {
        this.floors_num = floors_num;
    }

    public HashMap<Integer, Double> getBuildingHm() {
        return buildingHm;
    }
}