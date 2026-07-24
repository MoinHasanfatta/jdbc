package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Connection con = DBConnection.getConnection();

        System.out.print("Enter Student Id to Update : ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter New Name : ");
        String name = sc.nextLine();

        System.out.print("Enter New Age : ");
        int age = sc.nextInt();

        String sql = "update student set s_name=?, s_age=? where s_id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, id);

        int i = ps.executeUpdate();

        if(i > 0)
        {
            System.out.println("Record Updated Successfully");
        }
        else
        {
            System.out.println("Student Id Not Found");
        }

        con.close();
        sc.close();
    }
}
