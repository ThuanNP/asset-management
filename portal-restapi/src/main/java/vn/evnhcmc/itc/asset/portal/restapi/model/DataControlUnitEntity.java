package vn.evnhcmc.itc.asset.portal.restapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "DATA_CONTROL_UNIT", schema = "HCMC_ASSET_TRACKING")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DataControlUnitEntity extends BaseEntity {
    @Column(name = "DCU_INDEX")
    private String dcuIndex;
    @Column(name = "DCU_CODE")
    private String dcuCode;
    @Column(name = "DCU_ADDRESS")
    private String dcuAddress;
    @Column(name = "STATION_ID")
    private String stationID;
    @Column(name = "STATION_NAME")
    private String stationName;
    @Column(name = "IMEI_SIM")
    private String imeiSim;
    @Column(name = "LAUNCH_DATE")
    private Date launchDate;
    @Column(name = "LONGITUDE")
    private BigDecimal longitude;
    @Column(name = "LATITUDE")
    private BigDecimal latitude;
    @Column(name = "GEO_ADDRESS")
    private String geoAddress;
}
