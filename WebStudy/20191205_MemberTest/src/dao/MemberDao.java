package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class MemberDao {

	//Single-ton : ��ü1���� �����ؼ� ��������
	static MemberDao single = null;

	public static MemberDao getInstance() {
		if (single == null)
			single = new MemberDao();
		return single;
	}
	
	//�����ȸ
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member order by idx desc";

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
				MemberVo vo = new MemberVo();

				//���緹�ڵ�->Vo����
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));
				
				vo.setGrade(rs.getString("grade"));
								
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
	
	public MemberVo selectOne(int idx) {

		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where idx=?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement(���ó����ü) ��� 
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter����
			pstmt.setInt(1, idx);
			
			//4.ResultSet(�����ó����ü) ���
			rs = pstmt.executeQuery();

			//5.1�� ���ڵ� �о����
			if (rs.next()) {
				//1���� ������(���ڵ�)�� ���� ��ü  
				vo = new MemberVo();

				//���緹�ڵ�->Vo����
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));
				
				vo.setGrade(rs.getString("grade"));
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
	
	public MemberVo selectOne(String id) {

		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement(���ó����ü) ��� 
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter����
			pstmt.setString(1, id);
			
			//4.ResultSet(�����ó����ü) ���
			rs = pstmt.executeQuery();

			//5.1�� ���ڵ� �о����
			if (rs.next()) {
				//1���� ������(���ڵ�)�� ���� ��ü  
				vo = new MemberVo();

				//���緹�ڵ�->Vo����
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));
				
				vo.setGrade(rs.getString("grade"));
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
	
	public int insert(MemberVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = 
		//                                                1 2 3 4 5 6 7 
		"insert into member values(seq_member_idx.nextVal,?,?,?,?,?,?,?,sysdate,sysdate)";

		try {
			//1.Connection���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt's parameterä���
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getZipcode());
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getIp());
			pstmt.setString(7, vo.getGrade());
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

	public int delete(int idx) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from member where idx=?";

		try {
			//1.Connection���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt's parameterä���
            pstmt.setInt(1, idx);  
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

	public int update(MemberVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = //          1     2         3      4    5       6                               7 
		 "update member set name=?,pwd=?,zipcode=?,addr=?,ip=?,grade=?, modifydate=sysdate where idx=?";

		try {
			//1.Connection���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt's parameterä���
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getZipcode());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getIp());
			pstmt.setString(6, vo.getGrade());
			pstmt.setInt(7, vo.getIdx());

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
