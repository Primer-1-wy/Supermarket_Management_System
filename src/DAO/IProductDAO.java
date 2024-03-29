package DAO;

import VO.Product;
import VO.User;

import java.util.List;

public interface IProductDAO {    // 增加一条记录
    public boolean insert(Product product) throws Exception;

    // 修改记录
    public boolean update(Product product) throws Exception;

    // 按主键（商品码）删除记录
    public boolean delete(String barcode) throws Exception;

    // 按主键（商品码）查询记录
    public Product getById(String barcode) throws Exception;
    // 查询满足条件的记录：查询条件封装在 user 对象中，若 user 对象的某个成员变量值为 null，则表示查询时忽略该字段查询条件

   // public List<User> query(Product product) throws Exception;
}
