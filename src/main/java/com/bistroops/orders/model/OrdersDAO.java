package com.bistroops.orders.model;

import java.util.List;

public interface OrdersDAO {
	
	public void insert(OrdersVO orders); 
	public void update(OrdersVO orders);
	public void delete(Integer ordersNo);
	public OrdersVO findByPrimaryKey(Integer ordersNo);
	public List<OrdersVO> getAll();
	
//萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map);

}
