package com.rifed.whatsappclone.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserResponse {

    private String id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private LocalDateTime lastSeen ;
    private boolean isOnline ;
}
