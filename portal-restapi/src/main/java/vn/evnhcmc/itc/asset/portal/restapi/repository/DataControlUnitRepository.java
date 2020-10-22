package vn.evnhcmc.itc.asset.portal.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.evnhcmc.itc.asset.portal.restapi.model.DataControlUnitEntity;

@Repository("dcuRepository")
public interface DataControlUnitRepository extends JpaRepository<DataControlUnitEntity, Long> {
}
