package com.example.rentsystem;

import com.example.user.AppUser;
import com.example.user.AppUserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class usersDAOImpl implements UsersDAO{
        @Autowired
        private SessionFactory sessionFactory;

        public void save(User newUser){
                Session session = this.sessionFactory.getCurrentSession();
                session.save(newUser);
        }

        // not tested, since not used
        public void updateUser(User userdata){
                Session session = this.sessionFactory.getCurrentSession();
                User user = session.load(User.class, userdata.getId());
                if(user == null){
                        throw new NoResultException();
                }
                session.save(userdata);
                System.out.println("AppUser update" + user.getName());
        }

        public List<User> findAll(){
                CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
                CriteriaQuery<User> criteria = builder.createQuery(User.class);
                criteria.from(User.class);
               return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        }

        public User findById(int id){
                return this.sessionFactory.getCurrentSession().load(User.class, id);
        }

        public User findByName(String name){
                Session session = this.sessionFactory.getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<User> criteria = builder.createQuery(User.class);
                Root<User> userRoot = criteria.from(User.class);
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
