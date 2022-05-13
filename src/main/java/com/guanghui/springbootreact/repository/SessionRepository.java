package com.guanghui.springbootreact.repository;

import com.guanghui.springbootreact.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<Session, Long> is the model and its primary key type
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
