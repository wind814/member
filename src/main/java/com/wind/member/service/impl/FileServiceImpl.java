package com.wind.member.service.impl;

import com.wind.member.dao.MovieListMapper;
import com.wind.member.dao.MovieStarMapper;
import com.wind.member.entity.MovieList;
import com.wind.member.entity.MovieStar;
import com.wind.member.exception.FileListNullException;
import com.wind.member.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;
import java.io.File;
import java.text.DecimalFormat;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MovieStarMapper movieStarMapper;

    @Autowired
    private MovieListMapper movieListMapper;


    /**
     * @param starId 指定路径
     * @param path 提供starId 进行定向得新增电影列表
     */
    @Override
    public void addMovieListByStarIdAndPath(Long starId, String path ,String volume) {

        windMovieSingle.debug("addMovieListByStarIdAndPath : path = "+path);

        File file = new File(path);

        String[] fileList = file.list();

        if(fileList==null || fileList.length==0){
            windMovieSingle.debug(new FileListNullException().getMessage());
            throw new FileListNullException();
        }

        Long num = new Long("3221225472");

        try{
            for (String fileName : fileList){

                File movieFile = new File(path+"/"+fileName);

                //现在内嵌文件夹情况，先不处理。
                if(movieFile.isDirectory() || fileName.contains("jpg") || fileName.contains("JPG")){
                    continue;
                }

                System.out.println(movieFile.getName());
                System.out.println(movieFile.length());

                MovieList movieList = movieListMapper.findByNameAndStarId(starId,fileName);

                if(movieList==null){

                    movieList = new MovieList();

                    movieList.setAddress(path);
                    movieList.setFavorite(true);
                    movieList.setFileSize(FormatFileSize(movieFile.length()));
                    movieList.setHighDefinition(false);

                    if(movieFile.length()/num>1){
                        movieList.setHighDefinition(true);
                    }
                    movieList.setStarId(starId);
                    movieList.setIsChinese(false);
                    movieList.setNameCode(fileName);
                    movieList.setVolume(volume);

                    movieListMapper.insert(movieList);
                }
            }
        }catch (Exception e){
            windMovieSingle.debug(e.getMessage());
        }
    }


    /**
     * @param path 根据根目录wind开始读取文件
     *             添加star
     */
    @Override
    public void addMovieStarByPath(String path) {

        File file = new File(path);

        String[] fileList = file.list();

        if(fileList==null || fileList.length==0){
            windMovieSingle.debug(new FileListNullException().getMessage());
            throw new FileListNullException();
        }

        try{
            for(String fileStarName : fileList){
                if(fileStarName.contains("_")){

                    String starName = fileStarName.substring(2);
                    MovieStar movieStar = movieStarMapper.findByStarName(starName);

                    if(movieStar==null){
                        movieStar = new MovieStar(starName,1L,true,0L,0);
                        movieStarMapper.insert(movieStar);
                    }
                }
            }
        }catch (Exception e){
            windMovieSingle.debug(e.getMessage());
        }
    }


    /**
     * @param path 从磁盘根目录wind开始读取得路径
     *             新增star还有当前star得电影信息
    */
    @Override
    public void addMovieStarAndMovieList(String path,String volume) {

        String[] fileList = new File(path).list();

        if(fileList==null || fileList.length==0){
            windMovieSingle.debug(new FileListNullException().getMessage());
            throw new FileListNullException();
        }

        try{
            for(String starName : fileList){

                File starNameFile = new File(path+"/"+starName);

                if(!starNameFile.isDirectory()){
                    continue;
                }

                if(starName.contains("_")){

                    String starRealName = starName.substring(2);
                    MovieStar movieStar = movieStarMapper.findByStarName(starRealName);

                    if(movieStar!=null){
                        continue;
                    }

                    movieStar = new MovieStar(starRealName,1L,true,0L,0);
                    movieStarMapper.insert(movieStar);
                    addMovieListByStarIdAndPath(movieStarMapper.findByStarName(starRealName).getId(),path+"/"+starName,volume);
                }
            }
        }catch (Exception e){
            windMovieSingle.debug(e.getMessage());
        }
    }


    public static String FormatFileSize(long fileS) {// 转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    public static String user = "root";
    public static String password = "CNP_dataplaneapi_01";

    private static String getBasicAuth() {
        //使用base64进行加密
        byte[] tokenByte = Base64.encodeBase64((user+":"+password).getBytes());
        //将加密的信息转换为string
        String tokenStr = new String(tokenByte);
        //Basic YFUDIBGDJHFK78HFJDHF==    token的格式
        return  "Basic "+tokenStr;
    }

    public static void main(String[] args) {
        System.out.println(getBasicAuth());
    }
}
