class MyLine 
{

	//1. Call By Nme : ȣǮ�� �޼ҵ�� ȣ��
	public void draw_line() {
		System.out.println("------------------------------");
		return; 

				//(��������) �ڽ��� ȣ���� ������ �����ض�
				// return 0; ���� �ٲٷ��� void ��� int�� �ٲ���Ѵ�. 
				// retrun 0.0; ���� �ٲٷ��� int ��� double�� �ٲ���Ѵ�.
				// return 0; �϶� double draw_line();�ص� ������. ����ȯ��.
				// void�� ��ȯ�� �ڷ����� ���ٴ� ��
	}

	//2. Call By Value : ȣ��� ȣ�����ڵ� ���� �Ѱܼ� �̿�
	public void draw_line(int len) {

		for(int i=0;i<len;i++){
		System.out.print('-');
		}

		System.out.println();
	}

	public void draw_line(char style,int len, int len1) {

		for(int i=0;i<len1;i++){
		for(i=0;i<len;i++){
		System.out.print(style);
		}
		}
		System.out.println();
	}

	public void draw_line(char style1, int len1, char style2, int len2, int total_len) {

//				for(int i=1;i<=total_len/(len1+len2);i++) {
//
//					for(int k=1;k<=len1;k++) {
//					System.out.print(style1);
//					}
//
//					for(int j=1;j<=len2;j++) {
//					System.out.print(style2);
//					
//						}
//							}
//							System.out.println();	

			// ����� ���� ������ ����
			int count =0;
			while(true) {

				//pattern1 ���
				for(int i=0; i<len1; i++) {
				System.out.print(style1);
				count ++; 

					if(count==total_len){
					System.out.println();
					return;//���� �޼ҵ� ����
					}

						 //���� �޼ҵ� ����
				}

				//pattern2 ���
				for(int i=0; i<len2; i++) {
				System.out.print(style2);
				count ++; 

				if(count==total_len){
					System.out.println();
					return;
					}
						
			}
		}
	}
}

