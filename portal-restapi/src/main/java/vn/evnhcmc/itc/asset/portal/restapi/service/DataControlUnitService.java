package vn.evnhcmc.itc.asset.portal.restapi.service;

import vn.evnhcmc.itc.asset.portal.restapi.model.DataControlUnitEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface DataControlUnitService extends Operations<DataControlUnitEntity, Long>{
    DataControlUnitEntity save(Map<String, Object> changes, Long id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
