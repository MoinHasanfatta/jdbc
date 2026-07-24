package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayStudent {

    public static void main(String[] args) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "select * from student";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        System.out.println("ID\tNAME\tAGE");

        while (rs.next()) {

            System.out.println(
                    rs.getInt(1) + "\t" +
                    rs.getString(2) + "\t" +
                    rs.getInt(3));

        }

        con.close();
    }
}
