package myutil;

//                 Generic선언
public class MyArrayList<T> {

	//객체가 생성될때 Type이 결정
	T [] data=null;
	
	public void add(T ob) {
		
		//첫번째 추가시
		if(data==null) { 
			data = (T[])new Object[1];
			data[0] = ob;
			return;
		}
		
		//이전배열갯수보다 1개 더 많게 할당
		T [] imsi = (T [])new Object[this.size()+1];
        //이전데이터를 imsi배열에 옮긴다
		for(int i=0;i<this.size();i++) {
			imsi[i] = data[i];
		}
		
		//새로들어온 값 마지막에 넣는다
		imsi[this.size()] = ob;
				
		//imsi->data
		data = imsi;
			
	}
	
	public int size() {
		
		return (data==null) ? 0 : data.length;
	}
	
	// get(index)을 사용하는 사용자측에서 예외처리하도록
	// 위임
	public T get(int index) throws Exception{
		
		//비정상적인 경우
		if(index<0 || index >= this.size()) {
			String message = 
					String.format("첨자사용범위 0~%d => 요청첨자 :%d", 
							  this.size()-1, index
							);
			//예외를 던진다->외부객체에게 처리 위임
			throw new Exception(message);
		}
		
		return data[index];
	}

	public void remove(int index) throws Exception {
		// TODO Auto-generated method stub
		//비정상적인 경우
		if(index<0 || index >= this.size()) {
			String message = 
					String.format("첨자사용범위 0~%d => 요청첨자 :%d", 
							  this.size()-1, index
							);
			//예외를 던진다->외부객체에게 처리 위임
			throw new Exception(message);
		}
		
		//삭제처리
		
		//1개 남았을때 삭제
		if(this.size()==1) {
			data = null;
			return;
		}
		
		
		//1.imsi배열 : 기존갯수-1 생성
		T [] imsi  = (T [])new Object[this.size()-1];
		//2.data->imsi로배열 옮기기 (삭제할 index부분을 빼고)
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
