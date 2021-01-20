package com.example.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AppUserDAOImpl implements AppUserDAO{
        @Autowired
        private SessionFactory sessionFactory;

//        @Autowired
//        public void setSessionFactory(SessionFactory sf){
//                this.sessionFactory = sf;
//        }

        public void save(AppUser p){
                Session session = this.sessionFactory.getCurrentSession();
//                session.persist(p);
                System.out.println("AppUser save");
        }

        public void updatePerson(AppUser p){
                System.out.println("AppUser update");
        }

        public List<AppUser> findAll(){
                System.out.println("AppUser findall");
                return new ArrayList<>();
        }

        public AppUser getPersonById(int id){
                System.out.println("AppUser getpersonbyid");
                return null;
        }

        public AppUser findByName(String name){
                Session session = this.sessionFactory.getCurrentSession();
                System.out.println("AppUser findbyame");
                AppUser p = (AppUser)session.load(AppUser.class, 13);
                System.out.println("AppUser findbyame " + p.getName());
//                return null;
                return p;
        }

        public void removePerson(int id){
                System.out.println("AppUser remove");
        }
}
