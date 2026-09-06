package com.bistroops.announcement.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class AnnouncementDAO implements AnnouncementDAO_interface {
	private SessionFactory factory;

	public AnnouncementDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	private Session getSession() {
        return factory.getCurrentSession();
    }

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

	
	@Override
	public AnnouncementVO findByAnnNo(Integer annNo) {
		return getSession().find(AnnouncementVO.class, annNo);
	}

	@Override
    public List<AnnouncementVO> getAll() {
        return getSession().createQuery("from AnnouncementVO", AnnouncementVO.class)
                .getResultList();
	}
}