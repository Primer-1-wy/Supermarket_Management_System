package Driver;
import DAO.IUserDAO;
import DatabaseConnection.DatabaseConnection;
import Factory.DAOFactory;
import Service.AllService;
import Service.ProductService;
import VO.Product;
import VO.User;

import java.util.Scanner;

public class Driver {
    static AllService allservice;
    static User user;
    static void DatabaseInitialize() {
        allservice=new AllService();
    }

    public static void main(String[] args)  {
        AllService allService=new AllService();
        ProductService productService = new ProductService();
        try {
            //allService.cashing();
            productService.insert();
            productService.ProductService_Close();
        }catch (Exception e)
        {
            //TODO
            e.printStackTrace();
            System.out.println("异常！！");
        }
    }

    public static void menu() {
        System.out.println("===Store Cashing System===");
        System.out.println("1. Cashing");
        System.out.println("2. Query and Statistics");
        System.out.println("3. Merchandise Maintainance");
        System.out.println("4. Change Password");
        System.out.println("5. Export Data");
        System.out.println("6. Exit");
        System.out.println("\nCashier: " + user.getChrName());

    }


}
