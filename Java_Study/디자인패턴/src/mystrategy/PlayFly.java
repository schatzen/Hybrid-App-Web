package mystrategy;

public class PlayFly {
	
	public static void main(String[] args) {
		Animal spooky = new Dog();
		Animal tweety = new Bird();
		
		String dog = spooky.tryToFly();
		String bird = tweety.tryToFly();
		
		System.out.println("spooky : " + dog);
		System.out.println("tweety : " + bird);
		
		
		
	}

}
