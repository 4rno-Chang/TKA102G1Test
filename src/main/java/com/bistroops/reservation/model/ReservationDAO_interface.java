package com.bistroops.reservation.model;

import java.util.List;

public interface ReservationDAO_interface {

    public void insert(ReservationVO reservationVO);

    public void update(ReservationVO reservationVO);

    public void delete(Integer rsvNo);

    public ReservationVO findByPrimaryKey(Integer rsvNo);

    public List<ReservationVO> getAll();

}
