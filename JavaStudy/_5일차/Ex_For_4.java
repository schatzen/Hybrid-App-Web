class Ex_For_4
{
	public static void main(String[] args) 
	{
		//ABCDEF....Z
        //방법1)
		for(int i='A'; i<='Z';i++){
		    System.out.printf("%c",i);
		}
		System.out.println();//줄바꾸기

		//방법2)
		for(int i=0;i<26;i++){ //i = 0 1 2 ... 25
            System.out.printf("%c(%d)", 'A' + i, 'A' + i); // 'B' = 'A'+1 
		}
		System.out.println();//줄바꾸기

        //대소대소대....
		//A b C d E f G h....
		//6566
		//'A':65  'a':97
        for(int i='A'; i<='Z';i++){
			if(i%2==1)//홀수면
		       System.out.printf("%c",i);//대
            else
		       System.out.printf("%c",i+32);//소
		}
		System.out.println();//줄바꾸기 

        //100100100100 
		//012345678901  <= i 
		//AbcDefGhiJkl.....
        for(int i=0;i<26;i++){ //i = 0 1 2 ... 25
			if(i%3==0)
               System.out.printf("%c", 'A' + i); //대
			else
               System.out.printf("%c", 'A' + i + 32); //소
		}
		System.out.println();//줄바꾸기 

		//ABC-DEF-GHI-JKL-.....
		//012 345 678 901
		//  -   -   -   -
        for(int i=0;i<26;i++){ //i = 0 1 2 ... 25
            System.out.printf("%c", 'A' + i); 
			if(i%3==2)
			  System.out.print('-');
		}
		System.out.println();//줄바꾸기

		//A#B*C@D#E*F@G#H*I@.....
        //0 1 2 3 4 5 6 7 8    <=  i  
		for(int i=0;i<26;i++){ //i = 0 1 2 ... 25
            System.out.printf("%c", 'A' + i); 
			if(i%3==0)
			  System.out.print('#');
			else if(i%3==1)
			  System.out.print('*');
			else if(i%3==2)
			  System.out.print('@');
		}
		System.out.println();//줄바꾸기









	}
}
