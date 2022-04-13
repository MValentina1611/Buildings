package strcs;

public class NodeHT<K,V> {

	private K key;
    private V value;

    private NodeHT<K, V> next;
    

    public NodeHT(K key, V value){
        this.key = key;
        this.value = value;
    }
    
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public void setNext(NodeHT<K, V> n){
        next = n;
    }
    
    public NodeHT<K, V> getNext(){
        return next;
    }

	
	
}
