package com.wind.member.service.impl;

import com.wind.member.dao.MovieListMapper;
import com.wind.member.dao.MovieStarMapper;
import com.wind.member.entity.MovieList;
import com.wind.member.service.MovieListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieListServiceImpl implements MovieListService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MovieStarMapper movieStarMapper;

    @Autowired
    private MovieListMapper movieListMapper;


    @Override
    public List<MovieList> findAllByStarId(Long starId) {

        return movieListMapper.findAllByStarId(starId);
    }

    @Override
    public List<MovieList> findAllByParam(MovieList record) {
        return movieListMapper.findAllByParam(record);
    }
}
