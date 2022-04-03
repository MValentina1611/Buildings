package model;

public class Queue<E>{

	protected Node<E> head;
    protected Node<E> tale;
    protected int size;
    
    public Queue()
    {
    	head = tale = null;
    	size=0;
    }
    
    public boolean isEmpty() 
    {
        return (head == null) ? true : false;
    }
	
    public int size() {
        return size;
    }
    
    public void enqueue(E e) 
    {
        Node<E> node = new Node<E>(e);
        
        if (isEmpty())
        {
            head=node;
        }
        else
        {
          tale.setNext(node);
        }
            tale = node;
            size++;
     }
    
     public E dequeue()
     {
    	 E aux = head.getItem();
    	 head = head.getNext();
    	 size--;
    	 
    	 return aux;
     }
        
     public E getHead()
     {
    	 if(isEmpty())
    	 {
    		 return null;
    	 }else
    	 {
    		 return head.getItem();
    	 }
     }
     
 }
