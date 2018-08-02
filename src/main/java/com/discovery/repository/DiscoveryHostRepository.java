package com.discovery.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.discovery.model.DiscoveryHost;

public interface DiscoveryHostRepository extends CrudRepository<DiscoveryHost, Long> {

  List<DiscoveryHost> findAllByService(String service);

  List<DiscoveryHost> findAllByServiceAndIpAddress(String serviceName, String ipAddress);

}
