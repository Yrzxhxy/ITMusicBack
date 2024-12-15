package com.javaclimb.itmusic.service;

import java.util.List;

public interface CollectionService {

    void addSongTO(Integer userId, Integer songId);

    void addSongListTO(Integer userId, Integer songListId);

   List<?> getCollect(Integer type, Integer userId);
}
