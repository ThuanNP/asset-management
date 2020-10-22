package vn.evnhcmc.itc.asset.portal.restapi.payload;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DataControlUnit {
    private String dcuIndex;
    private String dcuCode;
    private String dcuAddress;
    private String stationID;
    private String stationName;
    private String imeiSim;
    private Date launchDate;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String geoAddress;
}
