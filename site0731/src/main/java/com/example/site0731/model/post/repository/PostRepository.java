package com.example.site0731.model.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.example.site0731.model.post.entity.PostEntity;


public interface PostRepository extends JpaRepository<PostEntity, Long>{
 
    // @Query(value = "select * from post where title = ? ", nativeQuery = true)
    // void post

    Optional<PostEntity> findByIdx(Long idx);

    List<PostEntity> findByTitle(String title);

    List<PostEntity> findByContent(String content);

    // List<PostEntity> findByUserIdx(Long UserIdx);

    List<PostEntity> findByTitleOrContent(String title, String content);

    List<PostEntity> findByTitleContainingOrContentContaining(String title, String content);
}
