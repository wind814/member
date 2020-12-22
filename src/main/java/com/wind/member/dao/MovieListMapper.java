package com.wind.member.dao;

import com.wind.member.entity.MovieList;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieListMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MovieList record);

    MovieList selectByPrimaryKey(Long id);

    List<MovieList> selectAll();

    int updateByPrimaryKey(MovieList record);

    MovieList findByNameAndStarId(@Param("starId") Long starId ,@Param("movieName") String movieName);

    List<MovieList> findAllByStarId(@Param("starId") Long starId);

    List<MovieList> findAllByParam(MovieList record);

}