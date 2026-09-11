package com.bistroops.reservation.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bistroops.reservationdatetime.model.ReservationDatetimeVO;

public class ReservationDAO implements ReservationDAO_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/project?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "123456";

    private static final String INSERT_STMT =
            "INSERT INTO reservation "
            + "(mem_no, rsv_dt_no, seat_type_no, rsv_create_time, rsv_status, rsv_comment) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String GET_ALL_STMT =
            "SELECT rsv_no, mem_no, rsv_dt_no, seat_type_no, "
            + "rsv_create_time, rsv_status, rsv_comment "
            + "FROM reservation ORDER BY rsv_no";

    private static final String GET_ONE_STMT =
            "SELECT rsv_no, mem_no, rsv_dt_no, seat_type_no, "
            + "rsv_create_time, rsv_status, rsv_comment "
            + "FROM reservation WHERE rsv_no = ?";

    private static final String DELETE =
            "DELETE FROM reservation WHERE rsv_no = ?";

    private static final String UPDATE =
            "UPDATE reservation SET rsv_status=?, rsv_comment=? "
            + "WHERE rsv_no = ?";


    @Override
    public void insert(ReservationVO reservationVO) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setInt(1, reservationVO.getMemNo());

            pstmt.setInt(2,
                    reservationVO.getReservationdatetime().getRsvDtNo());

            pstmt.setInt(3, reservationVO.getSeatTypeNo());

            pstmt.setObject(4, reservationVO.getRsvCreateTime());

            pstmt.setString(5, reservationVO.getRsvStatus());

            pstmt.setString(6, reservationVO.getRsvComment());

            pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(
                    "Couldn't load database driver. " + e.getMessage());

        } catch (SQLException se) {

            throw new RuntimeException(
                    "A database error occured. " + se.getMessage());

        } finally {

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }


    @Override
    public void update(ReservationVO reservationVO) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setString(1, reservationVO.getRsvStatus());

            pstmt.setString(2, reservationVO.getRsvComment());

            pstmt.setInt(3, reservationVO.getRsvNo());

            pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(
                    "Couldn't load database driver. " + e.getMessage());

        } catch (SQLException se) {

            throw new RuntimeException(
                    "A database error occured. " + se.getMessage());

        } finally {

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }


    @Override
    public void delete(Integer rsvNo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, rsvNo);

            pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(
                    "Couldn't load database driver. " + e.getMessage());

        } catch (SQLException se) {

            throw new RuntimeException(
                    "A database error occured. " + se.getMessage());

        } finally {

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }


    @Override
    public ReservationVO findByPrimaryKey(Integer rsvNo) {

        ReservationVO reservationVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, rsvNo);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                reservationVO = new ReservationVO();

                reservationVO.setRsvNo(
                        rs.getInt("rsv_no")
                );

                reservationVO.setMemNo(
                        rs.getInt("mem_no")
                );

                ReservationDatetimeVO reservationdatetimeVO =
                        new ReservationDatetimeVO();

                reservationdatetimeVO.setRsvDtNo(
                        rs.getInt("rsv_dt_no")
                );

                reservationVO.setReservationdatetime(
                        reservationdatetimeVO
                );

                reservationVO.setSeatTypeNo(
                        rs.getInt("seat_type_no")
                );

                reservationVO.setRsvCreateTime(
                        rs.getObject(
                                "rsv_create_time",
                                LocalDateTime.class
                        )
                );

                reservationVO.setRsvStatus(
                        rs.getString("rsv_status")
                );

                reservationVO.setRsvComment(
                        rs.getString("rsv_comment")
                );
            }

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(
                    "Couldn't load database driver. " + e.getMessage());

        } catch (SQLException se) {

            throw new RuntimeException(
                    "A database error occured. " + se.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }

        return reservationVO;
    }


    @Override
    public List<ReservationVO> getAll() {

        List<ReservationVO> list =
                new ArrayList<ReservationVO>();

        ReservationVO reservationVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_STMT);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                reservationVO = new ReservationVO();

                reservationVO.setRsvNo(
                        rs.getInt("rsv_no")
                );

                reservationVO.setMemNo(
                        rs.getInt("mem_no")
                );

                ReservationDatetimeVO reservationdatetimeVO =
                        new ReservationDatetimeVO();

                reservationdatetimeVO.setRsvDtNo(
                        rs.getInt("rsv_dt_no")
                );

                reservationVO.setReservationdatetime(
                        reservationdatetimeVO
                );

                reservationVO.setSeatTypeNo(
                        rs.getInt("seat_type_no")
                );

                reservationVO.setRsvCreateTime(
                        rs.getObject(
                                "rsv_create_time",
                                LocalDateTime.class
                        )
                );

                reservationVO.setRsvStatus(
                        rs.getString("rsv_status")
                );

                reservationVO.setRsvComment(
                        rs.getString("rsv_comment")
                );

                list.add(reservationVO);
            }

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(
                    "Couldn't load database driver. " + e.getMessage());

        } catch (SQLException se) {

            throw new RuntimeException(
                    "A database error occured. " + se.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }

        return list;
    }
}
