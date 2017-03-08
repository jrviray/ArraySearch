package proj2;

import java.util.Arrays;

public class Select_kth_One {
	
	//use merge sort, has worst case of nlogn
	public void mergeSort(int[] array){
	int[] temp = new int[array.length];	
	this.split(array, temp, 0, array.length - 1);
	}
	
	// split the array 
	public void split(int[] array, int[] temp,int low, int high){
		if (low < high){
			int middle = low + (high-low)/2;
			// sort left
			split(array, temp, low, middle);
			// sort right
			split(array, temp, middle + 1, high);
			doMergeSort(array, temp, low, middle,high);
		}
	}
	
	// perform merge sort
	public void doMergeSort(int[] array, int[] temp, int low, int middle, int high){
		for (int i = low; i <= high; i++){
			temp[i]	= array[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high){
			if(temp[i] <= temp[j]){
				array[k] = temp[i];
				i++;
			}
			else{
				array[k] = temp[j];
				j++;
			}
			k++;
		}
		while (i <= middle){
			array[k] = temp[i];
			k++;
			i++;
		}
	}
	
	public void test(int size,int k){
		Array array = new Array(size);
		array.generateElements(array.getArray());
		this.mergeSort(array.getArray());
		Arrays.binarySearch(array.getArray(), k);
	}

}
