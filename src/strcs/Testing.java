package strcs;

public class Testing {

	public static void main(String[] args) {
		
		
		HashTable<Integer, String> toTest = new HashTable<>();
		
		toTest.put(1, "uno");
		toTest.put(2, "dos");
		toTest.put(3, "tres");
		
		
		for(int i = 1; i <= 3; i++ )
		{
			System.out.println("Value of "+i+": "+toTest.get(i));
		}
		
		
		
		
	}
	
	
}
