package com.example.user;

import com.example.rentsystem.VehicleOwner;
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
// @TODO: implement this class functionality
public class VechicleOwnerDAOImpl implements VehicleOwnerDAO{
        @Autowired
        private SessionFactory sessionFactory;

        public void save(VehicleOwner newUser){
                Session session = this.sessionFactory.getCurrentSession();
                session.save(newUser);
        }

        // not tested, since not used
        public void updateUser(VehicleOwner userdata){
                Session session = this.sessionFactory.getCurrentSession();
                VehicleOwner VehicleOwner = session.load(VehicleOwner.class, userdata.getId());
                if(VehicleOwner == null){
                        throw new NoResultException();
                }
                session.save(userdata);
                System.out.println("AppUser update" + VehicleOwner.getLocation());
        }

        public List<VehicleOwner> findAll(){
                CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
                CriteriaQuery<VehicleOwner> criteria = builder.createQuery(VehicleOwner.class);
                criteria.from(VehicleOwner.class);
               return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        }

        public VehicleOwner findById(int id){
                return this.sessionFactory.getCurrentSession().load(VehicleOwner.class, id);
        }

        public VehicleOwner findByName(String name){
                Session session = this.sessionFactory.getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<VehicleOwner> criteria = builder.createQuery(VehicleOwner.class);
                Root<VehicleOwner> userRoot = criteria.from(VehicleOwner.class);
                criteria
                        .select(userRoot)
                        .where(builder.equal(userRoot.get("name"), name ));
                try {
                        return session.createQuery(criteria).getSingleResult();
                }catch (NoResultException e){
                        return null;
                }
        }

        public void deleteUser(int id){
                System.out.println("AppUser remove");
        }
}
