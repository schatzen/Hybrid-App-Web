class ����3 {
	public static void main(String[] args) throws Exception {
		System.out.print("���� 1���� �Է��ϼ��� >> ");
		int ch = System.in.read();

		if (ch >= 65 && ch <= 90) {
			System.out.printf("���� %c��(��) �빮���Դϴ�.\n", ch);
		} else if (ch >= 97 && ch <= 122) {
			System.out.printf("���� %c��(��) �ҹ����Դϴ�.\n", ch);
		} else if (ch >= 48 && ch <= 57) {
			System.out.printf("���� %c��(��) �����Դϴ�.\n", ch);
		} else {
			System.out.printf("���� %c��(��) Ư�������Դϴ�.\n", ch);
		}

		// �빮�ڳ�?
		// �ҹ��ڳ�?
		// ���ڳ�?
		// Ư�����ڳ�?
	}
}
