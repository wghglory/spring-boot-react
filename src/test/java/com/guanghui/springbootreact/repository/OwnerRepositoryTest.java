package com.guanghui.springbootreact.repository;

import com.guanghui.springbootreact.entity.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveOwner() {
        ownerRepository.save(Owner.builder().firstName("Hehe").lastName("Wang").build());

        assertThat(ownerRepository.findByFirstName("Hehe").isPresent()).isTrue();
    }

    @Test
    void deleteAllOwners() {
        ownerRepository.save(Owner.builder().firstName("Haoran").lastName("Wang").build());
        ownerRepository.deleteAll();
        assertThat(ownerRepository.count()).isEqualTo(0);
    }
}