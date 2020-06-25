package com.win2020.springredditclone.mapper;

import com.win2020.springredditclone.dto.SubredditDto;
import com.win2020.springredditclone.model.Post;
import com.win2020.springredditclone.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {

    // Maps Subreddit objects to SubredditDto objects
    @Mapping(target = "postCount", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    // Method definition that will take the list of posts and convert it to an integer (returns the size of the list)
    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    // Maps SubredditDto objects to Subreddit objects and creates reverse mappings
    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);
}
