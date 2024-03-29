package DAO;

import VO.SalesRecord;

import java.util.List;

public interface ISalesDAO {
    // 增加一条记录
    public  boolean insert(SalesRecord record) throws Exception;

    // 修改记录
     public boolean update(SalesRecord user) throws Exception;

    // 按主键（流水号）删除记录
    public boolean delete(String t_id) throws Exception;

    // 查询最后一条记录
    public SalesRecord getLastId() throws Exception;
    // 查询满足条件的记录：查询条件封装在 user 对象中，若 user 对象的某个成员变量值为 null，则表示查询时忽略该字段查询条件
    public SalesRecord getById(String transaction_id) throws Exception;

    public List<SalesRecord> query(SalesRecord record) throws Exception;
}
