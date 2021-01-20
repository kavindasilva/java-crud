package com.example.user;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AppUserDAOImpl implements AppUserDAO{
        @Autowired
        private SessionFactory sessionFactory;

        public void save(AppUser newUser){
                Session session = this.sessionFactory.getCurrentSession();
                session.save(newUser);
        }

        public void updateUser(AppUser p){
                System.out.println("AppUser update");
        }

        public List<AppUser> findAll(){
                CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
                CriteriaQuery<AppUser> criteria = builder.createQuery(AppUser.class);
                criteria.from(AppUser.class);
               return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        }

        public AppUser getUserById(int id){
                System.out.println("AppUser getpersonbyid");
                return this.sessionFactory.getCurrentSession().load(AppUser.class, id);
        }

        public AppUser findByName(String name){
                Session session = this.sessionFactory.getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<AppUser> criteria = builder.createQuery(AppUser.class);
                Root<AppUser> userRoot = criteria.from(AppUser.class);
                criteria
                        .select(userRoot)
                        .where(builder.equal(userRoot.get("name"), name ));
                try {
                        return session.createQuery(criteria).getSingleResult();
                }catch (NoResultException e){
                        return null;
                }
        }

        // @TODO: implement safe delete
        public void deleteUser(int id){
                System.out.println("AppUser remove");
        }
}
