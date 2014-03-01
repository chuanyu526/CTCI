import java.util.*;
public class Sorting{







	public static int[] mergeSort( int [] a){
		int l = a.length; 
		if(l>1){

			return merge(mergeSort(leftHalf(a)), mergeSort(rightHalf(a)));
		}else{
			return a;
		}
	}


    
    // Returns the first half of the given array.
    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    


/*
	protected void merge(int [] x, int [] y ){ 
		if (x.length == 0){
			return y;
		}
		if(y.length == 0){
			return x;
		}
		if(x[0]>=y[0]){
			int l = x.length + y.length;
		    int[] a = new int[l]; 
		    a[0] = x[0];
			for(int i =0; i<l; i++){
				a[]
			}
		}

	}
*/



	protected static int[] merge(int [] x, int [] y ){ 
		int x_pos =0;
		int y_pos =0; 
		int[] comb = new int[x.length + y.length];
		for(int i=0; i<x.length + y.length; i++){
			
			if(x_pos<x.length && y_pos<y.length){
				if(x[x_pos] >= y[y_pos]){
					comb[i] = y[y_pos];
					y_pos++;
				}else{
					comb[i] = x[x_pos];
					x_pos++; 
				}
			}else{
				if(x_pos>=x.length && y_pos<y.length){
					comb[i] = y[y_pos];
					y_pos++;
				}else if(x_pos<x.length && y_pos>=y.length){
					comb[i] = x[x_pos];
					x_pos++;
				}
			}

		}
		return comb; 
	}

















	public static void main(String [] args){
		int[] a = {7,2,5,4,3,1,8,9,0,6};
		/*
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(new Integer(1));
		System.out.print(aList.get(0).intValue());
		*/


        int[] sorted_a = mergeSort(a);
        System.out.print(Arrays.toString(sorted_a));
		




	}










}