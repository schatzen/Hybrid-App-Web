class Star_3 {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 5; k++) {

				if (k == i || k == 4 - i)
					System.out.print(" ");
				else
					System.out.print("*");

			}
			Thread.sleep(100);
			System.out.println();
		}
	}
}
