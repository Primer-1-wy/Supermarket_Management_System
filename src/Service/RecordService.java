package Service;

import DAO.ISalesDAO;
import DAO.IUserDAO;
import DatabaseConnection.DatabaseConnection;
import Factory.DAOFactory;
import VO.SalesRecord;

import java.util.Scanner;

public class RecordService {
    private DatabaseConnection dbc; // 数据库连接类
    private ISalesDAO SalesDAO; // 由工厂统一提供的 dao 实现类对象

    public RecordService() {
        this.dbc = new DatabaseConnection(); // 连接数据库
        this.SalesDAO = DAOFactory.getISalesDAOInstance(this.dbc.getConnection());
    } // 从工厂类获取 dao 实现类对象

    /*
    * 收银：输入条形码之后 判断输入是否正确 然后在SalesRecord中增加一条记录
    *
    * */

    /*
    public boolean cashing() throws Exception {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入商品条形码（6位数字字符）");
        String temp_barcode=sc.next();
        while(temp_barcode.length()!=6)
        {
            System.out.println("条形码输入格式不正确请重新输入");
            temp_barcode=sc.next();
        }
        if(SalesDAO.getById(temp_barcode)==null)
        {
            System.out.println("您输入的商品条形码不存在，请确认后重新输入");
        }
        return false;
    }

*/
    public boolean InsertRecord(SalesRecord record) throws Exception {
        return SalesDAO.insert(record);
    }


}
