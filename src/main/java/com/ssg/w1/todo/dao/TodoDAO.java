package com.ssg.w1.todo.dao;

import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import com.ssg.w1.todo.service.TodoService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lombok.Cleanup;

public class TodoDAO implements TodoService {

  @Override
  public void insert(TodoVO vo) throws Exception {
    String sql = "INSERT INTO tbl_todo (tno, title, dueDate, finished) VALUES(null, ?, ?, ?)";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

    pstmt.setString(1, vo.getTitle());
    pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
    pstmt.setBoolean(3, vo.isFinished());

    pstmt.executeUpdate();
  }

  @Override
  public List<TodoVO> selectAllList() throws Exception {
    String sql = "SELECT * FROM tbl_todo";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    @Cleanup ResultSet rs = pstmt.executeQuery();

    List<TodoVO> list = new ArrayList<>();

    while (rs.next()) {
      TodoVO vo = TodoVO.builder()
          .tno(rs.getLong("tno"))
          .title(rs.getString("title"))
          .dueDate(rs.getDate("dueDate").toLocalDate())
          .finished(rs.getBoolean("finished"))
          .build();
      list.add(vo);
    }

    return list;
  }

  @Override
  public TodoVO selectOne(Long tno) throws Exception {
    String sql = "SELECT * FROM tbl_todo WHERE tno=?";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

    pstmt.setLong(1, tno);

    @Cleanup ResultSet rs = pstmt.executeQuery();
    rs.next();

    TodoVO vo = TodoVO.builder()
        .tno(rs.getLong("tno"))
        .title(rs.getString("title"))
        .dueDate(rs.getDate("dueDate").toLocalDate())
        .finished(rs.getBoolean("finished"))
        .build();

    return vo;
  }

  @Override
  public void deleteOne(Long tno) throws Exception {
    String sql = "DELETE FROM tbl_todo WHERE tno=?";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

    pstmt.setLong(1, tno);

     pstmt.executeUpdate();
  }

  @Override
  public void updateOne(TodoVO vo) throws Exception {
    String sql = "UPDATE tbl_todo SET title=?, dueDate=?, finished=? where tno = ?";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

    pstmt.setString(1, vo.getTitle());
    pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
    pstmt.setBoolean(3, vo.isFinished());
    pstmt.setLong(4, vo.getTno());

    pstmt.executeUpdate();
  }
}
