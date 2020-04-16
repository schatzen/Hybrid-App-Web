package vo;

import java.util.Comparator;

public class PersonComp implements Comparator<PersonVo> {

	// 정렬 기준을 설정할 상수
	public static final int SORT_FIELD_NAME = 1;
	public static final int SORT_FIELD_AGE = 2;
	public static final int SORT_FIELD_ADDR = 3;

	// 정렬 방식을 설정할 상수
	public static final int SORT_METHOD_ASC = 1; // 오름차순
	public static final int SORT_METHOD_DESC = 2; // 내림차순

	// 변수
	int sort_field = SORT_FIELD_NAME;
	int sort_method = SORT_METHOD_ASC;
	
	

	public int getSort_field() {
		return sort_field;
	}



	public void setSort_field(int sort_field) {
		this.sort_field = sort_field;
	}



	public int getSort_method() {
		return sort_method;
	}



	public void setSort_method(int sort_method) {
		this.sort_method = sort_method;
	}



	@Override
	public int compare(PersonVo o1, PersonVo o2) {
		// TODO Auto-generated method stub
		int ret = 0;

		if (sort_field == SORT_FIELD_NAME) {
			// 이름순 정렬
			if (o1.getName().compareTo(o2.getName()) > 0)
				ret = 1;
			else if (o1.getName().compareTo(o2.getName()) < 0)
				ret = -1;

			// 나이순 정렬
		} else if (sort_field == SORT_FIELD_AGE) {
			if (o1.getAge() > o2.getAge())
				ret = 1;
			else if (o1.getAge() < o2.getAge())
				ret = -1;

			// 주소순 정렬
		} else if (sort_field == SORT_FIELD_ADDR) {
			if (o1.getAddr().compareTo(o2.getAddr()) > 0)
				ret = 1;
			else if (o1.getAddr().compareTo(o2.getAddr()) < 0)
				ret = -1;
		}

		// 내림차순
		if(sort_method == SORT_METHOD_DESC )
		ret = -ret;

		return ret;
	}

}
