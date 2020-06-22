package com.win2020.springredditclone.repository;

import com.win2020.springredditclone.model.Post;
import com.win2020.springredditclone.model.User;
import com.win2020.springredditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
