package com.ssg.w1.todo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoDTO {

  private Long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;

}
