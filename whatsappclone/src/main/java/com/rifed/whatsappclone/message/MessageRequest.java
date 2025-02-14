package com.rifed.whatsappclone.message;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageRequest {

    private String content ;
    private String senderId ;
    private String receiverId ;
    private MessageType Type ;
    private String chatId ;

}
