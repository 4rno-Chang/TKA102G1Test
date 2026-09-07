package com.bistroops.orders.model;

import java.util.List;

import org.hibernate.Session;



public class OrdersDAOImpl implements OrdersDAO{

	public void insert(OrdersVO orders) {
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.persist(orders); //新增資料
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}; 
	@Override
	public void update(OrdersVO orders) {
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.merge(orders);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	};
	@Override
	public void delete(Integer ordersNo) {
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			OrdersVO orders= session.find(OrdersVO.class, ordersNo);
			if (orders != null) {
				session.remove(orders);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	};
	@Override
	public OrdersVO findByPrimaryKey(Integer ordersNo) {
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			OrdersVO orders=session.find(OrdersVO.class, ordersNo);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	};
	@Override
	public List<OrdersVO> getAll(){
		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<OrdersVO> list=session.createQuery("From Orders",OrdersVO.class).getResultList();
			session.getTransaction().commit();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}


	
	
	
	
	
	
}
