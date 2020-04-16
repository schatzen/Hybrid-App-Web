package myutil;

public class MyArray2 {

	public void setArray(int [][] mm) {
		int su = 1;
		int rows = mm.length;//Çà°¹¼ö
		for(int i=0;i<rows;i++) {//ÇàÃ·ÀÚ 
			
			for(int k=0;k<mm[i].length;k++) {//¿­Ã·ÀÚ
				
				mm[i][k] = su;
				su++;
			}
		}
	}
	
	public void display(int [][] mm) {
		
		for(int i=0;i<mm.length;i++) {//ÇàÃ·ÀÚ
			
			for(int k=0;k<mm[i].length;k++) {//¿­Ã·ÀÚ
				
				System.out.printf("%4d", mm[i][k]);
				
			}
			
			//ÁÙ¹Ù²Ù±â
			System.out.println();
		}
	}
	
	//ÀüÃ¼¸¦ valÃ¤¿ì±â
	public void fill(int [][] mm, int val) {
		
		for(int i=0;i<mm.length;i++) {//ÇàÃ·ÀÚ 
			
			for(int k=0;k<mm[i].length;k++) {//¿­Ã·ÀÚ
				
				mm[i][k] = val;
				
			}
		}
	}
	
	//ÁöÁ¤µÈ Çà(rowIndex)¸¸ val·Î Ã¤¿ì±â
	public void fill(int [][] mm, int rowIndex, int val) {
		
		for(int k=0;k<mm[rowIndex].length;k++) {//¿­Ã·ÀÚ
			
			mm[rowIndex][k] = val;
			
		}
	}
	
	public void display_block(int [][] mm) {
		
		for(int i=0;i<mm.length;i++) {//ÇàÃ·ÀÚ
			
			for(int k=0;k<mm[i].length;k++) {//¿­Ã·ÀÚ
				
				if(mm[i][k]==1)
					System.out.printf("%s","¡á");
				else
					System.out.printf("%s","  ");
				
			}
			
			//ÁÙ¹Ù²Ù±â
			System.out.println();
		}
	}
	
	
	
}
