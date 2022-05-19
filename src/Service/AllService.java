package Service;

import DAO.IProductDAO;
import DAO.ISalesDAO;
import DAO.IUserDAO;
import DatabaseConnection.DatabaseConnection;
import Factory.DAOFactory;
import VO.Product;
import VO.SalesRecord;
import VO.User;

import java.util.Scanner;

public class AllService {
    private ProductService productService;
    private RecordService recordService;
    private UserService userService;

    public AllService() {
        productService=new ProductService();
        recordService=new RecordService();
        userService=new UserService();
    }

    public ProductService getProductService() {
        return productService;
    }

    public RecordService getRecordService() {
        return recordService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void cashing() throws Exception {
        Scanner sc=new Scanner(System.in);
        String temp_barcode=null;
        int temp_quantity=0;
        Product product=null;
        SalesRecord salesRecord=null;
        User user=null;

        System.out.println("请输入商品条形码（6位数字字符）");
        temp_barcode=sc.next();
        //TODO:检验
        product = productService.getById(temp_barcode);
        System.out.println("输入商品数量");
        temp_quantity=sc.nextInt();

        salesRecord=new SalesRecord("id",temp_barcode,product.getProductName(), product.getPrice(), temp_quantity,"operator","time");
        recordService.InsertRecord(salesRecord);
        System.out.println("添加成功");
    }





}
