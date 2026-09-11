package com.bistroops.waiting.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.bistroops.seattype.model.SeatTypeVO;



public class WaitingDAO implements WaitingDAO_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/project?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "123456";

    private static final String INSERT_STMT =
            "INSERT INTO waiting "
            + "(seat_type_no, member_no, waiting_tel, waiting_name, "
            + "waiting_comment, waiting_status, waiting_notify_time) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_ALL_STMT =
            "SELECT waiting_no, seat_type_no, member_no, waiting_tel, "
            + "waiting_name, waiting_comment, waiting_status, waiting_notify_time "
            + "FROM waiting ORDER BY waiting_no";

    private static final String GET_ONE_STMT =
            "SELECT waiting_no, seat_type_no, member_no, waiting_tel, "
            + "waiting_name, waiting_comment, waiting_status, waiting_notify_time "
            + "FROM waiting WHERE waiting_no = ?";

    private static final String DELETE_STMT =
            "DELETE FROM waiting WHERE waiting_no = ?";

    private static final String UPDATE_STMT =
            "UPDATE waiting SET "
            + "seat_type_no = ?, "
            + "member_no = ?, "
            + "waiting_tel = ?, "
            + "waiting_name = ?, "
            + "waiting_comment = ?, "
            + "waiting_status = ?, "
            + "waiting_notify_time = ? "
            + "WHERE waiting_no = ?";

    @Override
    public void insert(WaitingVO waitingVO) {

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {

            pstmt.setInt(1, Integer.parseInt(waitingVO.getSeattype().getSeatTypeNo()));
        	
            if (waitingVO.getMemberNo() != null) {
                pstmt.setInt(2, waitingVO.getMemberNo());
            } else {
                pstmt.setNull(2, java.sql.Types.INTEGER);
            }

            pstmt.setString(3, waitingVO.getWaitingTel());
            pstmt.setString(4, waitingVO.getWaitingName());
            pstmt.setString(5, waitingVO.getWaitingComment());
            pstmt.setString(6, waitingVO.getWaitingStatus());

            if (waitingVO.getWaitingNotifyTime() != null) {
                pstmt.setTime(7, waitingVO.getWaitingNotifyTime());
            } else {
                pstmt.setNull(7, java.sql.Types.TIME);
            }

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("A database error occured. " + e.getMessage());
        }
    }

    @Override
    public void update(WaitingVO waitingVO) {

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement pstmt = con.prepareStatement(UPDATE_STMT)) {

            pstmt.setInt(1, Integer.parseInt(waitingVO.getSeattype().getSeatTypeNo()));

            if (waitingVO.getMemberNo() != null) {
                pstmt.setInt(2, waitingVO.getMemberNo());
            } else {
                pstmt.setNull(2, java.sql.Types.INTEGER);
            }

            pstmt.setString(3, waitingVO.getWaitingTel());
            pstmt.setString(4, waitingVO.getWaitingName());
            pstmt.setString(5, waitingVO.getWaitingComment());
            pstmt.setString(6, waitingVO.getWaitingStatus());

            if (waitingVO.getWaitingNotifyTime() != null) {
                pstmt.setTime(7, waitingVO.getWaitingNotifyTime());
            } else {
                pstmt.setNull(7, java.sql.Types.TIME);
            }

            pstmt.setInt(8, waitingVO.getWaitingNo());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("A database error occured. " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer waitingNo) {

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement pstmt = con.prepareStatement(DELETE_STMT)) {

            pstmt.setInt(1, waitingNo);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("A database error occured. " + e.getMessage());
        }
    }

    @Override
    public WaitingVO findByPrimaryKey(Integer waitingNo) {

        WaitingVO waitingVO = null;

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {

            pstmt.setInt(1, waitingNo);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {

                    waitingVO = new WaitingVO();

                    waitingVO.setWaitingNo(rs.getInt("waiting_no"));

                    String seatTypeNo = rs.getString("seat_type_no");

                    SeatTypeVO seattypeVO = new SeatTypeVO();
                    seattypeVO.setSeatTypeNo(seatTypeNo);
                    waitingVO.setSeattype(seattypeVO);

                    int memberNo = rs.getInt("member_no");

                    if (rs.wasNull()) {
                        waitingVO.setMemberNo(null);
                    } else {
                        waitingVO.setMemberNo(memberNo);
                    }

                    waitingVO.setWaitingTel(rs.getString("waiting_tel"));
                    waitingVO.setWaitingName(rs.getString("waiting_name"));
                    waitingVO.setWaitingComment(rs.getString("waiting_comment"));
                    waitingVO.setWaitingStatus(rs.getString("waiting_status"));

                    Time waitingNotifyTime =
                            rs.getTime("waiting_notify_time");

                    waitingVO.setWaitingNotifyTime(waitingNotifyTime);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("A database error occured. " + e.getMessage());
        }

        return waitingVO;
    }

    @Override
    public List<WaitingVO> getAll() {

        List<WaitingVO> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                WaitingVO waitingVO = new WaitingVO();

                waitingVO.setWaitingNo(rs.getInt("waiting_no"));

                String seatTypeNo = rs.getString("seat_type_no");

                SeatTypeVO seattypeVO = new SeatTypeVO();
                seattypeVO.setSeatTypeNo(seatTypeNo);
                waitingVO.setSeattype(seattypeVO);

                int memberNo = rs.getInt("member_no");

                if (rs.wasNull()) {
                    waitingVO.setMemberNo(null);
                } else {
                    waitingVO.setMemberNo(memberNo);
                }

                waitingVO.setWaitingTel(rs.getString("waiting_tel"));
                waitingVO.setWaitingName(rs.getString("waiting_name"));
                waitingVO.setWaitingComment(rs.getString("waiting_comment"));
                waitingVO.setWaitingStatus(rs.getString("waiting_status"));

                Time waitingNotifyTime =
                        rs.getTime("waiting_notify_time");

                waitingVO.setWaitingNotifyTime(waitingNotifyTime);

                list.add(waitingVO);
            }

        } catch (SQLException e) {
            throw new RuntimeException("A database error occured. " + e.getMessage());
        }

        return list;
    }
}
