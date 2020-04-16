package myutil;

//                 Generic����
public class MyArrayList<T> {

	//��ü�� �����ɶ� Type�� ����
	T [] data=null;
	
	public void add(T ob) {
		
		//ù��° �߰���
		if(data==null) { 
			data = (T[])new Object[1];
			data[0] = ob;
			return;
		}
		
		//�����迭�������� 1�� �� ���� �Ҵ�
		T [] imsi = (T [])new Object[this.size()+1];
        //���������͸� imsi�迭�� �ű��
		for(int i=0;i<this.size();i++) {
			imsi[i] = data[i];
		}
		
		//���ε��� �� �������� �ִ´�
		imsi[this.size()] = ob;
				
		//imsi->data
		data = imsi;
			
	}
	
	public int size() {
		
		return (data==null) ? 0 : data.length;
	}
	
	// get(index)�� ����ϴ� ����������� ����ó���ϵ���
	// ����
	public T get(int index) throws Exception{
		
		//���������� ���
		if(index<0 || index >= this.size()) {
			String message = 
					String.format("÷�ڻ����� 0~%d => ��û÷�� :%d", 
							  this.size()-1, index
							);
			//���ܸ� ������->�ܺΰ�ü���� ó�� ����
			throw new Exception(message);
		}
		
		return data[index];
	}

	public void remove(int index) throws Exception {
		// TODO Auto-generated method stub
		//���������� ���
		if(index<0 || index >= this.size()) {
			String message = 
					String.format("÷�ڻ����� 0~%d => ��û÷�� :%d", 
							  this.size()-1, index
							);
			//���ܸ� ������->�ܺΰ�ü���� ó�� ����
			throw new Exception(message);
		}
		
		//����ó��
		
		//1�� �������� ����
		if(this.size()==1) {
			data = null;
			return;
		}
		
		
		//1.imsi�迭 : ��������-1 ����
		T [] imsi  = (T [])new Object[this.size()-1];
		//2.data->imsi�ι迭 �ű�� (������ index�κ��� ����)
		for(int i=0;i<imsi.length;i++) {
			if(i<index)
				imsi[i] = data[i];
			else
				imsi[i] = data[i+1];
		}
		//3.data=imsi
		data=imsi;
		
	}
	
	
}
