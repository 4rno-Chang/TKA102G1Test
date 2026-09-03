package com.bistroops.announcement.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.bistroops.announcement.model.AnnouncementVO;

public class AnnouncementDAO implements AnnouncementDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String GET_ALL_STMT = "SELECT * FROM announcement";

	/*
	@Override
	public void insert(DeptVO deptVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

	}*/

	/*
	@Override
	public void update(DeptVO deptVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

	}*/

	/*
	@Override
	public void delete(Integer deptno) {
		Connection con = null;
		PreparedStatement pstmt = null;

	}*/

	/*
	@Override
	public DeptVO findByPrimaryKey(Integer deptno) {
		Connection con = null;
		PreparedStatement pstmt = null;

	}*/

	@Override
	public List<AnnouncementVO> getAll() {
		List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
		AnnouncementVO annVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				annVO = new AnnouncementVO();
				
				annVO.setAnnNo(rs.getInt("ann_no"));
				annVO.setAnnTitle(rs.getString("ann_title"));
				annVO.setAnnBegin(rs.getTimestamp("ann_begin").toLocalDateTime());
				annVO.setAnnImg(rs.getBytes("ann_img"));
				annVO.setAnnText(rs.getString("ann_text"));
				list.add(annVO); // Store the row in the list
			}

			// Handle any SQL errors
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