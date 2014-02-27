import java.lang.*;
import java.util.*;


public class linkedLists{


//2.1	
	public Node removeDup( Node l){
    
        Node copy = l;
        //ListIterator<> iter = l.iterator(); 
		while(copy!=null){
			Node start = copy;
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

	public Node remDup(Node l ){
		Hashtable table = new Hashtable();
		Node n = l;
	 	Node previous = null;
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
	public int kth(Node l, int k){
		int length=0;
		Node copy = l;
		Node start = l;
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

    public int kthToLast(Node l, int k){
    	if(l==null){
    		return 0;
    	}
    	int i = kthToLast(l.next, k) + 1;
    	if(i==k){
    		System.out.print(l.data);
    	}
    	return i;
    }  

//2.3
	public void deleteThis(Node l){
		while(l!=null){
			l.data = l.next.data;
			if(l.next.next==null){
				l.next=null;
				break;
			}else{
				l=l.next;
			}
		}
	}    

//2.4
	public Node partition(Node n, int x){
		Node smaller = new Node(); 		
		Node larger = new Node();
		Node headOfSmaller = smaller;
		Node headOfLarger = larger;
		Node smallerTail = smaller;
		Node largerTail = larger;
		Node start = n;

		while(start!=null){
			if(start.data <=x ){
				smaller.data = start.data;
				smaller.next = new Node();
				smallerTail = smaller;
				smaller = smaller.next;
				start = start.next;
			}else{
				larger.data = start.data;
				larger.next = new Node();
				largerTail = larger;
				larger = larger.next;
				start = start.next; 
			}
		}

		smallerTail.next = headOfLarger;
		largerTail.next = null;
		return headOfSmaller;
	}

//2.5
	public Node sum(Node a, Node b){
		int carryIn = 0;
		Node aCopy = a;
		Node bCopy = b; 
		Node result = new Node(); 
		Node tail = result; 
		Node head = result;
		while(aCopy!= null && bCopy != null){
			//firstDigit =  (aCopy.data + bCopy.data+carryIn)%10;
			result.data =  (aCopy.data + bCopy.data+carryIn)%10;
			carryIn = (aCopy.data + bCopy.data+carryIn)/10;			
			tail = result; 
			result.next = new Node();
			result = result.next;
			aCopy = aCopy.next;
			bCopy=bCopy.next;
		}
		if(aCopy!=null){
			carryIn = (aCopy.data + carryIn)/10;
			result.data =  (aCopy.data + carryIn)%10;
			tail = result; 
			result.next = new Node();
			result = result.next;
			aCopy = aCopy.next;		
		}else if(bCopy!=null){
			carryIn = (bCopy.data+carryIn)/10;
			result.data =  (bCopy.data+carryIn)%10;
			tail = result; 
			result.next = new Node();
			result = result.next;
			bCopy=bCopy.next;
		}
		if(carryIn != 0){
			result.data = carryIn;
			tail = result;
		}else{
			tail.next = null;
			result = null;
		}

		return head;
	}


	public Node sumRecur(Node a, Node b, int carryIn){
		if(a == null && b == null && carryIn ==0){
			return null;
		}
		/*}else if(a == null && b!= null){
			Node result = new Node((b.data + carryIn)%10);
			carryIn = (b.data + carryIn)/10;
			return result.next =  sumRecur(null, b.next, carryIn);			
		}else if(a != null && b == null){
			Node result = new Node((a.data + carryIn)%10);
			carryIn = (a.data + carryIn)/10;
			return result.next =  sumRecur(a.next, null, carryIn);
		}else if(a!=null && b !=null){
			Node result = new Node((a.data + b.data + carryIn)%10);
			carryIn = (a.data + b.data + carryIn)/10;
			result.next =  sumRecur(a.next, b.next, carryIn);
		}	*/
		int result = carryIn;	
		Node resultNode  = new Node();		
		if(a!=null){
			result += a.data;
		}
		if(b!=null){
			result+= b.data;
		}

        resultNode.data = result%10;
        if(a!=null || b!=null){
        	carryIn = result/10;
        	resultNode.next = sumRecur( a!=null ? a.next : null,
        								b!=null ? b.next : null,
        								carryIn);
    	}

		return resultNode;
	}


//2.6
	public Node findLoop(Node head){
		Node slow = head;
		Node fast = head;

		while(fast.next != null && fast != null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast){
				break;
			}
		}

		if(fast == null || fast.next == null){
			return null;
		}

		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}


//2.7
	 public boolean isPalindrome(Node head){
	 	Node slow = head;
	 	Node fast = head;

	 	Stack<Integer> s = new Stack<Integer>();
	 	while(fast != null && fast.next != null){
	 		s.push(slow.data);
	 		slow = slow.next;
	 		fast = fast.next.next;
	 	}

	 	while(slow != null){
	 		slow = slow.next;
	 	}

	 	while(slow != null){
	 		int top = s.pop().intValue();
	 		if(top != slow.data){
	 			return false;
	 		}
	 		slow = slow.next;
	 	}

	 	return true;
	 }







	public static void main(String [ ] args){
		//LinkedList<Integer> list = new LinkedList<Integer>();

		linkedLists x = new linkedLists();

		Node n = new Node(10);

	    n.next = new Node(11);

		n.next.next = new Node(12);

		n.next.next.next = new Node(4);

		n.next.next.next.next = new Node(5);

		n.next.next.next.next.next = new Node(6);				

        //Node h = n.next.next.next;

        Node a;      
        Node b;
		a = new Node(5);
	    a.next = new Node(5);
		a.next.next = new Node(5);

		b = new Node(6);
	    b.next = new Node(6);
		b.next.next = new Node(6);		
		
		//x.kthToLast(n,2);
 		
 		//System.out.print(x.kthToLast(n,2)+"\n");
 		//x.deleteThis(h);
 		Node h = x.sumRecur(a,b,0);
		while(h!=null){
            System.out.print(h.data+ "->");
            h = h.next;
		}
        System.out.print("\n");		

	}


	public static class Node{
		int data;
		Node next;

		public Node(int d){
			data  = d;
		}

		public Node(){
		}

	}







}