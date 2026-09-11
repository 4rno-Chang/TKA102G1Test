package com.bistroops.waiting.model;

import java.sql.Time;

import com.bistroops.seattype.model.SeatTypeVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "waiting")
public class WaitingVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waiting_no")
    private Integer waitingNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_type_no")
    private SeatTypeVO seattype;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "waiting_tel")
    private String waitingTel;

    @Column(name = "waiting_name")
    private String waitingName;

    @Column(name = "waiting_comment")
    private String waitingComment;

    @Column(name = "waiting_status")
    private String waitingStatus;

    @Column(name = "waiting_notify_time")
    private Time waitingNotifyTime;

    public WaitingVO() {
    }

    public WaitingVO(Integer waitingNo, SeatTypeVO seattype, Integer memberNo,
            String waitingTel, String waitingName, String waitingComment,
            String waitingStatus, Time waitingNotifyTime) {
        super();
        this.waitingNo = waitingNo;
        this.seattype = seattype;
        this.memberNo = memberNo;
        this.waitingTel = waitingTel;
        this.waitingName = waitingName;
        this.waitingComment = waitingComment;
        this.waitingStatus = waitingStatus;
        this.waitingNotifyTime = waitingNotifyTime;
    }

    public Integer getWaitingNo() {
        return waitingNo;
    }

    public void setWaitingNo(Integer waitingNo) {
        this.waitingNo = waitingNo;
    }

    public SeatTypeVO getSeattype() {
        return seattype;
    }

    public void setSeattype(SeatTypeVO seattype) {
        this.seattype = seattype;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public String getWaitingTel() {
        return waitingTel;
    }

    public void setWaitingTel(String waitingTel) {
        this.waitingTel = waitingTel;
    }

    public String getWaitingName() {
        return waitingName;
    }

    public void setWaitingName(String waitingName) {
        this.waitingName = waitingName;
    }

    public String getWaitingComment() {
        return waitingComment;
    }

    public void setWaitingComment(String waitingComment) {
        this.waitingComment = waitingComment;
    }

    public String getWaitingStatus() {
        return waitingStatus;
    }

    public void setWaitingStatus(String waitingStatus) {
        this.waitingStatus = waitingStatus;
    }

    public Time getWaitingNotifyTime() {
        return waitingNotifyTime;
    }

    public void setWaitingNotifyTime(Time waitingNotifyTime) {
        this.waitingNotifyTime = waitingNotifyTime;
    }
}
