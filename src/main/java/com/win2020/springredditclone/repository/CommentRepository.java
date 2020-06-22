package com.win2020.springredditclone.repository;

import com.win2020.springredditclone.model.Comment;
import com.win2020.springredditclone.model.Post;
import com.win2020.springredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
