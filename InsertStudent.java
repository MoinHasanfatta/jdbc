package connection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudent {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Connection con = DBConnection.getConnection();

        System.out.print("Enter Student Id : ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age : ");
        int age = sc.nextInt();

        String sql = "insert into student values(?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);

        int i = ps.executeUpdate();

        if(i > 0)
        {
            System.out.println("Record Inserted Successfully");
        }

        con.close();
        sc.close();
    }

}
