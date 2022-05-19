package Service;

import DAO.IProductDAO;
import DAO.ISalesDAO;
import DAO.ProductDAOImpl;
import DatabaseConnection.DatabaseConnection;
import Factory.DAOFactory;
import VO.Product;
import VO.User;

import java.util.Scanner;

public class ProductService{
    private DatabaseConnection dbc; // 数据库连接类
    private IProductDAO ProductDAO; // 由工厂统一提供的 dao 实现类对象

    public ProductService() {
        dbc=new DatabaseConnection();
        ProductDAO= DAOFactory.getIProductDAOInstance(dbc.getConnection());
    }

    public void ProductService_Close() {dbc.close();}

    public Product getById(String barcode) throws Exception {return ProductDAO.getById(barcode);}

    public void insert() throws Exception {
        Product temp_product=new Product();
        Scanner sc=new Scanner(System.in);
        System.out.println("开始增加product：");
        System.out.println("请输入barcode");
        temp_product.setBarcode(sc.next());
        System.out.println("请输入productName");
        temp_product.setProductName(sc.next());
        System.out.println("请输入price");
        temp_product.setPrice(sc.nextDouble());
        System.out.println("请输入supply");
        temp_product.setSupply(sc.next());
        System.out.println("输入完成");
        if(ProductDAO.insert(temp_product))
            System.out.println("增加成功");
        else
            System.out.println("增加失败");
    }

    public void update() throws Exception {
        Product temp_product=new Product();
        Scanner sc=new Scanner(System.in);
        System.out.println("开始修改product：");
        System.out.println("请输入barcode");
        temp_product.setBarcode(sc.next());
        System.out.println("请输入productName");
        temp_product.setProductName(sc.next());
        System.out.println("请输入price");
        temp_product.setPrice(sc.nextDouble());
        System.out.println("请输入supply");
        temp_product.setSupply(sc.next());
        System.out.println("输入完成");
        if(ProductDAO.update(temp_product))
            System.out.println("修改成功");
        else
            System.out.println("修改失败");
    }

    public void delete() throws Exception {
        Product temp_product=new Product();
        String temp_barcode=null;
        Scanner sc=new Scanner(System.in);

        System.out.println("开始删除product：");
        System.out.println("请输入要删除的propduct的barcode:");
        temp_barcode=sc.next();
        System.out.println("输入完成");

        if(ProductDAO.delete(temp_barcode))
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
    }



}
