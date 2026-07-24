package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentCRUD {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Connection con = DBConnection.getConnection();

        while (true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                try {

                	System.out.print("Enter Id : ");
                	int id = sc.nextInt();

                	sc.nextLine();

                	System.out.print("Enter Name : ");
                	String name = sc.nextLine();

                	System.out.print("Enter Age : ");
                	int age = sc.nextInt();

                	String sql =
                	"insert into student(s_id,s_name,s_age) values(?,?,?)";

                	PreparedStatement ps = con.prepareStatement(sql);

                	ps.setInt(1, id);
                	ps.setString(2, name);
                	ps.setInt(3, age);

                	int i = ps.executeUpdate();

                	if(i>0)
                	    System.out.println("Record Inserted");
                	
                } catch (Exception e) {
                    System.out.println(e);
                }

                break;

            case 2:

                try {

                    String sql = "select * from student";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ResultSet rs = ps.executeQuery();

                    System.out.println("\nID\tNAME\tAGE");

                    while (rs.next()) {

                        System.out.println(rs.getInt(1) + "\t"
                                + rs.getString(2) + "\t"
                                + rs.getInt(3));

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

                break;

            case 3:

                try {

                	System.out.print("Enter Id : ");
                	int s_id = sc.nextInt();

                	sc.nextLine();

                	System.out.print("Enter New Name : ");
                	String name = sc.nextLine();

                	System.out.print("Enter New Age : ");
                	int age = sc.nextInt();

                	String sql =
                	"update student set s_name=?, s_age=? where s_id=?";

                	PreparedStatement ps = con.prepareStatement(sql);

                	ps.setString(1, name);
                	ps.setInt(2, age);
                	ps.setInt(3, s_id);

                	int i = ps.executeUpdate();

                	if(i>0)
                	    System.out.println("Record Updated");
                	else
                	    System.out.println("Id Not Found");
                	
                } catch (Exception e) {
                    System.out.println(e);
                }

                break;

            case 4:

                try {

                	System.out.print("Enter Id : ");
                	int s_id = sc.nextInt();

                	String sql =
                	"delete from student where s_id=?";

                	PreparedStatement ps = con.prepareStatement(sql);

                	ps.setInt(1, s_id);

                	int i = ps.executeUpdate();

                	if(i>0)
                	    System.out.println("Record Deleted");
                	else
                	    System.out.println("Id Not Found");

                } catch (Exception e) {
                    System.out.println(e);
                }

                break;

            case 5:

                System.out.println("Thank You");
                System.exit(0);

            default:
                System.out.println("Invalid Choice");

                sc.close();
            }

        }

    }

}