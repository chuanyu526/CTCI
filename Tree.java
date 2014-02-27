import java.util.*;
public class Tree{

	private Node root;
	public void addNode(int data){

		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
		}else{
			Node focusNode = root; 
			Node parent;
			while(true){
				parent = focusNode; 
				if(data<focusNode.data){
					focusNode = focusNode.leftChild;
					if(focusNode == null){
						parent.leftChild = newNode;	
						return;
					}

				}else{
					focusNode = focusNode.rightChild;
					if(focusNode == null){
						parent.rightChild = newNode;	
						return;
				    }
				}
			}
		}
	}
	



	public static void inOrder(Node root){
		if(root != null){
			inOrder(root.leftChild);
			System.out.print(root.data);
			inOrder(root.rightChild);
		}

	}



	public static void preOrder(Node root){

        if(root != null){
			System.out.print(root.data);
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}

	}


	public static void postOrder(Node root){
		if(root != null){
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print(root.data);
		}

	}



	public Node root(){
		return root;
	}




	public static void iterativeInOrder(Node root){

		Stack<Node> s = new Stack<Node>();
		Node r = root;

		while(!s.empty() || r != null){
			
			if(r != null){
				s.push(r);
				r = r.leftChild;
			}else{
 				r = (Node)s.pop();
        		System.out.print(r.data);
        		r = r.rightChild;
			}			
		}
	}



	public static void iterativePreOrder(Node root){

		Stack<Node> s = new Stack<Node>();
		Node r = root; 
		s.push(null);

		while(r != null ){	
			System.out.print(r.data);
			if(r.rightChild != null){
				s.push(r.rightChild);
			}
			if(r.leftChild != null){
				s.push(r.leftChild);
			}
			r = s.pop();
		}

	}


	public static void iterativePostOrder(Node root){

		Stack<Node> s = new Stack<Node>();
		Node r = root;
		Node last_visited = null;  
		Node peek;

		while(!s.empty()|| r != null){
			if( r != null ){
				s.push(r);
				r = r.leftChild;
			}else{
				peek = s.peek();
				if(peek.rightChild != null && last_visited != peek.rightChild){
					r = peek.rightChild;
				}else{
					s.pop();
					System.out.print(peek.data);
					last_visited = peek; 
				}
			}
		}
	}




    public static void levelOrder(Node root){
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	while(q.size() != 0 ){
    		Node n = q.poll();
    		System.out.print(n.data);
    		if( n.leftChild != null ){
    			q.add(n.leftChild);
    		}
    		if( n.rightChild != null ){
    			q.add(n.rightChild);
    		}
    	}
    }

	



class Node {

    int data;
    Node leftChild;
    Node rightChild;
    Node(int data){   
        this.data = data;
    }


    public String toString() {
        return "=" + data; 
    }
}





public static void main(String [] args){

	Tree t = new Tree();
	t.addNode(6);
	t.addNode(4);
	t.addNode(5);
 	t.addNode(3);
	t.addNode(8);
	t.addNode(7);
	t.addNode(9);
	

	inOrder(t.root());
    System.out.print("\n");	
	iterativeInOrder(t.root());
    System.out.print("\n");
	preOrder(t.root());
	System.out.print("\n");
	iterativePreOrder(t.root());
	System.out.print("\n");
	postOrder(t.root());
	System.out.print("\n");
	iterativePostOrder(t.root());
	System.out.print("\n");
	levelOrder( t.root());
	System.out.print("\n");

}













}