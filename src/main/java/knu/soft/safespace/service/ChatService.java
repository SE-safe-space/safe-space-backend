package knu.soft.safespace.service;

import knu.soft.safespace.domain.MemberType;
import knu.soft.safespace.dto.ChatRoomResponseDto;
import knu.soft.safespace.entity.ChatRoom;
import knu.soft.safespace.entity.Member;
import knu.soft.safespace.repository.ChatRoomRepository;
import knu.soft.safespace.repository.MemberRepository;
import knu.soft.safespace.repository.MessageRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static knu.soft.safespace.domain.MemberType.*;

@Getter
@Service
@RequiredArgsConstructor
public class ChatService {

    private final MemberRepository memberRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final MessageRepository messageRepository;

    // id 받고 채팅방 목록 조회 (해당 id가 멤버인지 카운셀러인지 판단해야한다.)
    public ArrayList<ChatRoomResponseDto> getChatRooms(Long id){
        Member m = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("멤버가 없습니다."));

        ArrayList<ChatRoomResponseDto> chatRoomResponseDtos = new ArrayList<>();
        // 만약 멤버라면
        if (m.getType() == MEMBER){
            // 멤버 id로 매칭해서 정보 넘겨준다.
            List<ChatRoom> chatRooms = chatRoomRepository.findByMember_Id(id);

            for (ChatRoom chatRoom : chatRooms) {
                chatRoomResponseDtos.add(ChatRoomResponseDto.builder()
                        .chatRoomId(chatRoom.getId())
                        .name(chatRoom.getMember().getName())
                        .profileImage(chatRoom.getMember().getProfileImage())
                        .build());
            }

            // 만약 상담자라면
        } else{
            // 상담자 id로 매칭해서 정보 넘겨준다.
            
            List<ChatRoom> chatRooms = chatRoomRepository.findByCounselor_Id(id);

            for (ChatRoom chatRoom : chatRooms) {
                chatRoomResponseDtos.add(ChatRoomResponseDto.builder()
                        .chatRoomId(chatRoom.getId())
                        .name(chatRoom.getCounselor().getName())
                        .profileImage(chatRoom.getCounselor().getProfileImage())
                        .build());
            }
            
        }

        return chatRoomResponseDtos;
    }

    // 특정 채팅방 조회시 메세지 데이터 다 줌

    // 특정 채팅방에 채팅 보냄
}
