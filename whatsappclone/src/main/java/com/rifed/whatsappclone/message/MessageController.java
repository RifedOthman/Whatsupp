package com.rifed.whatsappclone.message;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor

public class MessageController {

    private final MessageService messageService;

    @PostMapping
    @ResponseStatus
    public void saveMessage(@RequestBody MessageRequest message){
        messageService.saveMessage(message);
    }

    @PostMapping(value = "/uploadMedia", consumes= "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    private void uploadMedia(@RequestParam("chat-id") String chatId,
                             @RequestParam("file") MultipartFile file,
                             Authentication authentication )
    {
        messageService.uploadMediaMessage(chatId, file, authentication);
    }

    @PatchMapping
    @ResponseStatus
    public void setMessageToSeen(@RequestParam("chat-id") String chatId,
                                 Authentication authentication ) {
        messageService.setMessagesToSeen(chatId, authentication);

    }

    @GetMapping("/chat/{chat-id}")
    public ResponseEntity<List<MessageResponse>> getMessages (@PathVariable("chat-id") String chatId)
    {
        return ResponseEntity.ok(messageService.findChatMessages(chatId));
    }

}
