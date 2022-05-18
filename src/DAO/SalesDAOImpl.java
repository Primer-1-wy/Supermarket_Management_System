package DAO;

import VO.SalesRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SalesDAOImpl {
    private Connection conn;
    private PreparedStatement pstmt;

    public SalesDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(SalesRecord record) throws Exception {
        String sql = "INSERT INTO salesrecord(userName,chrName,password,role) " + "VALUES(?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, user.getUserName());
        this.pstmt.setString(2, user.getChrName());
        this.pstmt.setString(3, user.getPassword());
        this.pstmt.setString(4, user.getRole());
        if (this.pstmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
