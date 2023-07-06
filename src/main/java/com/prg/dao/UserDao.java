package com.prg.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.prg.dto.User;

public class UserDao 
{
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
EntityManager manager=factory.createEntityManager();
EntityTransaction transaction=manager.getTransaction();

public boolean signup(User user)
{
	transaction.begin();
	manager.persist(user);
	transaction.commit();
	
	return true;
}

public User login(long mobile)
{
	List<User> list=manager.createQuery("select x from User x where mobile=?1").setParameter(1, mobile).getResultList();
	if(list.isEmpty())
	{
		return null;
	}
	else {
	return list.get(0);
	}
}

public User login(String email)
{
	List<User> list=manager.createQuery("select x from User x where email=?1").setParameter(1, email).getResultList();
	if(list.isEmpty())
	{
		return null;
	}
	else {
	return list.get(0);
	}
}

public List<User> fetchAll() {
	return manager.createQuery("select x from User x").getResultList();
}

public void delete(int id)
{
	transaction.begin();
	manager.remove(find(id));
	transaction.commit();
}

public User find(int id)
{
	return manager.find(User.class, id);
}

public void update(User user) {
	transaction.begin();
	manager.merge(user);
	transaction.commit();
}
}
