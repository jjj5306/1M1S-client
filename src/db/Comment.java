package db;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {
    private Long id;
    private Post post;
    private String content;
    private Member member;
    private LocalDateTime writingDate;
}
