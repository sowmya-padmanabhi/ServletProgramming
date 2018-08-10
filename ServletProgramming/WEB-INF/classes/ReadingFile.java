import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
 
public class ReadingFile extends HttpServlet { 
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
 

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out. println("<html>");
        out.println("<head><title>Contents of JSON File</title></head>");
        out.println("<body><h3>Contents of JSON File</h3>");

        try {
            File file = new File("Data.json");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st = "" ;
            if ((st = br.readLine()) != null) {
                out.println(st);
            }
            else{
                out.println("File is empty.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
}
}


   