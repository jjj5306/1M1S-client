package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curriculum {
    private Long id;
    private String name;
    private Interest interest;
    private Integer level;
}
