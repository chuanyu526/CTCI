import java.util.*;

public class stackAndQueue{


//3.5//////////////////////////////////////////////////////////////////////////////////////////////





    public static int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<String>();
        s.push(tokens[tokens.length-1]);
        boolean isTopNum = false;
        for(int i=tokens.length-1; i>=0; i--){
            if(tokens[i].equals("/") || tokens[i].equals("+") || tokens[i].equals("-")  || tokens[i].equals("*") ){
                s.push(tokens[i]);
                isTopNum = false;
            }else{
                if(isTopNum){
                    String second = s.pop(); 
                    String op = s.pop();
                    String first = tokens[i];
                    s.push("" + calculate(first, second, op));
                }else{
                    s.push(tokens[i]);
                }
                isTopNum = true;
            }   
        }
        return Integer.parseInt(s.pop());
        
    }
    
    static int calculate(String a, String b, String op){
        if(op.equals("/")){
            return  Integer.parseInt(a) / Integer.parseInt(b);
        }
        
        else if(op.equals("+")){
            return Integer.parseInt(a) + Integer.parseInt(b);
        }
        
        else if(op.equals("-")){
            return Integer.parseInt(a) - Integer.parseInt(b);
        }

        else{
            return Integer.parseInt(a) * Integer.parseInt(b);
        }
        
        
    }
    































	public static void main(String [] args){
      String[] a = {"0", "3", "/"};
      System.out.print(evalRPN(a));

 		//System.out.print("HI");
	}















}