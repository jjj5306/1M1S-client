package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurriculumSchedule {
    private Long id;
    private Curriculum curriculum;
    private String content;
    private Interest interest;
}
