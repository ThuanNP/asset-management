package vn.evnhcmc.itc.asset.portal.restapi.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import vn.evnhcmc.itc.asset.portal.restapi.domain.DataControlUnit;
import vn.evnhcmc.itc.asset.portal.restapi.service.DataControlUnitService;

@Service("dcuService")
public class DataControlUnitServiceImpl extends AbstractService<DataControlUnit, Long> implements DataControlUnitService {
    public DataControlUnitServiceImpl(JpaRepository<DataControlUnit, Long> repository) {
        super(repository);
    }
}
