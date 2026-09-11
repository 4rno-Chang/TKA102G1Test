package com.bistroops.reservationdatetime.model;


import java.util.*;



public interface ReservationDatetimeDAO_interface {
	public void insert(ReservationDatetimeVO rsvdtVO);
	public void update(ReservationDatetimeVO rsvdtVO);
	public void delete(Integer rsvDtNo);
	public ReservationDatetimeVO findByPrimaryKey(Integer rsvDtNo);
	public List<ReservationDatetimeVO> getAll();
	
}
