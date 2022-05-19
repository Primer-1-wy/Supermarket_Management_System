package Service;

import DAO.ISalesDAO;
import DatabaseConnection.DatabaseConnection;
import Factory.DAOFactory;
import VO.Product;
import VO.SalesRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordService {
    private DatabaseConnection dbc; // 数据库连接类
    private ISalesDAO SalesDAO; // 由工厂统一提供的 dao 实现类对象

    public RecordService() {
        this.dbc = new DatabaseConnection(); // 连接数据库
        this.SalesDAO = DAOFactory.getISalesDAOInstance(this.dbc.getConnection());


    }

    public void RecordService_Close()
    {
        dbc.close();
    }


    public void InsertRecord() throws Exception {
        Scanner sc =new Scanner(System.in);
        SalesRecord salesRecord=new SalesRecord();
        System.out.println("开始插入");
        System.out.println("请输入transaction_id");
        salesRecord.setTransaction_id(sc.next());
        System.out.println("请输入barcode");
        salesRecord.setBarcode(sc.next());
        System.out.println("请输入productName");
        salesRecord.setProductName(sc.next());
        System.out.println("请输入price");
        salesRecord.setPrice(sc.nextDouble());
        System.out.println("请输入quantity/count");
        salesRecord.setQuantity(sc.nextInt());
        System.out.println("请输入operator");
        salesRecord.setOperator(sc.next());
        System.out.println("请输入time");
        salesRecord.setTime(sc.next());
        System.out.println("输入完成");

        if(SalesDAO.insert(salesRecord))
            System.out.println("增加成功");
        else
            System.out.println("增加失败");
    }
    public void update() throws Exception {
        Scanner sc =new Scanner(System.in);
        SalesRecord salesRecord=new SalesRecord();
        System.out.println("开始修改");
        System.out.println("请输入transaction_id");
        salesRecord.setTransaction_id(sc.next());
        System.out.println("请输入barcode");
        salesRecord.setBarcode(sc.next());
        System.out.println("请输入productName");
        salesRecord.setProductName(sc.next());
        System.out.println("请输入price");
        salesRecord.setPrice(sc.nextDouble());
        System.out.println("请输入quantity/count");
        salesRecord.setQuantity(sc.nextInt());
        System.out.println("请输入operator");
        salesRecord.setOperator(sc.next());
        System.out.println("请输入time");
        salesRecord.setTime(sc.next());
        System.out.println("修改完成");

        if(SalesDAO.update(salesRecord))
            System.out.println("修改成功");
        else
            System.out.println("修改失败");
    }

    public void delete() throws Exception {
        Scanner sc=new Scanner(System.in);
        String temp_transaction_id=null;
        System.out.println("开始删除record：");
        System.out.println("请输入要删除的record的temp_transaction_id:");
        temp_transaction_id=sc.next();
        System.out.println("输入完成");

        if(SalesDAO.delete(temp_transaction_id))
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
    }

    public void query() throws Exception {
        Scanner sc=new Scanner(System.in);
        String temp_date=null;
        System.out.println("开始查询record：");
        System.out.println("请输入要查询的record的date:");
        temp_date=sc.next();
        System.out.println("输入完成");

        SalesRecord salesRecord =new SalesRecord();
        salesRecord.setTime(temp_date);
        List<SalesRecord> list=SalesDAO.query(salesRecord);
        for (SalesRecord temp:list) {
            System.out.println(temp);
        }
    }

}
