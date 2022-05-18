package Service;

import DAO.IProductDAO;
import DAO.ISalesDAO;
import DAO.ProductDAOImpl;
import DatabaseConnection.DatabaseConnection;
import Factory.DAOFactory;

public class ProductService{
    private DatabaseConnection dbc; // 数据库连接类
    private IProductDAO ProductDAO; // 由工厂统一提供的 dao 实现类对象

    public ProductService() {
        dbc=new DatabaseConnection();
        ProductDAO= DAOFactory.getIProductDAOInstance(dbc.getConnection());
    }

}
