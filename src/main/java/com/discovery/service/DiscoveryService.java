package com.discovery.service;

import com.discovery.request.DiscoveryHostRequest;
import com.discovery.response.DiscoveryHostResponse;
import javassist.NotFoundException;

public interface DiscoveryService {
  
  public DiscoveryHostResponse findByServiceName(String service);

  void saveHost(String service, DiscoveryHostRequest discoveryHostRequest);

  public void deleteHost(String serviceName, String ipAddress) throws NotFoundException;

  public void loadbalancing(String serviceName, String ipAddress, Integer loadBalancingWeight) throws NotFoundException;
}
