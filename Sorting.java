import java.util.*;
public class Sorting{





/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
    
    // Merge two sorted arrays.
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void quickSort(int[] a, int left, int right){
		if(right > left ){
			int pivot = (left + right)/2;
			int newPivot = partition(a,left,right,pivot);
			quickSort(a, left, newPivot-1);
			quickSort(a, newPivot+1, right);
		}
	}


	public static int partition(int[] a, int left, int right, int pivot){
		int pivotValue = a[pivot];
		int holder;
		int storeIndex = left;
		a[pivot] = a[right];
		a[right] = pivotValue;
		for(int i=left; i<right; i++){
			if(a[i] <= pivotValue){
				holder = a[i];
				a[i] = a[storeIndex];
				a[storeIndex] = holder;
				storeIndex++; 
			}
		}
		holder = a[storeIndex];
		a[storeIndex] = a[right];
		a[right] = holder; 
		return storeIndex;
	} 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void selectionSort(int[] a){

		int length = a.length;
		int holder; 
		for(int j = 0; j < length; j++){
			for(int i = j; i < length; i++) {
				if( a[i] > a[j] ){
					holder = a[i];
					a[i] = a[j];
					a[j] = holder;
				}
			} 
		}
	}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void bubbleSort(int[] a) {
		int length = a.length;
		int holder;
		for (int i = 0; i < length; i++) { // already sorted
			for (int j = 0; j < length - i - 1; j++) { // walk through
				if (a[j] > a[j + 1]) {
					holder = a[j];
					a[j] = a[j + 1];
					a[j+1] = holder;					
				}
			}
		}

	}


	


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void main(String [] args){
		int[] a = {7,2,5,4,3,1,8,9,0,6};
		/*
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(new Integer(1));
		System.out.print(aList.get(0).intValue());
		*/


        int[] sorted_a = mergeSort(a);
        System.out.print(Arrays.toString(sorted_a));

        //quickSort(a,0,9);
        bubbleSort(a);
        System.out.print(Arrays.toString(a)); 

		




	}










}