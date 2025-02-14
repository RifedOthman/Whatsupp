package com.rifed.whatsappclone.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


    @Query(name = UserConstants.FIND_USER_BY_PUBLIC_ID)
    Optional<User> findByPublicId(@Param("publicId") String senderId);

    @Query(name = UserConstants.FIND_USER_BY_EMAIL)
    //passing email parameter which we have in user
    Optional<User> findByEmail(@Param("email") String userEmail);
}
