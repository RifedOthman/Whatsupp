package com.rifed.whatsappclone.chat;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ChatMapper {

    public ChatResponse toChatResponse(Chat chat, String senderId) {

        return ChatResponse.builder()
                .id(chat.getId())
                .name(chat.getChatName(senderId))
                .unreadCount(chat.getUnreadMessage(senderId))
                .lastMessage(chat.getLastMessage())
                .isRecipientOnline(chat.getRecipient().isUserOnline())
                .senderId(chat.getSender().getId())
                .receiverId(chat.getRecipient().getId())
                .build() ;
    }

}
