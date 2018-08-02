package com.discovery.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscoveryHostRequest {
  
  @JsonProperty("ip_address")
  @NotBlank(message = "IP Address is required")
  private String ipAddress;
  
  @JsonProperty("last_check_in")
  private String lastCheckIn;
  
  @NotNull(message = "Port is required")
  private Integer port;
  
  @NotBlank(message = "Revision is required")
  private String revision;
  
  @JsonProperty("service_repo_name")
  private String serviceRepoName;
  
  @JsonProperty("tags")
  @Valid
  private TagsRequest tagsRequest;

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public String getLastCheckIn() {
    return lastCheckIn;
  }

  public void setLastCheckIn(String lastCheckIn) {
    this.lastCheckIn = lastCheckIn;
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

  public String getServiceRepoName() {
    return serviceRepoName;
  }

  public void setServiceRepoName(String serviceRepoName) {
    this.serviceRepoName = serviceRepoName;
  }

  public TagsRequest getTagsRequest() {
    return tagsRequest;
  }

  public void setTagsRequest(TagsRequest tagsRequest) {
    this.tagsRequest = tagsRequest;
  }
  
}
