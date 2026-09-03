package com.bistroops.orders.model;

import java.util.List;

public interface OrdersDAO {
	public void insert(); 
	public void update();
	public void delete();
	public OrdersVO findByPrimaryKey();
	public List<OrdersVO> getAll();
	
	

}
