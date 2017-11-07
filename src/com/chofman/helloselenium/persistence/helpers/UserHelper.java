package com.chofman.helloselenium.persistence.helpers;

import java.util.List;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chofman.helloselenium.config.PersistenceConfigs;
import com.chofman.helloselenium.config.PersistenceFactory;
import com.chofman.helloselenium.persistence.entities.User;

public class UserHelper {

	public static User getRandomUser() throws Exception {	
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = PersistenceFactory.getInstance().getSessionFactory(PersistenceConfigs.TestLocalSystemData);
			session = sessionFactory.openSession();

			session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> userCriteria = builder.createQuery(User.class);
			Root<User> userCriteriaRoot = userCriteria.from(User.class);
			userCriteria.select(userCriteriaRoot);
			
			List<User> results = session.createQuery(userCriteria).getResultList();
			
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(results.size());
			User address = results.get(index);
			
			session.getTransaction().commit();
			
			return address;
		} catch (Exception e) {			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			session.clear();
			PersistenceFactory.getInstance().close();
		}
	}

}
