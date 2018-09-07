package ru.vood.admplugin.infrastructure.spring.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vood.admplugin.infrastructure.spring.intf.CommonFunctionService;

import java.io.Serializable;

@Service
public class GeneratorId implements IdentifierGenerator {
    @Autowired
    private CommonFunctionService service;

/*
    @Autowired
    public GeneratorId(CommonFunctionService service) {
        this.service = service;
    }
*/

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        //CommonFunctionService service = LoadedCTX.getService(CommonFunctionService.class);
        return service.nextId();

    }
}
