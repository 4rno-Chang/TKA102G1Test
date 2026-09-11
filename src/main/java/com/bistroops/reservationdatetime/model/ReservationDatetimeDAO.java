package com.bistroops.reservationdatetime.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ReservationDatetimeDAO implements ReservationDatetimeDAO_interface{
		
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/project?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";
	
	private static final String INSERT_STMT =
			"INSERT INTO reservation_datetime (rsv_dt_datetime) VALUES (?)";	
	private static final String GET_ALL_STMT = 
			"SELECT rsv_dt_no, rsv_dt_datetime FROM reservation_datetime order by rsv_dt_no";
	private static final String GET_ONE_STMT = 
			"SELECT  rsv_dt_no, rsv_dt_datetime FROM reservation_datetime where rsv_dt_no = ?";
	private static final String DELETE = 
			"DELETE FROM reservation_datetime WHERE rsv_dt_no = ?";
	private static final String UPDATE = 
			"UPDATE reservation_datetime SET rsv_dt_datetime=? where rsv_dt_no = ?";

	@Override
	public void insert(ReservationDatetimeVO rsvdtVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setObject(1, rsvdtVO.getRsvDtDatetime());
				

			pstmt.executeUpdate();
		}catch (ClassNotFoundException e) {
			throw new RuntimeException(
					"Couldn't load database driver. "+ e.getMessage());
		}catch (SQLException se) {
			throw new RuntimeException(
					"A database error occured. "+ se.getMessage());
			
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	@Override
	public void update(ReservationDatetimeVO rsvdtVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setObject(1, rsvdtVO.getRsvDtDatetime());
			pstmt.setInt(2, rsvdtVO.getRsvDtNo());
			

			pstmt.executeUpdate();

			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	
	@Override
	public void delete(Integer rsvDtNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, rsvDtNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	
	@Override
	public ReservationDatetimeVO findByPrimaryKey(Integer rsvDtNo) {

		ReservationDatetimeVO rsvdtVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, rsvDtNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {

	            rsvdtVO = new ReservationDatetimeVO();

	            rsvdtVO.setRsvDtNo(
	                rs.getInt("rsv_dt_no")
	            );

	            rsvdtVO.setRsvDtDatetime(
	                rs.getObject("rsv_dt_datetime", LocalDateTime.class)
	            );
	        }

			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(
					"Couldn't load database driver. "+ e.getMessage());
			
		} catch (SQLException se) {
			throw new RuntimeException(
					"A database error occured. "+ se.getMessage());
		
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return rsvdtVO;
	}
	
	
	@Override
	public List<ReservationDatetimeVO> getAll() {
		List<ReservationDatetimeVO> list = new ArrayList<ReservationDatetimeVO>();
		ReservationDatetimeVO rsvdtVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
			    rsvdtVO = new ReservationDatetimeVO();

			    rsvdtVO.setRsvDtNo(rs.getInt("rsv_dt_no"));

			    rsvdtVO.setRsvDtDatetime(
			        rs.getObject("rsv_dt_datetime", LocalDateTime.class)
			    );

			    list.add(rsvdtVO);
			}

			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	
}
