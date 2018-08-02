package com.discovery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tags")
public class Tags {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String az;
  
  private String region;
  
  @Column(name="instance_id")
  @JsonProperty("instance_id")
  private String instanceId;
  
  private boolean canary;
  
  @JsonProperty("load_balancing_weight")
  private Integer loadBalancingWeight;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
  
}
