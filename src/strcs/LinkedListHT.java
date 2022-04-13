package strcs;

public class LinkedListHT<K,V> {

	private NodeHT<K,V> head;


	public LinkedListHT() {
		head = null;
	}

	public NodeHT<K,V> getHead() 
	{
	    return head;
	}
	
	public void add(NodeHT<K,V> newNode)
	{
		if (head == null)
		{
            head=newNode;
            
        }else{
            NodeHT<K,V> aux=head;
       
            while (aux.getNext()!=null) {
                aux=aux.getNext();
            }
    
            aux.setNext(newNode);
        }
		
	}
	
	public NodeHT<K, V> search(K key)
	{
        if(head != null)
        {
            if(head.getKey().equals(key))
            {
                return head;
            } else
            {
                return search(key, head.getNext());
            }
        } else{
        	
            return null;
        }
    }

    private NodeHT<K, V> search(K key, NodeHT<K, V> current)
    {
        if(current != null)
        {
            if(current.getKey().equals(key))
            {
                return current;
            } else{
                return search(key, current.getNext());
            }
        } else{
            return null;
        }
    }
}
