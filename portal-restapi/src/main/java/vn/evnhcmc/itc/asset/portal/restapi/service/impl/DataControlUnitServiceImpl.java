package vn.evnhcmc.itc.asset.portal.restapi.service.impl;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import vn.evnhcmc.itc.asset.portal.restapi.common.exception.ResourceNotFoundException;
import vn.evnhcmc.itc.asset.portal.restapi.model.DataControlUnitEntity;
import vn.evnhcmc.itc.asset.portal.restapi.service.DataControlUnitService;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Service("dcuService")
public class DataControlUnitServiceImpl extends AbstractService<DataControlUnitEntity, Long> implements DataControlUnitService {

    @Autowired
    public DataControlUnitServiceImpl(@Qualifier("dcuRepository") JpaRepository<DataControlUnitEntity, Long> repository) {
        super(repository);
    }

    @Override
    public DataControlUnitEntity save(Map<String, Object> changes, Long id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        DataControlUnitEntity entity = _repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        for (Map.Entry<String, Object> entry : changes.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                if ("true".equalsIgnoreCase(value.toString()) || "false".equalsIgnoreCase(value.toString())) {
                    PropertyUtils.setSimpleProperty(entity, key, Boolean.parseBoolean(value.toString()));
                } else {
                    PropertyUtils.setSimpleProperty(entity, key, value);
                }
            }
        }
        return _repository.save(entity);
    }
}
