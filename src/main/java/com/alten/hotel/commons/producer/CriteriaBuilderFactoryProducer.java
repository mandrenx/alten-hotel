package com.alten.hotel.commons.producer;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class CriteriaBuilderFactoryProducer
{
    private volatile CriteriaBuilderFactory cbf;

    @PersistenceUnit private EntityManagerFactory emf;

    @PostConstruct
    public void init()
    {
        CriteriaBuilderConfiguration config = Criteria.getDefault();
        this.cbf = config.createCriteriaBuilderFactory(this.emf);
    }

    @Produces
    @ApplicationScoped
    public CriteriaBuilderFactory create() { return this.cbf; }
}
