package ui;

import java.util.ArrayList;
import java.util.Scanner;



import model.Buildings;
import model.Person;

public class Main {
	
	
    private Scanner sc;
    //private boolean exit;
    private Buildings buildings;
    private String msg2Print = "";
    private int floorsNum;
    private ArrayList<Person> peopleBuilding;
    
    public Main() {
        this.sc = new Scanner(System.in);
       // this.exit = false;
        this.peopleBuilding = new ArrayList<Person>();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() 
    {
        System.out.println("\n");
        System.out.println("Please select an option\n(1)Create buildings\n(0)Exit\n");
        
        int option = this.sc.nextInt();
        
        if (option != 0) 
        {
            this.sc.nextLine();
            System.out.println("Please create the building");
            int building_num = this.sc.nextInt();
            this.sc.nextLine();

            for(int i = 0; i < building_num; ++i)
            {
                this.buildingCreation();
            }

            System.out.println(this.msg2Print);
            System.out.println("Enter (2) to check offices");
            option = this.sc.nextInt();
            if(option == 2)
            {
            	this.checkOffices();
            }
            
        } else {
            System.out.println("Goodbye\n");
        }

    }

    public void buildingCreation() {
        String entry = this.sc.nextLine();
        String[] arrOfStr = entry.split(" ", 4);
        String name = arrOfStr[0];
        int peopleQt = Integer.parseInt(arrOfStr[1]);
        int floors_num = Integer.parseInt(arrOfStr[2]);
        floorsNum = floors_num;
        int offices_num = Integer.parseInt(arrOfStr[3]);
        this.buildings = new Buildings(name, offices_num);
        this.buildings.createBuilding(floors_num, (double)offices_num);
        this.peopleCreation(peopleQt);
        this.buildings.setFloors_num(floors_num);
    }

    public void peopleCreation(int peopleQt) {
        ArrayList<Person> peopleInBuilding = new ArrayList<Person>();
        ArrayList<Person> peopleInBuildingPerFloor = new ArrayList<Person>();
        double floor= buildings.getBuildingHm().get(1);

        for(int i = 0; i < peopleQt; ++i) {
            String entry = this.sc.nextLine();
            String[] arrOfStr = entry.split(" ", 3);
            String name = arrOfStr[0];
            int currentFloor = Integer.parseInt(arrOfStr[1]);
            int desiredOffice = Integer.parseInt(arrOfStr[2]);
            Person person = new Person(name, currentFloor, desiredOffice, false);
            Person person2 = new Person(name, currentFloor, desiredOffice, false, realFutureFloor(buildings.which_Floor(person.desiredOffice)));
            peopleInBuilding.add(person);
            peopleInBuildingPerFloor.add(person2);
            peopleBuilding.add(person2);
        }

        this.buildings.sortToOffices(peopleInBuildingPerFloor);
        this.buildings.createElevator(peopleInBuildingPerFloor);
        //printArrayList(this.buildings.getElevator().movements());
        this.msg(this.buildings.getElevator().movements());
    }

    public int realFutureFloor(int futureFloor)
    {
    	int real = floorsNum -(futureFloor-1); 
    	return real;
    }
    
    public void printArrayList(ArrayList<Person> toPrint)
    {
    	System.out.println(toPrint.size());
    	for(int i = 0; i < toPrint.size(); i ++)
    	{
    		System.out.println(toPrint.get(i));
    	}
    }
    
    public void checkOffices()
    {
    	this.buildings.sortOfficesToCheck(this.peopleBuilding);
    	for(int i = 1; i <= this.buildings.getOfficesTotal(); i++)
    	{
    		System.out.println(this.buildings.getBuildingOfficesHm().get(i).toString());
    	}
    }
    
    public void msg(ArrayList<Person> personArrayList) 
    {
        this.msg2Print = this.msg2Print + "Movimientos del edificio " + this.buildings.getBuildingName() + "\n\n";

        int i;
        for(i = 0; i < personArrayList.size(); ++i) {
            if (((Person)personArrayList.get(i)).isOnOffice) {
                this.msg2Print = this.msg2Print + ((Person)personArrayList.get(i)).getName() + " se mueve a la oficina " + ((Person)personArrayList.get(i)).getDesiredOffice() + "\n";
            } else {
                this.msg2Print = this.msg2Print + ((Person)personArrayList.get(i)).getName() + " no puede ser incluido en las oficinas del edificio\n";
            }
        }

        this.msg2Print = this.msg2Print + "\n\nEstado final de las oficinas en el edificio " + this.buildings.getBuildingName() + "\n\n" + "[";

        for(i = 0; i < personArrayList.size(); ++i) {
            if (i != 0) {
                if (((Person)personArrayList.get(i)).isOnOffice) {
                    this.msg2Print = this.msg2Print + "," + ((Person)personArrayList.get(i)).getName();
                }
            } else if (((Person)personArrayList.get(i)).isOnOffice) {
                this.msg2Print = this.msg2Print + ((Person)personArrayList.get(i)).getName();
            }
        }

        this.msg2Print = this.msg2Print + "]\n\n";
    }
}