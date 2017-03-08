package proj2;

import java.util.Stack;

public class Select_kth_Two {

	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public int iterativeQS(int[] array, int k) {
		int low = 0, high = array.length - 1;

		while (low < high) {
			int i = low, j = high;
			int mid = array[(i + j) / 2];

			while (i < j) {
				// large values at end
				if (array[i] >= mid) {
					this.swap(array, i, j);
					j--;
					// skip if smaller than pivot
				} else {
					i++;
				}
			}
			if (array[i] > mid)
				i--;
			if (k <= i) {
				high = i;
			} else {
				low = i + 1;
			}
		}
		return array[k];
	}

	public void test(int size, int k) {
		Array array = new Array(size);
		array.generateElements(array.getArray());
		this.iterativeQS(array.getArray(), k-1);
	}
}
