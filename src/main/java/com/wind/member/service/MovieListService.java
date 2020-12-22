package com.wind.member.service;

import com.wind.member.entity.MovieList;

import java.util.List;

public interface MovieListService {

    List<MovieList> findAllByStarId(Long starId);

    List<MovieList> findAllByParam(MovieList record);

}
