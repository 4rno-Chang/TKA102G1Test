package com.bistroops.reservationdatetime.model;

import java.time.LocalDateTime;
import java.util.List;


import com.bistroops.reservationdatetime.model.ReservationDatetimeDAO;
import com.bistroops.reservationdatetime.model.ReservationDatetimeVO;

public class ReservationDatetimeService {
	
	private ReservationDatetimeDAO dao;
	
	public ReservationDatetimeService() {
		dao = new ReservationDatetimeDAO();
	}
	
	public List<ReservationDatetimeVO> getAll() {
		return dao.getAll();
	}
	
	public ReservationDatetimeVO getRsvDtNoQuery(Integer rsvDtNo) {
	    return dao.findByPrimaryKey(rsvDtNo);
	}
	
	public void insertReservationdatetime(LocalDateTime rsvDtDatetime) {

		ReservationDatetimeVO rsv = new ReservationDatetimeVO();

		rsv.setRsvDtDatetime(rsvDtDatetime);

		dao.insert(rsv);
	}

	public void updateReservationdatetime(Integer rsvDtNo, LocalDateTime rsvDtDatetime) {
		ReservationDatetimeVO rsv = new ReservationDatetimeVO();
		
		rsv.setRsvDtNo(rsvDtNo);
		rsv.setRsvDtDatetime(rsvDtDatetime);
		
		dao.update(rsv);
	}
	
	public void deleteReservationdatetime(Integer rsvDtNo) {
		dao.delete(rsvDtNo);
	}
	
	
	
	
	
}
