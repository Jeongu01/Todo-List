package com.ssg.w1.todo;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import com.ssg.w1.todo.service.TodoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("/todo/list.....call");

    TodoService service = new TodoDAO();
    List<TodoVO> dtoList = null;
    try {
      dtoList = service.selectAllList();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    req.setAttribute("dtoList",dtoList);

    req.getRequestDispatcher("/todo/list.jsp").forward(req,resp);
  }
}
