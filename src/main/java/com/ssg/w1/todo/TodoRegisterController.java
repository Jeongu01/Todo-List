package com.ssg.w1.todo;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.service.TodoService;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

  TodoService service = new TodoDAO();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("입력화면 register.jsp 으로 GET");
    RequestDispatcher dispatcher = req.getRequestDispatcher("/todo/register.jsp");
    dispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    TodoVO vo = TodoVO.builder()
        .title(req.getParameter("title"))
        .dueDate(LocalDate.parse(req.getParameter("date")))
        .finished(Boolean.parseBoolean(req.getParameter("finished")))
        .build();

    try {
      service.insert(vo);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    System.out.println("입력을 처리하고 목록 페이지 이동");
    resp.sendRedirect("/todo/list");
  }
}
