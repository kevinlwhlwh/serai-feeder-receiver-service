package com.kevinlam.serai.repository;

import com.kevinlam.serai.entity.ReceiverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiverRepository extends JpaRepository<ReceiverEntity, String> {
}
