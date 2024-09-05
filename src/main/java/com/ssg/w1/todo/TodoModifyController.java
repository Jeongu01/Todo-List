package com.ssg.w1.todo;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import com.ssg.w1.todo.service.TodoService;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {

  TodoService service = new TodoDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("/todo/modify.....get..call");

    Long tno = Long.parseLong(req.getParameter("tno"));

    TodoVO dto = null;
    try {
      dto = service.selectOne(tno);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    req.setAttribute("dto", dto);
    req.getRequestDispatcher("/todo/modify.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("/todo/modify.....post..call");

    TodoVO vo = TodoVO.builder()
        .tno(Long.parseLong(req.getParameter("tno")))
        .title(req.getParameter("title"))
        .dueDate(LocalDate.parse(req.getParameter("dueDate")))
        .finished(req.getParameter("finished") != null)
        .build();
    System.out.println("finished : " + req.getParameter("finished"));

    try {
      service.updateOne(vo);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    resp.sendRedirect("/todo/list");
  }
}
