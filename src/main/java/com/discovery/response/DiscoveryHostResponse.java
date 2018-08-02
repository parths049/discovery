package com.discovery.response;

import java.util.ArrayList;
import java.util.List;
import com.discovery.model.DiscoveryHost;

public class DiscoveryHostResponse {

  private List<DiscoveryHost> hosts = new ArrayList<>();
  private String env;
  private String service;

  public List<DiscoveryHost> getHosts() {
    return hosts;
  }

  public void setHosts(List<DiscoveryHost> hosts) {
    this.hosts = hosts;
  }

  public String getEnv() {
    return env;
  }

  public void setEnv(String env) {
    this.env = env;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }
  
}
