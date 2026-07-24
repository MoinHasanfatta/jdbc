package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Connection con = DBConnection.getConnection();

        System.out.print("Enter Student Id to Delete : ");
        int id = sc.nextInt();

        String sql = "delete from student where s_id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int i = ps.executeUpdate();

        if(i > 0)
        {
            System.out.println("Record Deleted Successfully");
        }
        else
        {
            System.out.println("Student Id Not Found");
        }

        con.close();
        sc.close();
    }
}