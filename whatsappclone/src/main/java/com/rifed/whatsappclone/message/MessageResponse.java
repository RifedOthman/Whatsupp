package com.rifed.whatsappclone.message;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageResponse {

    private long id ;
    private String content ;
    private MessageType type ;
    private MessageState state ;
    private String senderId ;
    private String receiverId ;
    private LocalDateTime createdAt ;
    private LocalDateTime updatedAt ;
    //byte works well with input outputstream
    private byte[] media ;


}
