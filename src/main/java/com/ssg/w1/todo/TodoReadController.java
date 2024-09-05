package com.ssg.w1.todo;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import com.ssg.w1.todo.service.TodoService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("todo/read.....실행");

    // todo/read?tno=123
    Long tno = Long.parseLong(req.getParameter("tno"));

    TodoService service = new TodoDAO();
    TodoVO dto = null;
    try {
      dto = service.selectOne(tno);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    req.setAttribute("dto", dto);
    req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
  }
}
