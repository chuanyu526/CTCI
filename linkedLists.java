import java.lang.*;
import java.util.*;


public class linkedLists{


//2.1	
	public node removeDup( node l){
    
        node copy = l;
        //ListIterator<> iter = l.iterator(); 
		while(copy!=null){
			node start = copy;
			while(start.next!=null){
				if(copy.data == start.next.data){
					start.next = start.next.next;
				}else{
					start = start.next;
				}
			}
			copy = copy.next;
		} 
		return l;
	}

	public node remDup(node l ){
		Hashtable table = new Hashtable();
		node n = l;
	 	node previous = null;
	 	while(n!=null){
	 		if(table.containsKey(n.data)){
	 			previous.next = n.next;
	 		}else{
	 			table.put(n.data, true);
	 			previous = n;
	 		}
	 		n = n.next; 
	 	}
        return l;
	}
    

//2.2
	public int kth(node l, int k){
		int length=0;
		node copy = l;
		node start = l;
		while(copy!=null){
			length++;
			copy=copy.next;
		}
		System.out.print(length+"\n");
		if( k > length){
			return -1;
		}
		for(int i=0; i<length ;i++){
			if(i==length-k){
				return start.data; 
			}
		    start = start.next;
		}
		return -1;
	}

//2.3 
	    









	public static void main(String [ ] args){
		//LinkedList<Integer> list = new LinkedList<Integer>();

		linkedLists x = new linkedLists();

		node n = new node(1);

	    n.next = new node(2);

		n.next.next = new node(3);

		n.next.next.next = new node(4);

		n.next.next.next.next = new node(5);

		n.next.next.next.next.next = new node(6);				



		

 		
 		System.out.print(x.kth(n,2)+"\n");
 		/*
		while(start!=null){
            System.out.print(start.data);
            start = start.next;
		}
        System.out.print("\n");		
*/



	}


	public static class node{
		int data;
		node next;

		public node(int d){
			data  = d;
		}

	}







}