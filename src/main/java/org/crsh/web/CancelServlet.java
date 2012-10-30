package org.crsh.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
@WebServlet(urlPatterns = "/cancel")
public class CancelServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String id = req.getParameter("id");
    System.out.println("NEED TO CANCEL " + id);
    if (id != null) {

      Connection conn = ProcessServlet.connections.get(id);
      if (conn != null) {
        ProcessContext context = conn.current;
        if (context != null) {
          context.cancel();
        }
      }
    }

/*
    HttpSession session = req.getSession();
    SerializableTransient<CommandExecution> execution =
       ((SerializableTransient<CommandExecution>)session.getAttribute("execution"));
    if (execution != null)
    {
      execution.object.cancel();
    }
*/
  }
}
