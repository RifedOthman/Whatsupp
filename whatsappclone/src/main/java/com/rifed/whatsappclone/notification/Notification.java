package com.rifed.whatsappclone.notification;
import com.rifed.whatsappclone.message.MessageType;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {

    private String chatId ;
    private String content ;
    private String senderId ;
    private String receiverId ;
    private String chatName ;
    private MessageType messageType ;
    private NotificationType type ;
    private byte[] media ;

}
