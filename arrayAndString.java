import java.util.HashSet;
import java.util.HashMap;
import java.lang.*;
import java.util.*;

public class arrayAndString{
	

	//1.1 Solution 
    public boolean uniqChar(String s){
    	int str_length = s.length();
        if(str_length > 256 ){     // using ASCII code
            return false;
        }
        else {
          for( int start = 0 ; start < str_length ; start ++ )
          	for( int trav = start +1  ; trav < str_length ;  trav ++)
           		if (s.charAt(start) == s.charAt(trav)){
                      return false;
           		}
          return true;
        }   
    }


    public boolean uniqCharHashSet(String s){
    	int str_length = s.length();
    	HashSet<Character> h_set = new HashSet<>();
        if(str_length > 256 ){     // using ASCII code
            return false;
        }
        else {
          for( int start = 0 ; start < str_length ; start ++ )
          	if (!h_set.contains(s.charAt(start))){
              h_set.add(s.charAt(start));
          	}else{
          		return false;
          	}
          return true;
        }   
    }


    public boolean uniqCharSet(String s){
    	int str_length = s.length();
        if(str_length > 256 ){     // using ASCII code
            return false;
        }else{
        	boolean[] set = new boolean[256];
        	int value;
        	for (int i=0; i<str_length; i++){
            	value = s.charAt(i);
                if(set[value]){
                	return false;
                }else{
                	set[value] = true;
                }
        	}
        	return true;
        }
    }
    


    //1.3 
/*    
    Alternative solution 

    public boolean permutOrNot(String a, String b){
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int a_length = a.length();
        int b_length = b.length();

        if(a_length != b_length){
        	return false;
        }

        for (int i=0; i<a_length; i++){
        	 if(count.containsKey(a.charAt(i))){
                count.put(a.charAt(i), count.get(a.charAt(i))+1);        
        	 }else{
        	 	count.put(a.charAt(i),1);
        	 }
        }


        for (int i=0; i<b_length; i++){
        	 if(count.containsKey(b.charAt(i))){
                count.put(b.charAt(i), count.get(b.charAt(i))-1);        
        	 }else{
        	 	return false;
        	 }
        }


        Iterator it = count.entrySet().iterator();
        while (it.hasNext()) {
        	Map.Entry pairs = (Map.Entry)it.next();
        	if(pairs.getValue()!=0){
        		return false;
        	}
        	it.remove(); 
        }
        return true;
    }
*/


    public String sort(String s){
     	char[] content = s.toCharArray();
        Arrays.sort(content);
    	return new String(content);
    }

    public boolean permutation(String s, String t){
        if(s.length()!=t.length()){
        	return false;
        }
        return sort(s).equals(sort(t));
    }    


//1.4 

    public char[] replace(char[] s, int t){
    	int space_count = 0;
        for(int i=0; i<s.length; i++){
        	if(s[i]== ' '){
        		space_count++;
        	}
        }
 		int pos = t + space_count*2 -1;
 		for(int j=t-1; j>0; j--){
 			if(s[j] == ' '){
               s[pos] = '0';
               s[--pos] = '2';
               s[--pos] = '%'; 
               pos--;
 			}else{
 				s[pos] = s[j];
 				pos--;
 			}
 		}
 		return s; 
    }
    

    

//1.5

    public String compress(String s){

        if(s==null){
        	return s;                                            //s is null
        }

    	int length = s.length();                                 //s is short
    	if(length ==0 || length == 1 ||length == 2){
        	return s;
        }

    	StringBuffer copy = new StringBuffer();                  //s is longer and the compressed string could be shorter than s
    	int counter = 1;
    	char holder = s.charAt(0);
    	copy.append(s.charAt(0));

        for(int i=1; i<length; i++){                
        	if(s.charAt(i) == holder){
        		counter++;
        	}else{
        		copy.append(counter);
        		holder = s.charAt(i);
        		copy.append(holder);
        		counter =1;
        	}
        }

        copy.append(counter);
        String val = copy.toString();
        if(val.length() >= length){
        	return s;
        }
        return val;
    }


//1.6 
    public void rotate(int[][] m, int n){
    	printGrid(m);
        int num = n/2; 
        int swap, swap1,swap2,swap3;

    	for(int layer=0; layer < num; layer++){

            int bound = n-layer-1;

    		for(int index =layer, indexp = 0; index<bound; index++, indexp++ ){

                //top to right
           		swap = m[index][bound];
            	m[index][bound] = m[layer][index];

 				//right to bottom
            	swap1 = m[bound][bound-indexp];
            	m[bound][bound-indexp] = swap;

            	//bottom to left
            	swap2 = m[bound-indexp][layer];
            	m[bound-indexp][layer] = swap1;

            	//left to top
                m[layer][index] = swap2; 
			}

    	}
    	printGrid(m);

    }

//1.7 

    public void setZero(int[][] m){
    	printGrid(m);
    	boolean[] row = new boolean[m.length];
    	boolean[] column = new boolean[m[0].length];
   		for(int i = 0; i < m.length; i++){
      		for(int j = 0; j < m[0].length; j++){
         		if (m[i][j]==0){
                	row[i] = true;
                	column[j] = true;                    	
         		}
      		}
   		} 
        for(int c=0; c<column.length; c++){
            if(column[c]){
                for(int i=0; i<m.length ; i++){
                   m[i][c] = 0;
                }
            }
        }

        for(int r=0; r<row.length; r++){
           	if(row[r]){
                for(int i=0; i<m[0].length; i++){
                	m[r][i] = 0;
                }
           	}
        }        

   		printGrid(m);

    }


//1.8 
    public boolean isStringRotation(String s1, String s2){
         String s = s1 + s1;
         return isSubString(s,s2);
    }























 	public void printGrid(int[][] a){

   		for(int i = 0; i < a.length; i++){
      		for(int j = 0; j < a[0].length; j++){
         		System.out.printf("%d ", a[i][j]);
      		}
      		System.out.println();
   		}
    }











public static void main(String [ ] args){
    String s = "aaa";
    String s1 ="aaaabaabd";
    char[] s2 = new char[10];
    s2[0] = '1';
    s2[1] = ' ';
    s2[2] = ' ';
    s2[3] = '1';
    s2[4] = '1';
    s2[5] = '1';

    int[][] a = new int[4][4];
    a[0][0] = 90;
    a[0][1] = 91;
    a[0][2] = 92;
    a[0][3] = 93;
    a[1][0] = 10;
    a[1][1] = 0;
    a[1][2] = 12;
    a[1][3] = 13;
    a[2][0] = 20;
    a[2][1] = 21;
    a[2][2] = 0;
    a[2][3] = 23;
    a[3][0] = 30;
    a[3][1] = 31;
    a[3][2] = 32;
    a[3][3] = 33;
    


    arrayAndString x = new arrayAndString(); 
    if(x.uniqCharSet(s)){
        System.out.print( "All unique Chars. \n");

    }else{
    	System.out.print( "There is repeated Char. \n");
    }


    if (x.permutation(s, s1)){
 		System.out.print("nima. \n");
    }else{
        System.out.print("nimabudui.\n");
    }

    String b = Arrays.toString(x.replace(s2,6));
    System.out.print(b+"\n");

 	System.out.print(x.compress(s)+"\n");

   
    //x.rotate(a,4);
    x.setZero(a);




}


}
