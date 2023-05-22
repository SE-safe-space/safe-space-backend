package knu.soft.safespace.service;

import knu.soft.safespace.dto.BoardResponseDto;
import knu.soft.safespace.entity.Board;
import knu.soft.safespace.entity.Comment;
import knu.soft.safespace.repository.BoardRepository;
import knu.soft.safespace.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    // 글 작성
    public String writing(Board board) {
        board.setCreatedAt(LocalDateTime.now());
        boardRepository.save(board);
        return "글 작성 완료!";
    }

    // 모든 글 조회 (내용 빼고)
    public ArrayList<BoardResponseDto> getBoards() {
        List<Board> boardList = boardRepository.findAll();
        ArrayList<BoardResponseDto> boardResponseDtos = new ArrayList<>();

        for (Board board : boardList) {
            boardResponseDtos.add(board.of());
        }

        return boardResponseDtos;
    }

    // 특정 글 조회 (by id)
    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 글은 없습니다"));
        return board;
    }

    // 댓글 작성
    public String writingComment(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return "댓글 작성 완료";
    }

    // 댓글 조회
    public ArrayList<Comment> viewComment(Long boardId) {
        List<Comment> comments = commentRepository.findByBoardId(boardId);
        return (ArrayList<Comment>) comments;
    }
}
