package com.berkaybarisalgunblog.springboot.repository;

import com.berkaybarisalgunblog.springboot.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {


}
