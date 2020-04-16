package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import vo.PersonVo;

public class TableTest extends JFrame {

	JTable jtb_display;
	
	List<PersonVo> p_list = new ArrayList<PersonVo>();
	
//--JTable배치모델 선언
	class MyTableModel extends AbstractTableModel
	{
		String [] title = {"번호","이름","나이","전화"};
		
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return title[column];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return title.length;
		}
		
		

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return p_list.size();//데이터 갯수
		}
	
		
	
		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			//String str = String.format("(%d,%d)",row,col);
			// 4 * 100
			PersonVo p = p_list.get(row);
			
			if(col==0) return p.getNo();
			else if(col==1) return p.getName();
			else if(col==2) return p.getAge();
			else if(col==3) return p.getTel();
			
			return null;
		}
	}
	
	
	public TableTest() {
		// TODO Auto-generated constructor stub
		super("title");

		//sample data입력
		for(int i=1;i<=100;i++) {
			String name = String.format("길동_%04d", i);
			int    age  = 20 + (i-1)%11;
			String tel  = String.format("010-%d%d%d-1234",
					                      i%10,i%10,i%10);
			
			PersonVo p = new PersonVo(i, name, age, tel);
			p_list.add(p);
		}
		
		
		init_center();
		
		//JTable배치모델 적용
		jtb_display.setModel(new MyTableModel());
		
		//위치
		setLocation(200, 100);

		//크기
		//setSize(300, 300);
		setResizable(false);
		pack();

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_center() {
		// TODO Auto-generated method stub
		jtb_display = new JTable();
		JScrollPane jsp = new JScrollPane(jtb_display);
		jsp.setPreferredSize(new Dimension(400, 300));
		this.add(jsp,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TableTest();
	}
}
