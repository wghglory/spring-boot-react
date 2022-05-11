package com.guanghui.springbootreact.repository;

import com.guanghui.springbootreact.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(Boolean published);

    List<Tutorial> findByTitleContainingIgnoreCase(String title);

    // JPQL Query, if not using findByDescriptionContaining
//    @Query("select t from Tutorial t where t.description like %?1%")
    // Native Query
    @Query(nativeQuery = true, value = "select * from tutorials where description like %?1%")
    List<Tutorial> getByDescription(String description);

    // Native Named Query
    @Query(nativeQuery = true, value = "select * from tutorials where description like %:description%")
    List<Tutorial> getByDescriptionNativeParam(@Param("description") String description);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update tutorials set description = ?2 where title = ?1")
    Integer updateDescriptionByTitle(String title, String description);
}
