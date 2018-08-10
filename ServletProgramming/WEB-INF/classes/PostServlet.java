import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.*;

public class PostServlet extends HttpServlet
{
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
 {
    String user=req.getParameter("uname");
    String occupation=req.getParameter("pass");
    
    PrintWriter pw=res.getWriter();

     pw.println(" Welcome "+user+"");
     pw.println(" Your  occupation is "+occupation+""); 
     
    try {
      File file = new File("file1.json");
      BufferedReader br = new BufferedReader(new FileReader(file));
      String st = "" ;
      String jsonStr = "";
      if ((st = br.readLine()) != null) {
        jsonStr.concat(st);
        String jsonData =st;
        JSONObject mainObj = new JSONObject(st);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("user",user);
        jsonObj.put("occupation",occupation);
        JSONArray jsonArr = new JSONArray();
        jsonArr.put(jsonObj);
        mainObj.accumulate("details",jsonObj);
        pw.println(" writing to file..");
        FileWriter fileWriter = new FileWriter("file1.json");
        fileWriter.write(mainObj.toString());
        fileWriter.flush();
        pw.println(" Successfully copied data to file");
      }
      else{
        JSONObject main = new JSONObject();
        JSONObject obj = new JSONObject();
        obj.put("user",user);
        obj.put("occupation",occupation);
        main.put("details",obj);
        pw.println("writing to file....");
        FileWriter fileW = new FileWriter("file1.json");
        fileW.write(main.toString());
        fileW.flush();
        pw.println(" Successfully written into empty file..");
      }
    }
      catch(Exception e){
        e.printStackTrace();
      }
    }
}
