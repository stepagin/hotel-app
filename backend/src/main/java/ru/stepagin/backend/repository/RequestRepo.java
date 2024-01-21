package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import ru.stepagin.backend.entity.RequestEntity;

import java.util.List;

public interface RequestRepo extends JpaRepository<RequestEntity, Long> {
    @Query("select r from RequestEntity r where r.sender.id = ?1 or r.recipient.id = ?1 order by r.date asc")
    List<RequestEntity> getAllPersonRequests(@NonNull Long id);
    
    
}
