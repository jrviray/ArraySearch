package proj2;

public class Select_kth_Three {
	
	// swap the places of two values in an array
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// recursive, partition until k becomes pivot
	public int recursiveQS(int[] array, int low, int high, int k) {
		if (k > 0 && k <= high - low + 1) {
			// initially set k
			int pos = this.partition(array, low, high);
			// return if k is found
			if (pos - low == k - 1) {
				return array[pos];
			}
			// if k is greater than pivot, recursion
			if (pos - low > k - 1) {
				return this.recursiveQS(array, low, pos - 1, k);
			}
			// if k is less than pivot, recursion
			return this.recursiveQS(array, pos + 1, high, k - pos + low - 1);
		}
		// if k is never found
		return -1;
	}

	// moves values that are either greater than the pivot to its left, less than the pivot to its right
	public int partition(int[] array, int low, int high) {
		int pivot = array[high], i = low;
		for (int j = low; j <= high - 1; j++) {
			// move to right, high end
			if (array[j] <= pivot) {
				this.swap(array, i, j);
				i++;
			}
		}
		// move to left, low end
		this.swap(array, i, high);
		return i;
	}

	public void test(int size, int k){
		Array array = new Array(size);
		array.generateElements(array.getArray());
		this.recursiveQS(array.getArray(), 0, array.getArray().length - 1, k);
	}
}
