package com.discovery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.discovery.model.DiscoveryHost;
import com.discovery.model.Tags;
import com.discovery.repository.DiscoveryHostRepository;
import com.discovery.repository.TagsRepository;
import com.discovery.request.DiscoveryHostRequest;
import com.discovery.response.DiscoveryHostResponse;
import javassist.NotFoundException;

@Service
public class DiscoveryServiceImpl implements DiscoveryService {
  
  @Autowired
  private DiscoveryHostRepository discoveryHostRepository;
  
  @Autowired
  private TagsRepository tagsRepository;

  @Value("production")
  private String env;
  
  @Override
  public DiscoveryHostResponse findByServiceName(String service) {
    DiscoveryHostResponse discoveryHostResponse = new DiscoveryHostResponse();
    List<DiscoveryHost> discoveryHosts = discoveryHostRepository.findAllByService(service);
    discoveryHostResponse.setEnv(env);
    discoveryHostResponse.setService(service);
    discoveryHostResponse.setHosts(discoveryHosts);
    return discoveryHostResponse;
  }

  @Override
  public void saveHost(String service,DiscoveryHostRequest discoveryHostRequest) {
    DiscoveryHost discoveryHost = new DiscoveryHost();
    discoveryHost.setIpAddress(discoveryHostRequest.getIpAddress());
    discoveryHost.setLastCheckIn(discoveryHostRequest.getLastCheckIn());
    discoveryHost.setRevision(discoveryHostRequest.getRevision());
    discoveryHost.setServiceRepoName(discoveryHostRequest.getServiceRepoName());
    discoveryHost.setPort(discoveryHostRequest.getPort());
    discoveryHost.setService(service);
    
    Tags tags = new Tags();
    tags.setAz(discoveryHostRequest.getTagsRequest().getAz());
    tags.setRegion(discoveryHostRequest.getTagsRequest().getRegion());
    tags.setInstanceId(discoveryHostRequest.getTagsRequest().getInstanceId());
    tags.setLoadBalancingWeight(discoveryHostRequest.getTagsRequest().getLoadBalancingWeight());
    tags.setCanary(discoveryHostRequest.getTagsRequest().isCanary());
    tagsRepository.save(tags);
    discoveryHost.setTags(tags);
    discoveryHostRepository.save(discoveryHost);
  }

  @Override
  public void deleteHost(String serviceName, String ipAddress) throws NotFoundException {
    List<DiscoveryHost> discoveryHosts = discoveryHostRepository.findAllByServiceAndIpAddress(serviceName,ipAddress);
    if(discoveryHosts.size() == 0) {
      throw new NotFoundException("No Service found with given name and ip address") ;
    }
    discoveryHostRepository.deleteAll(discoveryHosts);
  }

  @Override
  public void loadbalancing(String serviceName, String ipAddress, Integer loadBalancingWeight) throws NotFoundException {
    List<DiscoveryHost> discoveryHosts = discoveryHostRepository.findAllByServiceAndIpAddress(serviceName,ipAddress);
    if(discoveryHosts.size() == 0) {
      throw new NotFoundException("No Service found with given name and ip address") ;
    }    
    for(DiscoveryHost discoveryHost : discoveryHosts) {
      Tags tags = discoveryHost.getTags();
      tags.setLoadBalancingWeight(loadBalancingWeight);
      tagsRepository.save(tags);
    }
  }

}
