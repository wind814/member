package com.wind.member.service.impl;

import com.wind.member.dao.MovieStarMapper;
import com.wind.member.entity.MovieStar;
import com.wind.member.service.MovieStarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieStarServiceImpl implements MovieStarService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MovieStarMapper movieStarMapper;

    @Override
    public List<MovieStar> findAll() {
        return movieStarMapper.selectAll();
    }
}
