package com.bistroops.waiting.model;

import java.util.List;

public interface WaitingDAO_interface {

    public void insert(WaitingVO waitingVO);

    public void update(WaitingVO waitingVO);

    public void delete(Integer waitingNo);

    public WaitingVO findByPrimaryKey(Integer waitingNo);

    public List<WaitingVO> getAll();
}

