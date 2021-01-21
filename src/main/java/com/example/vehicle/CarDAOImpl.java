package com.example.vehicle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CarDAOImpl implements CarDAO{
        @Autowired
        private SessionFactory sessionFactory;

//        @Override
        public void save(Car v){
                Session session = this.sessionFactory.getCurrentSession();
                session.save(v);
        }

//        @Override
        public List<Car> findAll(){
                CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
                CriteriaQuery<Car> criteria = builder.createQuery(Car.class);
                criteria.from(Car.class);
                return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        }

//        @Override
        public Optional<Car> findById(int id){
                return Optional.ofNullable( this.sessionFactory.getCurrentSession().load(Car.class, id) );
        }

//        @Override
        public void update(Car v){
                Session session = this.sessionFactory.getCurrentSession();
                Car Car = session.load(Car.class, v.getId());
                if(Car == null){
                        throw new NoResultException();
                }
                session.save(v);
                System.out.println("Car update" + Car.getReg_no());
        }

        @Override
        public void deleteById(int id) {
                Session session = this.sessionFactory.getCurrentSession();
                Car Car = session.load(Car.class, id);
                if(Car == null){
                        throw new NoResultException();
                }
                // @TODO implement rest of body
                return;
        }

        @Override
        public List<VehicleBasicData> findAllVehicleBasicData() {
                return null;
        }
}
