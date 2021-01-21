package com.example.vehicle;

import com.example.user.AppUser;
import com.example.user.AppUserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@Qualifier("VehicleDAOImpl")
public class VehicleDAOImpl implements VehicleDAO{
        @Autowired
        private SessionFactory sessionFactory;

        @Override
        public void save(Vehicle v){
                Session session = this.sessionFactory.getCurrentSession();
                session.save(v);
        }

        @Override
        public List<Vehicle> findAll(){
                CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
                CriteriaQuery<Vehicle> criteria = builder.createQuery(Vehicle.class);
                criteria.from(Vehicle.class);
                return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        }

        @Override
        public Optional<Vehicle> findById(int id){
                return Optional.ofNullable( this.sessionFactory.getCurrentSession().get(Vehicle.class, id) );
        }

        @Override
        public void update(Vehicle v){
                this.sessionFactory.getCurrentSession().update(v);
                System.out.println("Vehicle update" + v.getReg_no());
        }

        @Override
        public void deleteById(int id) {
                Session session = this.sessionFactory.getCurrentSession();
                Vehicle vehicle = session.load(Vehicle.class, id);
                if(vehicle == null){
                        throw new NoResultException();
                }
                // @TODO implement rest of body
                return;
        }

        @Override
        // @TODO failing reason
        public List<Vehicle> findAllVehicleBasicData() {
                //@Query(value = "SELECT id, reg_no, color, make, model, transmission, available, license_expiry_date FROM Vehicle", nativeQuery = true)
                //    List<VehicleBasicData> findAllVehicleBasicData();
                Session session = this.sessionFactory.getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<Vehicle> criteria = builder.createQuery(Vehicle.class);
                Root<Vehicle> userRoot = criteria.from(Vehicle.class);
                criteria
                        .multiselect(userRoot.get("id"));
                try {
//                        List<Vehicle> x = session.createQuery(criteria).getResultList();
                        return session.createQuery(criteria).getResultList();
                }catch (NoResultException e){
                        return null;
                }
        }
}
