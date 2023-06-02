package knu.soft.safespace.controller;

import knu.soft.safespace.dto.ChatRoomResponseDto;
import knu.soft.safespace.entity.Message;
import knu.soft.safespace.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/safe/chat")
@CrossOrigin
public class ChatController {

    private final ChatService chatService;

    // 채팅 목록 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<ArrayList<ChatRoomResponseDto>> getChatRooms(@PathVariable Long memberId) {
        return ResponseEntity.ok(chatService.getChatRooms(memberId));

    }

    // 특정 채팅방 조회 (채팅 데이터 반환)
    @GetMapping("/rooms/{chatRoomId}")
    public ResponseEntity<ArrayList<Message>> getMessages(@PathVariable Long chatRoomId) {
        return ResponseEntity.ok(chatService.getMessages(chatRoomId));

    }

    // 채팅 보내기
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message){
        return ResponseEntity.ok(chatService.sendMessage(message));
    }
}
