package com.rifed.whatsappclone.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(name= MessageConstants.FIND_MESSAGES_BY_CHAT_ID)
    List<Message> findMessagesByChatId(String chatId);
}
