package strcs;

public class NodeHT<K,V> {

	private K key;
    private V value;

    private NodeHT<K, V> next;
    private NodeHT<K, V> prev;

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
    public void setPrev(NodeHT<K, V> p){
        prev = p;
    }
    public NodeHT<K, V> getNext(){
        return next;
    }
    public NodeHT<K, V> getPrev(){
        return prev;
    }
	
	
}
