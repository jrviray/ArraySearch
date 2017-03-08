package proj2;

import java.util.Random;

public class Array {
	
	private int[] array;
	
	Array(int size){
		setArray(new int[size]);
	}
	
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}
	
	public void generateElements(int[] array){
		Random rand = new Random();
		for(int i = 0; i < array.length; i++){
			array[i] = rand.nextInt(99) + 1;
		}
		
	}
	
	public void print(int[] array){
		System.out.print("[");
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + ", ");
		}
		System.out.print("]");
		System.out.println();
	}
	

}
