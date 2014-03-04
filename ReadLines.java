import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLines{
	

   public static void read( ){

         int sum = 0; 
         try (BufferedReader eachLine = new BufferedReader(new FileReader("try.txt"))){ 
               String current;
         		while ((current = eachLine.readLine()) != null){
         			sum+=Integer.parseInt(current);
         		}  

         }catch(IOException e){
         		e.printStackTrace();
         }

         System.out.print(sum + "\n");
   }

   public static void main(String [] args){
      read();
   }

}