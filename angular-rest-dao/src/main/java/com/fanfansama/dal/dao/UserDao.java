package com.fanfansama.dal.dao;


import com.fanfansama.dal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long>
{
	User findOneByName(String name);
}
