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

	// Single-ton : 객체1개만 생성해서 서비스하자
	static SungTBDao single = null;

	public static SungTBDao getInstance() {
		if (single == null)
			single = new SungTBDao();
		return single;
	}

	// 성적조회
	public List<SungVo> selectList() {

		List<SungVo> list = new ArrayList<SungVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view";

		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement(명령처리객체) 얻기
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter설정

			// 4.ResultSet(결과행처리객체) 얻어
			rs = pstmt.executeQuery();

			// 5.전체레코드 읽어오기
			while (rs.next()) {
				// 1건의 데이터(레코드)를 담을 객체
				SungVo vo = new SungVo();

				// 현재 Record(rs)에서 각 필드값 얻어오기
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				String tot = rs.getString("tot");
				String avg = rs.getString("avg");
				String rank = rs.getString("rank");

				// vo에 넣기
				vo.setIdx(idx);
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);
				vo.setTot(tot);
				vo.setAvg(avg);
				vo.setRank(rank);

				// 리스트 추가
				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			try {
				// 닫기(열린역순)
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

	// 성적추가
	public int insert(SungVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		// parameter index 1 2 3 4 (외부에서 주는 인자값 ?표시)
		String sql = "insert into sungtb values(seq_sungtb_idx.nextVal,?,?,?,?)";

		try {
			// 1. Connecton 얻기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt's parameter 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());

			// 4. DB SQL 전송
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 닫기 (역순)
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

	// 성적수정
	public int update(SungVo vo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = // 1 2 3 4 5
				"update sungtb set name=?, kor=?, eng=?, mat=? where idx=?";

		try {
			// 1. Connecton 얻기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt's parameter 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());

			// 4. DB SQL 전송
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 닫기 (역순)
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

	// 성적삭제
	public int delete(int idx) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = 
				"delete from sungtb where idx=?";

		try {
			// 1. Connecton 얻기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt's parameter 채우기
			pstmt.setInt(1, idx);

			// 4. DB SQL 전송
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 닫기 (역순)
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
