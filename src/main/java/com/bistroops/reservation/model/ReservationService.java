package com.bistroops.reservation.model;

import java.util.List;

public class ReservationService {

    private ReservationDAO_interface dao;

    public ReservationService() {
        dao = new ReservationDAO();
    }

    public ReservationVO insert(ReservationVO reservationVO) {

        dao.insert(reservationVO);

        return reservationVO;
    }

    public ReservationVO update(ReservationVO reservationVO) {

        dao.update(reservationVO);

        return reservationVO;
    }

    public void delete(Integer rsvNo) {

        dao.delete(rsvNo);
    }

    public ReservationVO getRsvNoQuery(Integer rsvNo) {

        return dao.findByPrimaryKey(rsvNo);
    }

    public List<ReservationVO> getAll() {

        return dao.getAll();
    }
}
