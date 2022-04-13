package strcs;

public class HashTable<K,V> {

	private final int MAX_SIZE = 23;
	private LinkedListHT<K,V>[] table;

	//The collisions will be fixed by separate-chaining 
	
	@SuppressWarnings("unchecked")
	public HashTable()
	{
		table = (LinkedListHT<K, V>[]) new LinkedListHT<?,?>[MAX_SIZE];
	}

	public Integer hash(K k)
	{
		Integer keyToHash = k.hashCode();
		Integer key = 0;
		key = keyToHash%MAX_SIZE;

		return key;
	}

	public void put(K key, V value) 
	{
		Integer hash = hash(key);
		NodeHT<K,V> toPut = new NodeHT<>(key, value);
		
		if(table[hash] != null)
		{
			table[hash].add(toPut);
		} else{
			LinkedListHT<K, V> llToChaining = new LinkedListHT<>();
			table[hash] = llToChaining;
			table[hash].add(toPut);
		}
	}

	public V get(K k)
	{
		int hash = hash(k);
		NodeHT<K, V> toGet = table[hash].search(k);

		if(toGet != null){
			return toGet.getValue();
		} else{
			return null;
		}
	}	 
	
	
	
	
}
