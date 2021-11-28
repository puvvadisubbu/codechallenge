import java.util.Objects;
import java.util.Set;

public class GeoZoneData {
    private String geoZone;
    private Set<String> customerIds;
    private Integer avgBuildTime;
    private Set<String> contractIds;

    public Set<String> getContractIds() {
        return contractIds;
    }

    public void setContractIds(Set<String> contractIds) {
        this.contractIds = contractIds;
    }

    public Integer getAvgBuildTime() {
        return avgBuildTime;
    }

    public void setAvgBuildTime(Integer avgBuildTime) {
        this.avgBuildTime = avgBuildTime;
    }

    public Set<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(Set<String> customerIds) {
        this.customerIds = customerIds;
    }

    public String getGeoZone() {
        return geoZone;
    }

    public void setGeoZone(String geoZone) {
        this.geoZone = geoZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoZoneData)) return false;
        GeoZoneData that = (GeoZoneData) o;
        return getGeoZone().equals(that.getGeoZone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGeoZone());
    }
}
