package com.discovery.request;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TagsRequest {

  @NotBlank(message = "AZ is required")
  private String az;
  
  @NotBlank(message = "Region is required")
  private String region;
  
  @NotBlank(message = "InstanceId is required")
  @JsonProperty("instance_id")
  private String instanceId;
  
  private boolean canary;
  
  @JsonProperty("load_balancing_weight")
  private Integer loadBalancingWeight;

  public String getAz() {
    return az;
  }

  public void setAz(String az) {
    this.az = az;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public boolean isCanary() {
    return canary;
  }

  public void setCanary(boolean canary) {
    this.canary = canary;
  }

  public Integer getLoadBalancingWeight() {
    return loadBalancingWeight;
  }

  public void setLoadBalancingWeight(Integer loadBalancingWeight) {
    this.loadBalancingWeight = loadBalancingWeight;
  }

  @Override
  public String toString() {
    return "TagsRequest [az=" + az + ", region=" + region + ", instanceId=" + instanceId
        + ", canary=" + canary + ", loadBalancingWeight=" + loadBalancingWeight + "]";
  }

}
