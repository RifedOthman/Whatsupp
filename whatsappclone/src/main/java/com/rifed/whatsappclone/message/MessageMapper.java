package com.rifed.whatsappclone.message;

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

                //read MEDIA FILE LATER
                .build();

    }
}
