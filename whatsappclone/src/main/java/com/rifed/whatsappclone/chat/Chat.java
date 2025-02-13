package com.rifed.whatsappclone.chat;

import com.rifed.whatsappclone.common.BaseAuditingEntity;
import com.rifed.whatsappclone.message.Message;
import com.rifed.whatsappclone.message.MessageState;
import com.rifed.whatsappclone.message.MessageType;
import com.rifed.whatsappclone.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="chat")

// sender ID is the first one who initialized the chat that's why i wrote THE OR
@NamedQuery(name = ChatConstants.FIND_CHAT_BY_SENDER_ID,
        query="SELECT DISTINCT c FROM Chat c WHERE c.sender.id = :senderId OR c.recipient.id = :senderId ORDER BY createdDate DESC")

@NamedQuery(name = ChatConstants.FIND_CHAT_BY_SENDER_ID_AND_RECEIVER,
            query = "SELECT DISTINCT c FROM Chat c where (c.sender.id = :senderId AND c.recipient = :recipientId ) OR (c.sender.id = :recipientId AND c.recipient = :senderId)")
public class Chat extends BaseAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender ;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User recipient ;

    @OneToMany(mappedBy = "chat" , fetch = FetchType.EAGER)
    @OrderBy("createdDate DESC")
    private List<Message> messages ;

    @Transient
    public String getChatName(final String senderId) {

        // senderId is the one who is currently accesing the chat ,
        // so if it's equal to the sender i should display the recipient vice versa
            if (recipient.getId().equals(senderId)) {
                return sender.getFirstName()+ " " + sender.getLastName();
            }
            return recipient.getFirstName()+ " " + recipient.getLastName();
    }

    @Transient
    public long getUnreadMessage(final String senderId) {
        return messages
                .stream().filter(m -> m.getReceiverId().equals(senderId))
                .filter(m -> MessageState.SENT == m.getState())
                .count();
    }

    @Transient
    public String getLastMessage(){
        if (messages != null && !messages.isEmpty()) {
            if (messages.get(0).getType() != MessageType.TEXT){
                return "Attachement" ;
            }
            return messages.get(0).getContent();
        }
        return null ;
    }


    @Transient
    public LocalDateTime getLastMessageTime(){
        if (messages != null && !messages.isEmpty()) {
            return messages.get(0).getCreatedDate();
        }
        return null ;
    }







}
