package com.win2020.springredditclone.service;

import com.win2020.springredditclone.dto.SubredditDto;
import com.win2020.springredditclone.exceptions.SubredditNotFoundException;
import com.win2020.springredditclone.mapper.SubredditMapper;
import com.win2020.springredditclone.model.Subreddit;
import com.win2020.springredditclone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    // findAll() gives all of the Subreddit objects that were stored in the subredditRepository
    // stream() returns Subreddit objects sequentially
    // map() method which is a Function mapper will create a SubredditDto object for each Subreddit object
    // collect() method has a toList() method as an argument which will store all SubredditDto objects in a list
    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SubredditNotFoundException("Subreddit not found with id -" + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }

    // SubredditRepository only
    // Method that will allow a SubredditDto object to be saved to the SubredditRepository
    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

}
