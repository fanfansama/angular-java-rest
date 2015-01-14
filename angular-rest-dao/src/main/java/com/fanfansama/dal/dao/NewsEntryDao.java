package com.fanfansama.dal.dao;

import com.fanfansama.dal.model.NewsEntry;
import com.fanfansama.dal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Definition of a Data Access Object that can perform CRUD Operations 
 * for {@link NewsEntry}s.
 */
@Repository(value = "newsEntryDao")
public interface NewsEntryDao extends JpaRepository<NewsEntry, Long> {

    @Query("SELECT me from NewsEntry me order by date desc")
    List<NewsEntry> findCustom();
    // ... equals ...
  //  List<NewsEntry> findAllOrderByDate(); // tri decroissant


  //  NewsEntry findOneById(Integer matchKey);

    @Repository
    interface UserDao extends JpaRepository<User, Long>
    {
        User findOneByName(String name);
    }
}