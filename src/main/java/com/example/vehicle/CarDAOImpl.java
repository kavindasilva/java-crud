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

        @Override
        public void save(Car v){
                this.sessionFactory.getCurrentSession().save(v);
        }

        @Override
        public List<Car> findAll(){
                CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
                CriteriaQuery<Car> criteria = builder.createQuery(Car.class);
                criteria.from(Car.class);
                return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        }

        @Override
        public Optional<Car> findById(int id){
                return Optional.ofNullable( this.sessionFactory.getCurrentSession().get(Car.class, id) );
        }

        @Override
        public void update(Car v){
                this.sessionFactory.getCurrentSession().update(v);
                System.out.println("Car update" + v.getReg_no());
        }

        @Override
        public void deleteById(int id) {
                // @TODO implement rest of body
                return;
        }
}
