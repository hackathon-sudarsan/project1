import java.sql.*; //Step 1
public class jdbc2
{
    public static void main(String[] args) {
	String urlt="(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = omzgrid114scan.vzbi.com)(PORT = 1800)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME =  NTRUAT)))";
        String url = "jdbc:oracle:thin:"+args[0]+"@"+urlt;
        System.out.println("URL:"+url);
            Connection con; //Step 2
            try
            {
		Class.forName("java.sql.DriverManager");
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection(url); //Step 2a
                System.out.println("Got Connection");
            }
            catch (Exception e)
            { 
               e.printStackTrace();
            }
   }
}

export CLASSPATH=/VZ/opt/oracle/product/10.2.0/jdbc/lib/classes12.jar:/home/v709683

java jdbc2 etl_app/metrix09
java jdbc2 etl_app/metrix09 omzgrid114scan.vzbi.com NTRUAT
