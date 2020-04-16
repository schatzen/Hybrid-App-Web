package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVo;

public class SungTBDao {

	// Single-ton : ��ü1���� �����ؼ� ��������
	static SungTBDao single = null;

	public static SungTBDao getInstance() {
		if (single == null)
			single = new SungTBDao();
		return single;
	}

	// ������ȸ
	public List<SungVo> selectList() {

		List<SungVo> list = new ArrayList<SungVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view";

		try {
			// 1.Connection ������
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement(���ó����ü) ���
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter����

			// 4.ResultSet(�����ó����ü) ���
			rs = pstmt.executeQuery();

			// 5.��ü���ڵ� �о����
			while (rs.next()) {
				// 1���� ������(���ڵ�)�� ���� ��ü
				SungVo vo = new SungVo();

				// ���� Record(rs)���� �� �ʵ尪 ������
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				String tot = rs.getString("tot");
				String avg = rs.getString("avg");
				String rank = rs.getString("rank");

				// vo�� �ֱ�
				vo.setIdx(idx);
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);
				vo.setTot(tot);
				vo.setAvg(avg);
				vo.setRank(rank);

				// ����Ʈ �߰�
				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			try {
				// �ݱ�(��������)
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

	// �����߰�
	public int insert(SungVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		// parameter index 1 2 3 4 (�ܺο��� �ִ� ���ڰ� ?ǥ��)
		String sql = "insert into sungtb values(seq_sungtb_idx.nextVal,?,?,?,?)";

		try {
			// 1. Connecton ���
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement ���
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt's parameter ä���
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());

			// 4. DB SQL ����
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// �ݱ� (����)
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

	// ��������
	public int update(SungVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = // 1 2 3 4 5
				"update sungtb set name=?, kor=?, eng=?, mat=? where idx=?";

		try {
			// 1. Connecton ���
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement ���
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt's parameter ä���
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());

			// 4. DB SQL ����
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// �ݱ� (����)
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

	// ��������
	public int delete(int idx) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = 
				"delete from sungtb where idx=?";

		try {
			// 1. Connecton ���
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement ���
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt's parameter ä���
			pstmt.setInt(1, idx);

			// 4. DB SQL ����
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// �ݱ� (����)
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
