
import java.util.Scanner;

class ¹®Á¦4
{
	/*
        //¼·¾¾->È­¾¾
		F  = 9/5*C + 32 

		//È­¾¾->¼·¾¾
		C  = 5/9*(F-32) 
	*/
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        double c;
		double f;   // f = 9/5*c + 32 

        System.out.print("¿Âµµ(¼·¾¾):" );
		c = scan.nextDouble();

		f = 9.0/5.0 * c + 32.0;
        
		System.out.println("*** °á°ú ***");
		System.out.printf("¼·¾¾ %.1fµµ´Â È­¾¾ %.1fÀÔ´Ï´Ù\n",c,f);



	}
}
