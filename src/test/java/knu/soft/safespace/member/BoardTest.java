package knu.soft.safespace.member;

import knu.soft.safespace.entity.Board;
import knu.soft.safespace.entity.Comment;
import knu.soft.safespace.repository.BoardRepository;
import knu.soft.safespace.repository.CommentRepository;
import knu.soft.safespace.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Slf4j
@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("글 작성 테스트")
    @Test
    void 글_작성_테스트(){
        boardService.writing(Board.builder()
                .hide(0)
                .text("내용입니다.")
                .title("제목입니다.")
                .writer("작성자")
                .type("고민고민")
                .build());

        List<Board> all = boardRepository.findAll();
        assertThat(all.size()).isEqualTo(1);

    }

    @DisplayName("댓글 작성 테스트")
    @Test
    void 댓글_작성_테스트() {
        boardService.writingComment(Comment.builder()
                .boardId(1L)
                .name("댓글 작성자")
                .text("댓글 내용")
                .build());

        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }


}
