package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	// 추첨번호
	int[] win_no; // 7자리
	int[] user_no; // 사용자가 입력한 번호
	int count; // 맞은 개수
	int rank = 0; // 등수

	int last;

	Random rand = new Random();

	// 추첨
	public void make_win_no() {
		win_no = new int[7];

		OUT_FOR: // Label
		for (int i = 0; i < win_no.length; i++) {
			int su = rand.nextInt(45) + 1; // 1~45 수 에서 랜덤 뽑기

			// 중복수 체크
			for (int k = 0; k < i; k++) {
				// 같은 수가 있으면
				if (su == win_no[k]) {
					i--;
					continue OUT_FOR; // OUT_FOR를 안해주면 i for가 아니라 k for로 돌아간다.
										// 바깥 for문의 증감식으로 이동(i++)
				}
			}
			win_no[i] = su;
		}
		// 마지막 번호를 제외한 앞에 6자리 숫자 정렬
		Arrays.sort(win_no, 0, 0 + 6); // 보너스 숫자떄문에 마지막 숫자는 정렬안하고 놔둠
		// 0 1 2 3 4 5 6
		// win_no = [1 3 5 6 7 9] 2

	}

	public void setUser_no(int[] user_no) {
		this.user_no = user_no;

		// 맞은 개수 및 등수 체크
		calc_rank();
	}

	public void calc_rank() {
		count = 0;
		last = 0;

		OUT_FOR: for (int i = 0; i < user_no.length; i++) {
			for (int k = 0; k < user_no.length; k++) {

				if (win_no[i] == user_no[k]) {
					count++;
					break;
				}

			}
			if (win_no[6] == user_no[i]) {
				last++;
				continue OUT_FOR;
			}

		}

		if (count == 3)
			rank = 5;
		if (count == 4)
			rank = 4;
		if (count == 5)
			rank = 3;
		if (count == 5 && last == 1)
			rank = 2;
		if (count == 6)
			rank = 1;

	}

	public void display() {
		// 추첨번호 출력
		for (int i = 0; i < win_no.length; i++) {
			if (i < 6)
				System.out.printf("%2d ", win_no[i]);
			else
				System.out.printf("[%d]\n", win_no[i]);
		}

		// 유저번호 정렬
		Arrays.sort(user_no);
		System.out.print("유저번호 :");

		for (int i = 0; i < user_no.length; i++) {
			System.out.printf("%2d ", user_no[i]);
		}

		System.out.println();
		System.out.printf("맞은 개수: %d(개)\n", count + last);

		if (rank == 0)
			System.out.printf("꽝!!!\n", rank);
		else
			System.out.printf("등수 : %d(등)\n", rank);

	}

}
