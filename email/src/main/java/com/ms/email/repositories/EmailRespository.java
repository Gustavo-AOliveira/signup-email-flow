package com.ms.email.repositories;

import com.ms.email.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRespository extends JpaRepository<Email, UUID> {

}
