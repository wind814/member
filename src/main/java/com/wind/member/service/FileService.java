package com.wind.member.service;


public interface FileService {

    void addMovieListByStarIdAndPath(Long starId , String path,String volume);

    void addMovieStarByPath(String path);

    void addMovieStarAndMovieList(String path,String volume);

}
