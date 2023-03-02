package com.berkaybarisalgunblog.springboot.repository;

import com.berkaybarisalgunblog.springboot.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {//we declared Long because our id value is long

    Optional<Post> findByUrl(String url);
}
