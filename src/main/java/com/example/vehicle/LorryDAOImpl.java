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
public class LorryDAOImpl implements LorryDAO{
        @Autowired
        private SessionFactory sessionFactory;

        @Override
        public void save(Lorry v){
                this.sessionFactory.getCurrentSession().save(v);
        }

        @Override
        public List<Lorry> findAll(){
                CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
                CriteriaQuery<Lorry> criteria = builder.createQuery(Lorry.class);
                criteria.from(Lorry.class);
                return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        }

        @Override
        public Optional<Lorry> findById(int id){
                return Optional.ofNullable( this.sessionFactory.getCurrentSession().load(Lorry.class, id) );
        }

        @Override
        public void update(Lorry v){
                this.sessionFactory.getCurrentSession().update(v);
                System.out.println("Lorry update" + v.getReg_no());
        }

        @Override
        public void deleteById(int id) {
                Session session = this.sessionFactory.getCurrentSession();
                Lorry Lorry = session.load(Lorry.class, id);
                if(Lorry == null){
                        throw new NoResultException();
                }
                // @TODO implement rest of body
                return;
        }
}
