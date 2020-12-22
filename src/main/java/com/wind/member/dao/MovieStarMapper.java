package com.wind.member.dao;

import com.wind.member.entity.MovieStar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieStarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieStar record);

    MovieStar selectByPrimaryKey(Long id);

    List<MovieStar> selectAll();

    int updateByPrimaryKey(MovieStar record);

    MovieStar findByStarName(String starName);


}