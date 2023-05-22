package knu.soft.safespace.controller;

import knu.soft.safespace.dto.BoardResponseDto;
import knu.soft.safespace.entity.Board;
import knu.soft.safespace.entity.Comment;
import knu.soft.safespace.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/safe/board")
public class BoardController {

    private final BoardService boardService;

    // 글 작성
    @PostMapping("/write")
    public ResponseEntity<String> writing(@RequestBody Board board) {
        return ResponseEntity.ok(boardService.writing(board));
    }

    // 모든 글 조회
    @GetMapping("/view")
    public ResponseEntity<ArrayList<BoardResponseDto>> getBoards() {
        return ResponseEntity.ok(boardService.getBoards());
    }

    // 특정 글 작성
    @GetMapping("/view/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoard(id));
    }

    // 댓글 작성
    @PostMapping("/comment")
    public ResponseEntity<String> writingComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(boardService.writingComment(comment));
    }

    // 댓글 조회
    @GetMapping("/comment/{boardId}")
    public ResponseEntity<ArrayList<Comment>> viewComment(@PathVariable Long boardId){
        return ResponseEntity.ok(boardService.viewComment(boardId));
    }

}
