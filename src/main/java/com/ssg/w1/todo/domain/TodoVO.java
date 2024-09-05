package com.ssg.w1.todo.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoVO {
  private Long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;
}
