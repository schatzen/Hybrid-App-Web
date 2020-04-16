package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/*
AWT(Abstract Window Toolkit) : ������ ���� ��ü ����
java.awt.*
javax.swing.*

���� ������: Frame(��� �޴��� ���� ���� ū Ʋ�� ������)
swing   	��JFrame


*/

public class MyWin extends JFrame implements KeyListener {

	// ȭ�� �ػ󵵸� ������ ����
	int screen_w, screen_h;

	public MyWin() { // �ʱ�ȭ�� ����

		super("Take A Deep Breathe"); // JFrame("Ÿ��Ʋ") > �� ��Ȯ���� Frame() ������ ����

		// ȭ�� �ػ� ���ϱ�
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;
		screen_h = d.height;

		System.out.printf("width = %d height = %d\n", screen_w, screen_h);

		// ��ġ ����(����ȭ�� ������ ����)
		// x y
		super.setLocation(400, 200);

		// Toolkit.����~ �� ��ü���� ���� �� �ִ� static �޼ҵ�

		// ũ�� ����
		super.setSize(300, 300);

		// �ش� ������ �������
		super.setVisible(true);

		// ������ ũ�� ���� �Ұ�
		super.setResizable(false);

		// �����ư ó��
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Ű���� �̺�Ʈ
		// ���� �����쿡�� Ű�� ������ �̺�Ʈ ó����
		// ���� �����쿡�� ����
		this.addKeyListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyWin(); // �⺻������ ����

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(e);
		int key = e.getKeyCode(); // ���� Ű ��

		// ���� ������ ��ġ ���ϱ�
		Point pt = this.getLocation();
		int gan = 10;

		// System.out.println();
		if (key == KeyEvent.VK_LEFT) { // KeyEvent.VK_���� : ���� Ű �� ����
			pt.x = pt.x - gan;
		} else if (key == KeyEvent.VK_RIGHT) {
			pt.x = pt.x + gan;
		} else if (key == KeyEvent.VK_UP) {
			pt.y = pt.y - gan;
		} else if (key == KeyEvent.VK_DOWN) {
			pt.y = pt.y + gan;
		}

		// ����� ��ǥ ������ �����츦 ����ġ
		this.setLocation(pt); // super�� ���� this�� ���� ū ���X

		// �� ������ ������?
		if (pt.x < -300) {
			pt.x = 1920;
		} else if (pt.x > 1920) {
			pt.x = -300;
		} else if (pt.y > 1080) {
			pt.y = -300;
		} else if (pt.y < -300) {
			pt.y = 1080;
		}

		this.setLocation(pt);

		// �� ������ ������?

		// �Ʒ��� ������?

		// ���� ������??

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
