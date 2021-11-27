public class CustomerData {
    private String customerId;
    private String contractId;
    private String geoZone;
    private String teamCode;
    private String projectCode;
    //in seconds
    private Integer buildDuration;
    public CustomerData(String[] customerDataAsStringArray) {
        this.customerId = customerDataAsStringArray[0];
        this.contractId = customerDataAsStringArray[1];
        this.geoZone = customerDataAsStringArray[2];
        this.teamCode = customerDataAsStringArray[3];
        this.projectCode = customerDataAsStringArray[4];
        this.buildDuration = Integer.parseInt(customerDataAsStringArray[5].replaceAll("(?i)s", ""));
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public String getGeoZone() {
        return geoZone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public Integer getBuildDuration() {
        return buildDuration;
    }

    @Override
    public String toString() {
        return "{" +
                "customerId=" + customerId +
                ", contractId=" + contractId +
                ", geoZone=" + geoZone +
                ", teamCode=" + teamCode +
                ", projectCode=" + projectCode +
                ", buildDuration=" + buildDuration +
                '}';
    }
}
