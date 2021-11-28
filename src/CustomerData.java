public class CustomerData {
    private String customerId;
    private String contractId;
    private String geoZone;
    private String teamCode;
    private String projectCode;
    //in seconds
    private Integer buildDuration;
    public CustomerData(String[] customerDataAsStringArray) {
        this.customerId = customerDataAsStringArray[Constants.INDEX_OF_CUSTOMER_ID];
        this.contractId = customerDataAsStringArray[Constants.INDEX_OF_CONTRACT_ID];
        this.geoZone = customerDataAsStringArray[Constants.INDEX_OF_GEO_ZONE];
        this.teamCode = customerDataAsStringArray[Constants.INDEX_OF_TEAM_CODE];
        this.projectCode = customerDataAsStringArray[Constants.INDEX_OF_PROJECT_CODE];
        this.buildDuration = Integer.parseInt(customerDataAsStringArray[Constants.INDEX_OF_BUILD_DURATION]
                .replaceAll(Constants.REGEX_FOR_SEARCH_S, ""));
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
