package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVo;

public class TestDao {

	//Single-ton : 객체1개만 생성해서 서비스하자
	static TestDao single = null;

	public static TestDao getInstance() {
		if (single == null)
			single = new TestDao();
		return single;
	}
	
	public List<SungVo> selectList() {

		List<SungVo> list = new ArrayList<SungVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement(명령처리객체) 얻기 
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter설정

			//4.ResultSet(결과행처리객체) 얻어
			rs = pstmt.executeQuery();

			//5.전체레코드 읽어오기
			while (rs.next()) {
				//1건의 데이터(레코드)를 담을 객체  
				SungVo vo = new SungVo();

				//현재레코드->Vo포장
                vo.setIdx(rs.getInt("idx")); 
				//리스트 추가
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			try {
				//닫기(열린역순)
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
