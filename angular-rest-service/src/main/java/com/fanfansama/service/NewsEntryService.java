package com.fanfansama.service;

import com.fanfansama.dal.model.NewsEntry;

import java.util.List;

/**
 * Created by fanfan on 12/01/2015.
 */
public interface NewsEntryService {


    void delete(Long id);

    NewsEntry save(NewsEntry newsEntry);

    NewsEntry find(Long id);

    List<NewsEntry> findAll();

}
