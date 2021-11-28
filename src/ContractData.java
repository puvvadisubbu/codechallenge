import java.util.Objects;
import java.util.Set;

public class ContractData {
    private Set<String> customerIds;
    private Integer avgBuildTime;
    private String contractId;
    private String geoZone;

    public Set<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(Set<String> customerIds) {
        this.customerIds = customerIds;
    }

    public Integer getAvgBuildTime() {
        return avgBuildTime;
    }

    public void setAvgBuildTime(Integer avgBuildTime) {
        this.avgBuildTime = avgBuildTime;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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
        if (!(o instanceof ContractData)) return false;
        ContractData that = (ContractData) o;
        return getContractId().equals(that.getContractId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContractId());
    }
}
