package com.berkaybarisalgunblog.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // in here i am basically initilazing a prime key to my database and i auto generate it with @generatedValue annotation.
    private Long id;//Blog post id
    @Column(nullable = false) // this makes title a table column and prevent it from being null
    private String title;//Blog post title

    private String url;//Blog post url

    @Lob
    @Column(nullable = false, columnDefinition = "longtext")// this makes content a table column and prevent it from being null
    private String content;//Blog post content
    private String shortDescription;//Blog post short descriptipn
    @CreationTimestamp//in here we create a time base
    private LocalDateTime createdOn;//blog Post creation date
    @UpdateTimestamp//and this is changing the "time base"
    private LocalDateTime updatedOn;//blog Post update date
}
