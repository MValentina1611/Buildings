package strcs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Person;

class QueueTest {

	private Queue<Person> queueForTest;
	
	public void setUpScenary1()
	{
		queueForTest = new Queue<Person>();
	}
	
	public void setUpScenary2()
	{
		queueForTest = new Queue<Person>();
		queueForTest.enqueue(new Person("Daniel",2,2,false,3));
	}
	
	public void setUpScenary3()
	{
		queueForTest = new Queue<Person>();
		queueForTest.enqueue(new Person("Daniel",2,2,false,3));
		queueForTest.enqueue(new Person("Camilo",2,3,false,2));
	}
//-----------------------------------------------------	
	@Test
	public void testEnqueue1()
	{
	
		setUpScenary1();
		String name = "Daniel";
		int currentFloor = 2;
		int desiredOffice = 2;
		boolean isInOffice = false;
		int futureFloor = 1;
		queueForTest.enqueue(new Person(name,currentFloor,desiredOffice,isInOffice,futureFloor));
		Person personExpected = new Person(name,currentFloor,desiredOffice,isInOffice,futureFloor);
		
		assertEquals(personExpected.toString(), queueForTest.getHead().getItem().toString());
	}
	
	@Test
	public void testEnqueue2() 
	{
		setUpScenary2();
		String name = "Camilo";
		int currentFloor = 2;
		int desiredOffice = 3;
		boolean isInOffice = false;
		int futureFloor = 2;
		
		queueForTest.enqueue(new Person(name,currentFloor,desiredOffice,isInOffice,futureFloor));
		Person personExpected = new Person(name,currentFloor,desiredOffice,isInOffice,futureFloor);
		assertEquals(personExpected.toString(), queueForTest.getTail().toString());
	}
	
	@Test
	public void testDequeue1()
	{
		setUpScenary3();
		Person personToDequeue = queueForTest.dequeue().getItem();
		Person personExpected =new Person("Daniel",2,2,false,3);
		
		assertEquals(personExpected.toString(), personToDequeue.toString());
		
	}
	
	@Test
	public void testDequeue2()
	{
		setUpScenary1();
		Node<Person> personToDequeue = queueForTest.dequeue();
		
		assertEquals(null, personToDequeue);
	}
	
	@Test
	public void testDequeue3()
	{
		setUpScenary2();
		queueForTest.dequeue();
		
		assertEquals(null, queueForTest.getHead());
	}
	
	@Test
	public void testIsEmpty1()
	{
		setUpScenary1();
		boolean isEmpty = queueForTest.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void testIsEmpty2()
	{
		setUpScenary2();
		boolean isEmpty = queueForTest.isEmpty();
		
		assertFalse(isEmpty);
	}
	
	@Test
	public void testGetHead1()
	{
		setUpScenary1();
		Node<Person> personToGet = queueForTest.getHead();
		
		assertEquals(null, personToGet);
	}
	
	@Test
	public void testGetHead2()
	{
		setUpScenary2();
		Node<Person> personToGet = queueForTest.getHead();
		Node <Person> personExpected = new Node<Person>(new Person("Daniel",2,2,false,3));
		
		assertEquals(personExpected.toString(), personToGet.toString());
	}
	
	@Test
	public void testGetHead3()
	{
		setUpScenary3();
		Node<Person> personToGet = queueForTest.getHead();
		Node <Person> personExpected = new Node<Person>(new Person("Daniel",2,2,false,3));
		
		assertEquals(personExpected.toString(), personToGet.toString());
	}
	
	@Test
	public void testGetTail1()
	{
		setUpScenary1();
		Node<Person> personToGet = queueForTest.getTail();
		
		assertEquals(null, personToGet);
	}
	
	@Test
	public void testGetTail2()
	{
		setUpScenary2();
		Node<Person> personToGet = queueForTest.getTail();
		Node <Person> personExpected = new Node<Person>(new Person("Daniel",2,2,false,3));
		
		assertEquals(personExpected.toString(), personToGet.toString());
	}
	
	@Test
	public void testGetTail3()
	{
		setUpScenary3();
		Node<Person> personToGet = queueForTest.getTail();
		Node <Person> personExpected = new Node<Person>(new Person("Camilo",2,3,false,2));
		
		assertEquals(personExpected.toString(), personToGet.toString());
	}
}
