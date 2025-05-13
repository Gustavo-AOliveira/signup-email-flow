package com.ms.user.repositories;

import com.ms.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT count(*) FROM TB_USERS WHERE email = :email", nativeQuery = true)
    int findByEmail(@Param("email") String email);

}
