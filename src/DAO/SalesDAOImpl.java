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
        String sql = "INSERT INTO salesrecord(transaction_id,barcode,productName,price,quantity,operator,time) " + "VALUES(?,?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, record.getTransaction_id());
        this.pstmt.setString(2, record.getBarcode());
        this.pstmt.setString(3, record.getProductName());
        this.pstmt.setDouble(4, record.getPrice());
        this.pstmt.setInt(5, record.getQuantity());
        this.pstmt.setString(6, record.getOperator());
        this.pstmt.setString(7, record.getTime());
        if (this.pstmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
