package mymain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import dao.SungTBDao;
import vo.SungVo;

public class Main_Sung_ extends JFrame {

	// 입,출력필드
	JTextField jtf_idx, jtf_name, jtf_kor, jtf_eng, jtf_mat, jtf_tot, jtf_avg, jtf_rank;

	// 작업버튼
	JButton jbt_new, jbt_update, jbt_delete, jbt_prev, jbt_next;

	// 성적목록
	List<SungVo> sung_list;

	// 조회
	JTable jtb_display;

	boolean bAdd = false;// 추가 or 수정작업여부

	int current_pos = -1;// 현재 출력되는 데이터 인덱스

	public Main_Sung_() {
		// TODO Auto-generated constructor stub
		super("성적관리");// 타이틀

		// 입출력필드 및 작업버튼 초기화
		init_inputs();
		// 조회창 초기화
		init_display();

		// 전체 데이터 가져와서 JTable에 출력
		display_sung_list();

		// 데이터가 존재하면
		if (sung_list.size() > 0) {
			current_pos = 0;
			display_input(); // 현재 pos위치 데이터를 입력창에 출력
		}
		// 버튼 사용유무 설정
		enable_buttons();

		// 위치 및 크기지정
		// setBounds(200, 100, 400, 300);
		setLocation(300, 100);

		setResizable(false);

		pack();

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void enable_buttons() {
		// TODO Auto-generated method stub
		// 이전 버튼 활성화
		jbt_prev.setEnabled(bAdd == false && current_pos > 0);
		// 다음 버튼 활성화
		jbt_next.setEnabled(bAdd == false && current_pos < sung_list.size() - 1);
		// 삭제 버튼 활성화
		jbt_delete.setEnabled(bAdd == false && sung_list.size() > 0);
		// 수정 버튼 활성하ㅗ
		jbt_update.setEnabled(bAdd == true || sung_list.size()>0);
	}

	public void clear_input() {
		jtf_idx.setText("");
		jtf_name.setText("");
		jtf_kor.setText("");
		jtf_eng.setText("");
		jtf_mat.setText("");

		jtf_tot.setText("");
		jtf_avg.setText("");
		jtf_rank.setText("");

		// 입력포커스를 이름에 넣는다.
		jtf_name.requestFocus();

	}

	private void display_input() {
		// TODO Auto-generated method stub
		// ArraayList 중에 current_pos의 데이터를 읽어오기
		SungVo vo = sung_list.get(current_pos);

		jtf_idx.setText(vo.getIdx() + "");
		jtf_name.setText(vo.getName() + "");
		jtf_kor.setText(vo.getKor() + "");
		jtf_eng.setText(vo.getEng() + "");
		jtf_mat.setText(vo.getMat() + "");

		jtf_tot.setText(vo.getTot());
		jtf_avg.setText(vo.getAvg());
		jtf_rank.setText(vo.getRank());

		// 현재 선택된 index 선택지정
		jtb_display.setRowSelectionInterval(current_pos, current_pos);

		enable_buttons();
	}

	// --JTable에 데이터를 배치할 모댈객체 선언
	class SungTableModel extends AbstractTableModel {

		// 제목(헤딩)
		String[] title = { "번호", "이름", "국어", "영어", "수학", "총점", "평균", "등수" };

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return title[column];
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return sung_list.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub

			SungVo vo = sung_list.get(row);

			switch (col) {
			case 0:
				return vo.getIdx();
			case 1:
				return vo.getName();
			case 2:
				return vo.getKor();
			case 3:
				return vo.getEng();
			case 4:
				return vo.getMat();
			case 5:
				return vo.getTot();
			case 6:
				return vo.getAvg();
			case 7:
				return vo.getRank();
			}
			return null;
		}

	}

	// --End SungTableModel

	private void display_sung_list() {
		// TODO Auto-generated method stub
		// 전체 데이터 가져오기
		sung_list = SungTBDao.getInstance().selectList();
		System.out.println(sung_list.size());
		// JTable에 데이터 배치
		jtb_display.setModel(new SungTableModel());

	}

	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		// 입력창
		JPanel p1 = new JPanel(new GridLayout(4, 2));

		p1.add(new JLabel("이름:"));
		p1.add(jtf_name = new JTextField());

		p1.add(new JLabel("번호:"));
		p1.add(jtf_idx = new JTextField());

		p1.add(new JLabel("국어:"));
		p1.add(jtf_kor = new JTextField());

		p1.add(new JLabel("총점:"));
		p1.add(jtf_tot = new JTextField());

		p1.add(new JLabel("영어:"));
		p1.add(jtf_eng = new JTextField());

		p1.add(new JLabel("평균:"));
		p1.add(jtf_avg = new JTextField());

		p1.add(new JLabel("수학:"));
		p1.add(jtf_mat = new JTextField());

		p1.add(new JLabel("등수:"));
		p1.add(jtf_rank = new JTextField());

		// 출력창
		JPanel p2 = new JPanel(new GridLayout(1, 5));
		p2.add(jbt_prev = new JButton("이전"));
		p2.add(jbt_new = new JButton("추가"));
		p2.add(jbt_update = new JButton("수정"));
		p2.add(jbt_delete = new JButton("삭제"));
		p2.add(jbt_next = new JButton("다음"));

		p.add(p1, "Center");
		p.add(p2, "South");

		this.add(p, "Center");

		// 버튼이벤트 초기화
		init_button_event();

		// 번호/총점/평균/등수 <= 읽기전용
		jtf_idx.setEditable(false);
		jtf_tot.setEditable(false);
		jtf_avg.setEditable(false);
		jtf_rank.setEditable(false);

	}

	private void init_button_event() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 이벤트를 발생시킨 버튼
				Object evt_src = e.getSource();

				if (evt_src == jbt_new)
					on_new();
				else if (evt_src == jbt_update)
					on_update();
				else if (evt_src == jbt_delete)
					on_delete();
				else if (evt_src == jbt_prev)
					on_prev();
				else if (evt_src == jbt_next)
					on_next();

			}
		};

		// 이벤트소스, addActionListener (처리객체)
		jbt_new.addActionListener(listener);
		jbt_update.addActionListener(listener);
		jbt_delete.addActionListener(listener);
		jbt_prev.addActionListener(listener);
		jbt_next.addActionListener(listener);

	}

	protected void on_next() {
		// TODO Auto-generated method stub
		current_pos++;

		display_input();
	}

	protected void on_prev() {
		// TODO Auto-generated method stub
		current_pos--;
		display_input();
	}

	protected void on_delete() {
		// TODO Auto-generated method stub
		// 삭제확인
		int result = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "[삭제]", JOptionPane.YES_NO_OPTION);

		// '예'가 아니면 끝내라
		if (result != JOptionPane.YES_OPTION)
			return;

		// 삭제코드...
		// 삭제 할 idx 얻어오기
		int idx = Integer.parseInt(jtf_idx.getText());
		// 삭제
		int res = SungTBDao.getInstance().delete(idx);

		// 삭제 후 갱신된 데이터 가져오기
		display_sung_list();

		if (sung_list.size() == 0) { // 삭제 후 데이터가 없으면
			current_pos = -1;
			clear_input();
			enable_buttons();
			return;

		}

		// 삭제된 데이터가 마지막 데이터라면
		if (current_pos == sung_list.size())
			current_pos--;

		display_input();

	}

	protected void on_update() {
		// TODO Auto-generated method stub

		// 입력값 얻어오기 > 공백제거

		String name = jtf_name.getText().trim();
		String str_kor = jtf_kor.getText().trim();
		String str_eng = jtf_eng.getText().trim();
		String str_mat = jtf_mat.getText().trim();

		int kor = 0;
		int eng = 0;
		int mat = 0;

		if (name.isEmpty()) { // if(name.equals(""))
			jtf_name.setText("");
			JOptionPane.showMessageDialog(this, "이름을 입력하세요");
			jtf_name.requestFocus();
			return;
		}

		// 국어점수 체크
		try {
			// 숫자아닌 값을 정수로 변환하면 예외가 걸린다
			kor = Integer.parseInt(str_kor);

			if (kor < 0 || kor > 100) {
				JOptionPane.showMessageDialog(this, "0~100 사이 숫자만 입력하세요");
				return;

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			jtf_kor.setText("");
			JOptionPane.showMessageDialog(this, "숫자만 입력하세요");
			jtf_kor.requestFocus();
			return;

		}

		// 영어 점수 체크
		try {
			// 숫자아닌 값을 정수로 변환하면 예외가 걸린다
			eng = Integer.parseInt(str_eng);

			if (eng < 0 || eng > 100) {
				JOptionPane.showMessageDialog(this, "0~100 사이 숫자만 입력하세요");
				return;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			jtf_eng.setText("");
			JOptionPane.showMessageDialog(this, "숫자만 입력하세요");
			jtf_eng.requestFocus();
			// return;

		}

		// 수학 점수 체크
		try {
			// 숫자아닌 값을 정수로 변환하면 예외가 걸린다
			mat = Integer.parseInt(str_mat);

			if (mat < 0 || mat > 100) {
				JOptionPane.showMessageDialog(this, "0~100 사이 숫자만 입력하세요");
				return;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			jtf_mat.setText("");
			JOptionPane.showMessageDialog(this, "숫자만 입력하세요");
			jtf_mat.requestFocus();
			// return;
		}

		if (bAdd) { // 등록
			// 입력된 값을 SungVo포장
			SungVo vo = new SungVo(name, kor, eng, mat);
			// DB Insert 요청
			int res = SungTBDao.getInstance().insert(vo);

			// 전체리스트를 갱신
			display_sung_list();

			// 현재위치를 마지막에 위치
			current_pos = sung_list.size() - 1;
			display_input();

			// 입력사항 초기화
			bAdd = false;
			jbt_new.setText("추가");
			jbt_update.setText("수정");

		} else { // 수정
			int result = JOptionPane.showConfirmDialog(this, "정말 수정하시겠습니까?", "[수정]", JOptionPane.YES_NO_OPTION);
			// 예가 아니면 끝내라..
			if (result != JOptionPane.YES_OPTION) {

				display_input(); // 디스플레이창이 원위치가 되도록
				return;
			}

			// 수정작업
			int idx = Integer.parseInt(jtf_idx.getText());

			// 수정할 데이터 포장
			SungVo vo = new SungVo(idx, name, kor, eng, mat);
			// DB수정
			int res = SungTBDao.getInstance().update(vo);

			// 전체 데이터 가져오기
			display_sung_list();

			// 입력창 갱신
			display_input();

		}
	}

	protected void on_new() {
		// TODO Auto-generated method stub
		bAdd = !bAdd;
		if (bAdd) { // 입력준비
			clear_input();
		} else {
			if (sung_list.size() > 0)
				display_input();
			else
				clear_input();
		}
		// 버튼 캡션 병경
		jbt_new.setText(bAdd ? "취소" : "추가");
		jbt_update.setText(bAdd ? "등록" : "수정");

		// 버튼상태
		enable_buttons();
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jtb_display = new JTable();
		JScrollPane jsp = new JScrollPane(jtb_display);

		jsp.setPreferredSize(new Dimension(400, 200));

		this.add(jsp, "South");

		// JTable에서 마우스가 클릭되면
		jtb_display.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				current_pos = jtb_display.getSelectedRow();
				display_input();
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main_Sung_();
	}

}