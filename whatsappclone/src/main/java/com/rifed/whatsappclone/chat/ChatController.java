package com.rifed.whatsappclone.chat;
import com.rifed.whatsappclone.common.StringResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/v1/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<StringResponse> createChat(
            @RequestParam(name = "sender-id") String senderId ,
            @RequestParam(name = "receiver-Id") String receiverId
    ) {
        final String chatId = chatService.createChat(senderId, receiverId);
        StringResponse Response = StringResponse.builder()
                .response(chatId)
                .build();
        return ResponseEntity.ok(Response);
    }

    @GetMapping
    public ResponseEntity<List<ChatResponse>> getChatsByReceiver(Authentication authentication) {
        return ResponseEntity.ok(chatService.getChatsByReceiverId(authentication));
    }
}
