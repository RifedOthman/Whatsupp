package com.rifed.whatsappclone.message;

import com.rifed.whatsappclone.file.FileUtils;
import org.springframework.stereotype.Service;

@Service
public class MessageMapper {
    //converts an obj msg to MessageResponse
    public MessageResponse toMessageResponse(Message message) {
        return MessageResponse.builder()
                .id(message.getId())
                .content(message.getContent())
                .senderId(message.getSenderId())
                .receiverId(message.getReceiverId())
                .type(message.getType())
                .state(message.getState())
                .createdAt(message.getCreatedDate())
                .media(FileUtils.readFileFromLocation(message.getMediaFilePath()))
                .build();

    }
}
