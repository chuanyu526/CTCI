import java.util.*;

public class stackAndQueue{


//3.5//////////////////////////////////////////////////////////////////////////////////////////////




	//Assume all inputs are valid 
    public int evalRPN(String[] tokens) {
 
        int returnValue = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        } 
        returnValue = Integer.valueOf(stack.pop());
        return returnValue; 
    }
    































	public static void main(String [] args){
      String[] a = {"0", "3", "/"};
      String[] b = {"2","1","+","3","*"};
      System.out.print(evalRPN(a));
      System.out.print(evalRPN(b));

 		//System.out.print("HI");
	}















}