package com.win2020.springredditclone.repository;

import com.win2020.springredditclone.model.Post;
import com.win2020.springredditclone.model.Subreddit;
import com.win2020.springredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
