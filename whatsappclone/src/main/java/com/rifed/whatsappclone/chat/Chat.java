package com.rifed.whatsappclone.chat;

import com.rifed.whatsappclone.common.BaseAuditingEntity;
import com.rifed.whatsappclone.message.Message;
import com.rifed.whatsappclone.message.MessageState;
import com.rifed.whatsappclone.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="chat")
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
            if (recipient.getId().equals(senderId)) {
                return sender.getFirstName()+ " " + sender.getLastName();
            }
            return recipient.getFirstName()+ " " + recipient.getLastName();
    }

    @Transient
    public long getUnreadMessage(final String senderId) {
        return messages
                .stream().filter(m -> m.getReceiverId().equals(senderId))
                .filter(m-> MessageState.SENT == m.getState())
                .count();
    }




}
