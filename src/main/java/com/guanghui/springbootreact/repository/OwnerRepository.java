package com.guanghui.springbootreact.repository;

import com.guanghui.springbootreact.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByFirstName(String firstName);

}
