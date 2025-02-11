package com.rifed.whatsappclone.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.rifed.whatsappclone.chat.Chat;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="users")

public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime lastSeen;
    private static final long LAST_ACTIVE_INTERVAL = 5  ;

    @OneToMany(mappedBy = "sender")
    private List<Chat> chatAsSender ;

    @OneToMany(mappedBy = "recipient")
    private List<Chat> chatAsRecipient ;

    @Transient
    public boolean isUserOnline() {
        return lastSeen != null && lastSeen.isBefore(LocalDateTime.now().minusMinutes(LAST_ACTIVE_INTERVAL));

    }
}
