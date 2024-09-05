package com.ssg.w1.todo;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.service.TodoService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoRemoveController", urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {

  TodoService service = new TodoDAO();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("/todo/remove.....call");

    try {
      service.deleteOne(Long.parseLong(req.getParameter("tno")));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    resp.sendRedirect("/todo/list");
  }
}
