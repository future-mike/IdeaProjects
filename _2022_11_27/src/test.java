import java.sql.*;

public class test {

    static void insert(Connection con) throws SQLException {
        Statement statement=con.createStatement();
        for(i=1:)

    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 使用我自己的数据库 test
        String url = "jdbc:mysql://localhost:3306/database1";

        // 数据库的用户名和密码
        String username = "root";
        String password = "123456";


        Connection connection = DriverManager.getConnection(url, username, password);


        Statement statement = connection.createStatement();

        // SQL语句，使用我自己的test数据库下的 boss 表
        String sql = "SELECT * FROM boss";

        ResultSet resultSet = statement.executeQuery(sql);

        // 需要与自己的数据库里的表结构相对应
        while (resultSet.next()){
            System.out.println("id = " + resultSet.getObject("id"));
            System.out.println("name = " + resultSet.getObject("name"));
            System.out.println("age = " + resultSet.getObject("age"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}