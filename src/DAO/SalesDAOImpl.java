package DAO;

import VO.SalesRecord;
import VO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SalesDAOImpl implements ISalesDAO{
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
    /*
    @Override
    public boolean update(SalesRecord record) throws Exception {
        String sql = "UPDATE user SET chrName=? ,password=?,role=? WHERE userName=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, user.getChrName());
        this.pstmt.setString(2, user.getPassword());
        this.pstmt.setString(3, user.getRole());
        this.pstmt.setString(4, user.getUserName());
        if (this.pstmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
     */
    @Override
    public boolean delete(String productName) throws Exception {
        String sql = "DELETE FROM salesrecord WHERE productName=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, productName);
        if (this.pstmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public SalesRecord getLastId() throws Exception {
        return null;
    }


    public SalesRecord getById(String transaction_id) {
        String sql = "SELECT * FROM salesrecord WHERE transaction_id=?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, transaction_id);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                SalesRecord record = new SalesRecord();
                record.setTransaction_id(rs.getString("transaction_id"));
                record.setBarcode(rs.getString("barcode"));
                record.setProductName(rs.getString("productName"));
                record.setPrice(rs.getDouble("price"));
                record.setQuantity(rs.getInt("quantity"));
                record.setOperator(rs.getString("operator"));
                record.setTime(rs.getString("time"));
                return record;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public List<SalesRecord> query(SalesRecord record) throws Exception
    {
        List<SalesRecord> result;

        //TODO:..
        return null;
    }


}
