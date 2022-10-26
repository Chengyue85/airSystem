import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Airline")
public class AirLine extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //连接数据库查询所有航班信息
        Connection conn=null;
        Statement ps=null;
        ResultSet rs=null;
        try{
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline1?&useSSL=false&serverTimezone=UTC","root","Ziyue0821");
            //获取预编译的数据库操作对象
            String sqlStr = "select id,inum,icompany,ibegin,iend,imiddle,ischeduledgo,iactualgo,ischeduledarr,iactualarr,iterminal,igate,icheck,istatus from info";
            ps=conn.createStatement();
            //ResultSet
            rs = ps.executeQuery(sqlStr);
            json.append("[");
            while(rs.next()){
                int id=rs.getInt("id");
                String inum=rs.getString("inum");
                String icompany=rs.getString("icompany");
                String ibegin=rs.getString("ibegin");
                String iend=rs.getString("iend");
                String imiddle=rs.getString("imiddle");
                String ischeduledgo=rs.getString("ischeduledgo");
                String iactualgo=rs.getString("iactualgo");
                String ischeduledarr=rs.getString("ischeduledarr");
                String iactualarr=rs.getString("iactualarr");
                String iterminal=rs.getString("iterminal");
                String igate=rs.getString("igate");
                String icheck=rs.getString("icheck");
                String istatus=rs.getString("istatus");

                json.append("{\"id\":\"");
                json.append(id);
                json.append("\",\"inum\":\"");
                json.append(inum);
                json.append("\",\"icompany\":\"");
                json.append(icompany);
                json.append("\",\"ibegin\":\"");
                json.append(ibegin);
                json.append("\",\"iend\":\"");
                json.append(iend);
                json.append("\",\"imiddle\":\"");
                json.append(imiddle);
                json.append("\",\"ischeduledgo\":\"");
                json.append(ischeduledgo);
                json.append("\",\"iactualgo\":\"");
                json.append(iactualgo);
                json.append("\",\"ischeduledarr\":\"");
                json.append(ischeduledarr);
                json.append("\",\"iactualarr\":\"");
                json.append(iactualarr);
                json.append("\",\"iterminal\":\"");
                json.append(iterminal);
                json.append("\",\"igate\":\"");
                json.append(igate);
                json.append("\",\"icheck\":\"");
                json.append(icheck);
                json.append("\",\"istatus\":\"");
                json.append(istatus);
                json.append("\"},");
            }

            jsonStr=json.substring(0,json.length()-1)+"]";

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {

        }
        out.print(jsonStr);

    }

}



