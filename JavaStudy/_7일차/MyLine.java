class MyLine
{
	//Call By Name : ȣ��� �޼ҵ�� �̿�
	public void draw_line(){
		System.out.println("----------------------------------");
		return; //(��������) �ڽ��� ȣ���� ������ �����ض�
	}

    //Call By Value : ȣ��� ȣ�����ڵ� ���̳Ѱܼ� ȣ��
	public void draw_line(int len){

        for(int i=0;i<len;i++){
		   System.out.print('-');
		}

		System.out.println();//�ٹٲٱ�
	}

    //Call By Value : ȣ��� ȣ�����ڵ� ���̳Ѱܼ� ȣ��
	public void draw_line(char style,int len){

        for(int i=0;i<len;i++){
		   System.out.print(style);
		}

		System.out.println();//�ٹٲٱ�
	}

    // ml.draw_line('*',1,'-',3,40);
    // *---*---*---*---*---*---*---*---*---*---*---*---
	// ml.draw_line('*',2,'-',2,40);
	// **--**--**--**--**--**--**--**--**--**--**--**--
	// ml.draw_line('#',3,'@',2,40);
	// ###@@###@@###@@###@@###@@###@@###@@###@@###@@###
	public void draw_line(
		        char style1,int len1,//pattern1���� 
		        char style2,int len2,//pattern2����
		        int total_len){      //��ü������
          
		  //����� ���������� ����
		  int count = 0;
		  while(true){
              //pattern1���
			  for(int i=0;i<len1;i++){
                 System.out.print(style1);
				 count++;
				 //������ ���̸�ŭ ���������
                 if(count==total_len){
				     System.out.println();	 
					 return;//(���� �޼ҵ� ����)
				 }
			  }
			  //pattern2���
			  for(int i=0;i<len2;i++){
                 System.out.print(style2);
				 count++;
                 //������ ���̸�ŭ ���������
                 if(count==total_len){
				     System.out.println();	 
					 return;//(���� �޼ҵ� ����)
				 }
			  }
		  }

	}



}
