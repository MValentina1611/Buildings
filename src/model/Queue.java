package model;

public class Queue<E> {
	
    private Node<E> head;
    private Node<E> tale;
    private int size;
    //No debe estar protected 
    //intentar un atributo passengers
    
    public Queue() {
        head = null; 
        tale = null;
        this.size = 0;
    }

    public boolean isEmpty() {
    boolean empty = false;
    	if(head == null)
    	{
    		empty = true;
    	}
        return empty;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(E e) 
    {
        Node<E> node = new Node<E>(e);

        if (isEmpty())
        {
            head = node;
        }
        else
        {
          tale.setNext(node);
        }
            tale = node;
            System.out.println(tale.getItem().toString());
            size++;
     }

     public Node<E> dequeue()
     {
    	 Node<E> aux = head;
    	 head = head.getNext();
    	 
    	 size--;

    	 return aux;
     }


    public Node<E> getHead() {
        return head;
    }
    
    public Node<E> getTale() {
        return tale;
    }
}