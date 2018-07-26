import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import org.json.*;
import com.oracle.tools.packager.Log;
import java.util.HashMap;
import java.util.Map;
public class PostServlet extends HttpServlet
{
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
 {
    String user=req.getParameter("uname");
    String password=req.getParameter("pass");
    
    PrintWriter pw=res.getWriter();

     pw.println("\nWelcome "+user+"");

     pw.println("\nYour  Password is "+password+"");
     pw.println("\n");
     pw.println("\nJSON file successfully created. ");

     try{
        
        JSONObject obj = new JSONObject();
        obj.put("user",user);
        obj.put("password",password);

        FileWriter fileWriter = new FileWriter("/Users/sowmpadm/Desktop/TestJSON/"+user+".json",true);
        String filepath = "/Users/sowmpadm/Desktop/TestJSON/"+user+".json";
        fileWriter.write(obj.toString());
        fileWriter.flush();

        pw.println("\nSuccessfully copied data to file");
        pw.println(filepath);
        pw.println("\n");
        pw.println(obj);

    } 
    catch(Exception e){
        e.printStackTrace();
    }  

    }
 
}
