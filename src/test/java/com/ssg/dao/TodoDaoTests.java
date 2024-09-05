package com.ssg.dao;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TodoDaoTests {

  TodoDAO dao = new TodoDAO();
  @Test
  public void testInsert() throws Exception {
    TodoVO vo = TodoVO.builder()
        .title("Sample Title...")
        .dueDate(LocalDate.of(2024,9,5))
        .build();

    dao.insert(vo);
  }

  @Test
  public void testList() throws Exception {
    List<TodoVO> list = dao.selectAllList();
    list.forEach(vo -> System.out.println(vo));
  }

  @Test
  public void testSelectOne() throws Exception{
    Long tno = 2L;
    TodoVO vo = dao.selectOne(tno);
    System.out.println(vo);

    tno = 1L;
    vo = dao.selectOne(tno);
    System.out.println(vo);
  }

  @Test
  public void testUpdateOne() throws Exception {
    TodoVO voTest = TodoVO.builder().tno(1L).title("UpdateTest....").dueDate(LocalDate.of(2024,9,5)).finished(true).build();
    dao.updateOne(voTest);
  }
}
