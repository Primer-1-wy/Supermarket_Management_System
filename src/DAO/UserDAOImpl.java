package DAO;
import VO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private Connection conn;
    private PreparedStatement pstmt;

    // public

    // 实例化时，给该类提供连接对象
    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(User user) throws Exception {
        String sql = "INSERT INTO user(userName,chrName,password,role) " + "VALUES(?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, user.getUserName());
        this.pstmt.setString(2, user.getChrName());
        this.pstmt.setString(3, user.getPassword());
        this.pstmt.setString(4, user.getRole());
        if (this.pstmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(User user) throws Exception {
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

    @Override
    public boolean delete(String userName) throws Exception {
        String sql = "DELETE FROM user WHERE userName=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, userName);
        if (this.pstmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getById(String userName) {
        String sql = "SELECT userName,chrName,password,role FROM user WHERE userName=?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, userName);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setChrName(rs.getString("chrName"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<User> query(User user) throws Exception {
        // 可以后续再实现，但是该方法不能删除，因为实现接口，必须实现接口的所有方法，即使该方法暂时没代码

        return null;
    }
    /*
    //泛型查找
    public static <T> List<T> Select_All(String sql, Class<T> cls, Object... params) {
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        con=JDBC_class.getConnection();//连接数据库
        PreparedStatement ps=null;
        try {//声明预编译语句ps  和获取多余参数params  参数主要是具体的查询条件
            ps = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }

            res = ps.executeQuery();
            //检索此ResultSet对象的列数、类型和字段
            ResultSetMetaData rsd = res.getMetaData();
            List<T> list = new ArrayList<T>();

            while (res.next()) {//向下读一行
                //泛型实例化
                T t = cls.newInstance();

                for (int i = 0; i < rsd.getColumnCount(); i++) {

                    try {
                        //获取指定列的别名，如果sql语句中没有指定别名，则返回值与getColumnName方法相同
                        String column = rsd.getColumnLabel(i + 1);

                        Object value = res.getObject(column);
                        //通过反射获取变量Field对象
                        Field field = cls.getDeclaredField(getParam(column));
                        //开启允许访问私有变量的权限
                        field.setAccessible(true);
                        //给变量赋值
                        field.set(t, value);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
                list.add(t);
            }
            return list;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        //最后一定要释放资源
        finally {
            JDBC_class.Release(con, sta, res);
        }

    }

     */


}