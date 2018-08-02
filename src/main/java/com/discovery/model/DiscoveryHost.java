package com.discovery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "discovery_host")
public class DiscoveryHost {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="ip_address")
  @JsonProperty("ip_address")
  private String ipAddress;
  
  private Integer port;
  
  private String revision;
  
  @Column(name="last_check_in")
  @JsonProperty("last_check_in")
  private String lastCheckIn;
  
  @JsonIgnore
  private String service;
  
  @Column(name="service_repo_name")
  @JsonProperty("service_repo_name")
  private String serviceRepoName;
  
  @OneToOne
  @JoinColumn
  private Tags tags;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }
  
  public Integer getPort() {
    return port;
  }
  public void setPort(Integer port) {
    this.port = port;
  }
  
  public String getRevision() {
    return revision;
  }
  public void setRevision(String revision) {
    this.revision = revision;
  }
  
  public String getService() {
    return service;
  }
  public void setService(String service) {
    this.service = service;
  }
  
  public String getServiceRepoName() {
    return serviceRepoName;
  }
  public void setServiceRepoName(String serviceRepoName) {
    this.serviceRepoName = serviceRepoName;
  }
  
  public Tags getTags() {
    return tags;
  }
  public void setTags(Tags tags) {
    this.tags = tags;
  }

  public String getLastCheckIn() {
    return lastCheckIn;
  }
  public void setLastCheckIn(String lastCheckIn) {
    this.lastCheckIn = lastCheckIn;
  }
  
  @Override
  public String toString() {
    return "DiscoveryHost [id=" + id + ", ipAddress=" + ipAddress + ", port=" + port + ", revision=" + revision
        + ", service=" + service + ", serviceRepoName=" + serviceRepoName + "]";
  }
}
