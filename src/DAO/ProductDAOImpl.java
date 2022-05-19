package DAO;

import VO.Product;
import VO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProductDAOImpl implements IProductDAO{

    private Connection conn;
    private PreparedStatement pstmt;

    public ProductDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(Product product) throws Exception{
        String sql = "INSERT INTO product(barcode,productName,price,supplyer) " + "VALUES(?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, product.getBarcode());
        this.pstmt.setString(2, product.getProductName());
        this.pstmt.setDouble(3, product.getPrice());
        this.pstmt.setString(4, product.getSupply());
        if (this.pstmt.executeUpdate() > 0) {
            pstmt.close();
            return true;
        } else {
            pstmt.close();
            return false;
        }
    }


    @Override
    public boolean update(Product product) throws Exception {
        String sql = "UPDATE Product SET productName=? ,price=?,supplyer=? WHERE barcode=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, product.getProductName());
        this.pstmt.setDouble(2, product.getPrice());
        this.pstmt.setString(3, product.getSupply());
        this.pstmt.setString(4, product.getBarcode());
        if (this.pstmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String barcode) throws Exception {
        String sql = "DELETE FROM Product WHERE barcode=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, barcode);
        if (this.pstmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Product getById(String barcode) {
        String sql = "SELECT * FROM Product WHERE barcode=?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, barcode);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setSupply(rs.getString("supply"));
                product.setBarcode(rs.getString("barcode"));
                System.out.println("succ");
                return product;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
/*
    @Override
    public List<User> query(User user) throws Exception {
        // 可以后续再实现，但是该方法不能删除，因为实现接口，必须实现接口的所有方法，即使该方法暂时没代码

        return null;
    }
 */

}
