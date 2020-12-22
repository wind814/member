package com.wind.member.controller;

import com.alibaba.fastjson.JSON;
import com.wind.member.entity.MovieList;
import com.wind.member.service.MovieListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/v1/movie/movieList/")
public class MovieListController {

        private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

        @Autowired
        private MovieListService movieListService;

        @RequestMapping(value = "findMovieListByStarId/{starId}" ,method = RequestMethod.GET)
        public String readFileNames(@PathVariable Long starId){

                List<MovieList> list =  movieListService.findAllByStarId(starId);

                if(list==null){
                    return "0";
                }

                windMovieSingle.debug(JSON.toJSONString(list));

                return JSON.toJSONString(list);

        }

        @RequestMapping(value = "findMovieListByParam" ,method = RequestMethod.POST)
        public String readFileNames(MovieList record){

                List<MovieList> list =  movieListService.findAllByParam(record);

                if(list==null){
                        return "0";
                }
                windMovieSingle.debug(JSON.toJSONString(list));
                return JSON.toJSONString(list);
        }

        @RequestMapping(value = "view/{starId}" ,method = RequestMethod.GET)
        public String findMovieListByStarIdView(ModelMap map , @PathVariable("starId") String starId){

                map.put("title","首页");
                map.put("parenttitle","首页");
                map.put("isMsg",true);
                map.put("msgHTML","欢迎进入");
                map.put("isControl",true);
                map.put("isribbon", false);
                map.put("starId", starId);
                return "movie/list";
        }

        @RequestMapping(value = "list/findMovieListByStarId/{starId}" ,method = RequestMethod.POST)
        @ResponseBody
        public String findMovieListByStarId(@PathVariable String starId, ModelMap map){

                List<MovieList> list =  movieListService.findAllByStarId(Long.parseLong(starId));

                if(list==null){
                        return "0";
                }

                windMovieSingle.debug(JSON.toJSONString(list));

                map.put("title","首页");
                map.put("parenttitle","首页");
                map.put("isMsg",true);
                map.put("msgHTML","欢迎进入");
                map.put("isControl",true);
                map.put("isribbon", false);

                return JSON.toJSONString(list);
        }

        @RequestMapping(value = "list/findMovieListByStarId/{volume}/{starId}" ,method = RequestMethod.POST)
        @ResponseBody
        public String findMovieListByStarId(@PathVariable String volume,@PathVariable String starId, ModelMap map){

                MovieList param = new MovieList();
                param.setStarId(Long.parseLong(starId));
                param.setVolume(volume);

                List<MovieList> list =  movieListService.findAllByParam(param);

                if(list==null){
                   return "0";
                }
                windMovieSingle.debug(JSON.toJSONString(list));

                map.put("title","首页");
                map.put("parenttitle","首页");
                map.put("isMsg",true);
                map.put("msgHTML","欢迎进入");
                map.put("isControl",true);
                map.put("isribbon", false);

                return JSON.toJSONString(list);
        }


}
