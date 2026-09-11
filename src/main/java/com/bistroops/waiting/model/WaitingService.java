package com.bistroops.waiting.model;

import java.util.List;

public class WaitingService {

    private WaitingDAO_interface dao;

    public WaitingService() {
        dao = new WaitingDAO();
    }

    public WaitingVO addWaiting(
            Integer seatTypeNo,
            Integer memberNo,
            String waitingTel,
            String waitingName,
            String waitingComment,
            String waitingStatus,
            java.sql.Time waitingNotifyTime) {

        WaitingVO waitingVO = new WaitingVO();

        return waitingVO;
    }

    public WaitingVO addWaiting(WaitingVO waitingVO) {
        dao.insert(waitingVO);
        return waitingVO;
    }

    public WaitingVO updateWaiting(WaitingVO waitingVO) {
        dao.update(waitingVO);
        return waitingVO;
    }

    public void deleteWaiting(Integer waitingNo) {
        dao.delete(waitingNo);
    }

    public WaitingVO getOneWaiting(Integer waitingNo) {
        return dao.findByPrimaryKey(waitingNo);
    }

    public List<WaitingVO> getAll() {
        return dao.getAll();
    }
}
