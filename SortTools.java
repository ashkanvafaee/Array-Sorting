// SortTools.java 
/*
 * EE422C Project 1 submission by
 * 2/1/16
 * Ashkan Vafaee
 * av28837	
 * 16238
 * Spring 2017
 * Slip days used: 0
 */

package assignment1;
public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		if(x.length == 0 || n == 0){
			return(false);
		}
		
		if(n==1){
			return true;
		}
		
		for(int i=0; i<(n-1); i++){
			if(x[i+1]<x[i]){
				return false;
			}
		}
		return true;	
	}
	
	/**
	  * This method finds the index of a given variable in x.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @param v is the value to be checked for
	  * @return index of v if v is in the first n elements of x otherwise -1
	  */
	
	public static int find(int [] x, int n, int v){
		if(n==1 || n==2){
			if(x[0]==v){
				return(0);
			}
			else if(x[1]==v){
				return(1);
			}
			else{
				return(-1);
			}
		}
		
		int avg;
		int i = n/2;
		int prev = n;																//previous value
		for(;n>0 && (i!=0 || i!=n);n=n/2){											//O(log n)
			if(v>x[i]){
				avg = i-prev> 0 ? (i-prev)/2 : (prev-i)/2;
				avg = avg==0?1:avg;
				prev=i;
				i=i+avg;
			}
			else if(v<x[i]){
				avg = i-prev> 0 ? (i-prev)/2 : (prev-i)/2;
				avg = avg==0?1:avg;
				prev=i;
				i=i-avg;
			}
			else{return(i);}
		}
		
		return(-1);
		
	}
	
	/**
	  * This method inserts a variable in a newly created array in non decreasing order.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @param v is the value to be inserted
	  * @return returns newly created array with insertion of variable v if v was not found in x otherwise x with first n elements
	  */
	
	public static int[] insertGeneral(int[] x, int n, int v){
		for(int i=0;i<n;i++){
			if(x[i]==v){
				int [] array = new int[n];
				for(int j=0;j<n;j++){
					array[j]=x[j];
				}
				return(array);
			}
			if(x[i]>v || i==n-1){
				int [] array = new int[n+1];
				boolean flag = false;
				for(int j=0,k=0;k<n+1;j++, k++){
					if((x[j]>v || k==n) && flag==false){
						array[j]=v;
						if(k==n){
							return array;
						}
						k++;
						flag=true;

					}
					array[k]=x[j];
				}
				return(array);
			}
		}
		return(x);
		
	}
	/**
	  * This method inserts a value in a given array in non decreasing order.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @param v value to be inserted
	  * @return n if v was found in the first n elements of x otherwise n+1
	  */
	public static int insertInPlace(int[] x, int n, int v){
		
		for(int i=0; i<n; i++){
			if(x[i]==v){
				return(n);
			}
		}
		
		int i=0;
		while(x[i]<=v){i++;}									//Cycle until insertion location
		
		int swap;
		for(;i<n+1; i++){
				swap = x[i];
				x[i]=v;
				v=swap;
		}
		
		return(n+1);
		
		
	}

	/**
	  * This method sorts the first n elements of an array in non decreasing order.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return nothing
	  */
	public static void insertSort(int[] x, int n){		//O(n) if almost sorted; o(n^2) otherwise
		int swap;
		
		for(int i=0;i<n; i++){
			for(int j=0; j<n-1; j++){
				if(x[j]>x[j+1]){
					swap = x[j];
					x[j]=x[j+1];
					x[j+1]=swap;
				}
			}
			
		}
		
	}
	
	
	
}
