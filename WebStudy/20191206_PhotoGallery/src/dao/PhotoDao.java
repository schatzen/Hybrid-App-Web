package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.PhotoVo;

public class PhotoDao {

	//Single-ton : ��ü1���� �����ؼ� ��������
	static PhotoDao single = null;

	public static PhotoDao getInstance() {
		if (single == null)
			single = new PhotoDao();
		return single;
	}
	
	//�����ȸ
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = new ArrayList<PhotoVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from photo order by p_idx desc";

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
				PhotoVo vo = new PhotoVo();

				//���緹�ڵ�->Vo����
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_subject(rs.getString("p_subject"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setP_regdate(rs.getString("p_regdate"));
				vo.setM_idx(rs.getInt("m_idx"));
				
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
	
	
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from photo where p_idx=?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement(���ó����ü) ��� 
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter����
			pstmt.setInt(1, p_idx);
			//4.ResultSet(�����ó����ü) ���
			rs = pstmt.executeQuery();

			//5.��ü���ڵ� �о����
			while (rs.next()) {
				//1���� ������(���ڵ�)�� ���� ��ü  
				vo = new PhotoVo();

				//���緹�ڵ�->Vo����
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_subject(rs.getString("p_subject"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setP_regdate(rs.getString("p_regdate"));
				vo.setM_idx(rs.getInt("m_idx"));

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

		return vo;
	}
	
	//�߰�
	public int insert(PhotoVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = //                                 1 2 3 4         5
		"insert into photo values(seq_photo_idx.nextVal,?,?,?,?,sysdate,?)";

		try {
			//1.Connection���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt's parameterä���
            pstmt.setString(1, vo.getP_subject());
            pstmt.setString(2, vo.getP_content());
            pstmt.setString(3, vo.getP_filename());
            pstmt.setString(4, vo.getP_ip());
            pstmt.setInt(5, vo.getM_idx());
			//4.DB SQL ����
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//�ݱ�(����)
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	//����
	public int delete(int p_idx) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from photo where p_idx=?";

		try {
			//1.Connection���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt's parameterä���
            pstmt.setInt(1, p_idx);
			//4.DB SQL ����
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//�ݱ�(����)
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	//����
	public int update(PhotoVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql =    //          1           2      3                               4   
		"update photo set p_subject=?,p_content=?,p_ip=?,p_regdate=sysdate where p_idx=?";

		try {
			//1.Connection���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt's parameterä���
            pstmt.setString(1, vo.getP_subject());
            pstmt.setString(2, vo.getP_content());
            pstmt.setString(3, vo.getP_ip());
            pstmt.setInt(4, vo.getP_idx());
            
			//4.DB SQL ����
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//�ݱ�(����)
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	
	
}
