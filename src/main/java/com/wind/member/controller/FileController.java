package com.wind.member.controller;

import com.wind.member.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/movie/file/")
public class FileController {

        private static final Logger logger = LoggerFactory.getLogger(FileController.class);

        private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

        @Autowired
        private StringRedisTemplate redisTemplate;
        @Autowired
        private FileService fileService;

        /**
         * 针对数据库已经存在star，并且新添加了movie得情况，进行指定地址添加。
         * @param path 任意指定star路径
         * @param starId id
         * @param volume 磁盘名称 A、B、C、D、E
         * @return path
         */
        @RequestMapping(value = "readFileNames" ,method = RequestMethod.POST)
        public String readFileNames(String path,Long starId,String volume){

            fileService.addMovieListByStarIdAndPath(starId,path,volume);
            return path;
        }

        /**
         * 针对wind路径，将包名转换成star存入数据库
         * @param path 指定wind地址
         * @return path
         */
        @RequestMapping(value = "readFileStarNames" ,method = RequestMethod.POST)
        public String readFileStarNames(String path){

                fileService.addMovieStarByPath(path);
                return path;
        }

        /**
         * 针对wind路径，将一层包名转换为star,2层文件转化为movie
         * @param path 指定wind地址
         * @param volume 磁盘名称 A、B、C、D、E
         * @return path
         */
        @RequestMapping(value = "readFileForStarAndList" ,method = RequestMethod.POST)
        public String readFileForStarAndList(String path,String volume){

                windMovieSingle.info("readFileForStarAndList : path = "+ path);
                fileService.addMovieStarAndMovieList(path,volume);
                return path;
        }
}
