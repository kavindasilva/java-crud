package com.example.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppUserDAOImpl implements AppUserDAO{
        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sf){
                this.sessionFactory = sf;
        }

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
                System.out.println("AppUser findbyame");
                return null;
        }

        public void removePerson(int id){
                System.out.println("AppUser remove");
        }
}
