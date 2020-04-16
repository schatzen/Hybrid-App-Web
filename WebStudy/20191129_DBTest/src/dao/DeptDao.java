package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.DeptVo;

public class DeptDao {

	//Single-ton : ��ü1���� �����ؼ� ��������
	static DeptDao single = null;

	public static DeptDao getInstance() {
		if (single == null)
			single = new DeptDao();
		return single;
	}
	
	//�μ���� ��ȸ
	public List<DeptVo> selectList() {

		List<DeptVo> list = new ArrayList<DeptVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement(���ó����ü) ��� 
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter����

			//4.ResultSet(�����ó����ü) ���
			rs = pstmt.executeQuery();

			//5.��ü���ڵ� �о����
			while (rs.next()) {
				//1���� ������(���ڵ�)�� ���� ��ü  
				DeptVo vo = new DeptVo();

				//���緹�ڵ�(rs)->Vo����
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				
				//����Ʈ �߰�
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			try {
				//�ݱ�(��������)
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	
	
}









