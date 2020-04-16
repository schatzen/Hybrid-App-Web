class Star_4 {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 5; k++) {

				if (k == 2 || i == 2)
					System.out.print("*");
				else
					System.out.print(" ");

			}
			Thread.sleep(100);
			System.out.println();
		}
	}
}
