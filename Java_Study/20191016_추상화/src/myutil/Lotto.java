package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	// ��÷��ȣ
	int[] win_no; // 7�ڸ�
	int[] user_no; // ����ڰ� �Է��� ��ȣ
	int count; // ���� ����
	int rank = 0; // ���

	int last;

	Random rand = new Random();

	// ��÷
	public void make_win_no() {
		win_no = new int[7];

		OUT_FOR: // Label
		for (int i = 0; i < win_no.length; i++) {
			int su = rand.nextInt(45) + 1; // 1~45 �� ���� ���� �̱�

			// �ߺ��� üũ
			for (int k = 0; k < i; k++) {
				// ���� ���� ������
				if (su == win_no[k]) {
					i--;
					continue OUT_FOR; // OUT_FOR�� �����ָ� i for�� �ƴ϶� k for�� ���ư���.
										// �ٱ� for���� ���������� �̵�(i++)
				}
			}
			win_no[i] = su;
		}
		// ������ ��ȣ�� ������ �տ� 6�ڸ� ���� ����
		Arrays.sort(win_no, 0, 0 + 6); // ���ʽ� ���ڋ����� ������ ���ڴ� ���ľ��ϰ� ����
		// 0 1 2 3 4 5 6
		// win_no = [1 3 5 6 7 9] 2

	}

	public void setUser_no(int[] user_no) {
		this.user_no = user_no;

		// ���� ���� �� ��� üũ
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
		// ��÷��ȣ ���
		for (int i = 0; i < win_no.length; i++) {
			if (i < 6)
				System.out.printf("%2d ", win_no[i]);
			else
				System.out.printf("[%d]\n", win_no[i]);
		}

		// ������ȣ ����
		Arrays.sort(user_no);
		System.out.print("������ȣ :");

		for (int i = 0; i < user_no.length; i++) {
			System.out.printf("%2d ", user_no[i]);
		}

		System.out.println();
		System.out.printf("���� ����: %d(��)\n", count + last);

		if (rank == 0)
			System.out.printf("��!!!\n", rank);
		else
			System.out.printf("��� : %d(��)\n", rank);

	}

}
