package com.fanfansama.service.impl;

import com.fanfansama.dal.dao.NewsEntryDao;
import com.fanfansama.dal.model.NewsEntry;
import com.fanfansama.service.NewsEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by fanfan on 12/01/2015.
 */
@Transactional
@Service(value = "newsEntryService")
public class NewsEntryServiceImpl implements NewsEntryService {
    //@Transactional(readOnly = true)

    @Autowired
    private NewsEntryDao newsEntryDao;

    @Override
    public void delete(Long id) {
        newsEntryDao.delete(id);
    }

    @Override
    public NewsEntry save(NewsEntry newsEntry) {
        return newsEntryDao.save(newsEntry);
    }

    @Override
    public NewsEntry find(Long id) {
        return newsEntryDao.findOne(id);
    }

    @Override
    public List<NewsEntry> findAll() {
        return newsEntryDao.findCustom();
    }
}
