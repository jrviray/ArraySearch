package proj2;

public class Test {

	public static void main(String[] args) {
		test(500000,(int)(500000*.75));
	}

	public static void test(int size, int k) {
		Select_kth_One one = new Select_kth_One();
		Select_kth_Two two = new Select_kth_Two();
		Select_kth_Three three = new Select_kth_Three();
		Select_kth_Four four = new Select_kth_Four();

		long initTime = 0;
		long finalTime = 0;
		long total = 0;

		for (int i = 0; i < 5; i++) {
			initTime = System.currentTimeMillis();
			// one.test(size, k);
			// two.test(size, k);
			three.test(size, k);
			// four.test(size, k);
			finalTime = System.currentTimeMillis();
			total = total + (finalTime - initTime);
		}

		System.out.println("Size: " + size + "  k: " + k);
		System.out.print("Execution time for Select kth one: ");
		System.out.print(total / 5 + " milliseconds.");
		System.out.println();
	}

}
