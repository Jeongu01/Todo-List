package com.ssg.w1.todo.service;

import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface TodoService {

  public void insert(TodoVO vo) throws Exception;

  public List<TodoVO> selectAllList() throws Exception;

  public TodoVO selectOne(Long tno) throws Exception;

  public void deleteOne(Long tno) throws Exception;

  public void updateOne(TodoVO vo) throws Exception;

//  INSTANCE;

  // 글 하나를 등록하는 기능    10개의 TodoDTO (글) 을 만들어서 리스트 객체로 반환
//  public void register(TodoDTO dto) {
//    System.out.println("DEBUG............." + dto);
//  }
//
//  // 등록된 글 목록 반환하는 기능
//  public List<TodoDTO> getList() {
//    List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i -> {
//      TodoDTO dto = new TodoDTO();
//      dto.setTno((long) i);
//      dto.setTitle("Todo...." + i);
//      dto.setDueDate(LocalDate.now());
//      return dto;
//    }).collect(Collectors.toList());
//
//    return todoDTOS;
//  }
//
//  public TodoDTO get(Long tno) {
//    TodoDTO dto = new TodoDTO();
//    dto.setTno(tno);
//    dto.setTitle("Sample Todo");
//    dto.setDueDate(LocalDate.now());
//    dto.setFinished(true);
//
//    return dto;
//  }
}
