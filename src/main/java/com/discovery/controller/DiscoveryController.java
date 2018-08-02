package com.discovery.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.discovery.request.DiscoveryHostRequest;
import com.discovery.response.DiscoveryHostResponse;
import com.discovery.service.DiscoveryService;
import javassist.NotFoundException;

@RestController
public class DiscoveryController {

  @Autowired
  DiscoveryService discoveryService;

  private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryController.class);

  @GetMapping(value = "/v1/registration/{serviceName}")
  public DiscoveryHostResponse getHostsByServiceName(
      @PathVariable("serviceName") String serviceName) {
    LOGGER.info("getHostsByServiceName: service={}", serviceName);
    DiscoveryHostResponse discoveryHostResponse = discoveryService.findByServiceName(serviceName);
    LOGGER.info("getHostsByServiceName: hosts={}", discoveryHostResponse);
    return discoveryHostResponse;
  }

  @PostMapping("/v1/registration/{serviceName}")
  public void addHost(@PathVariable("serviceName") String serviceName,
      @RequestBody @Valid DiscoveryHostRequest discoveryHostRequest) {
    LOGGER.info("addHost: service={}, body={}", serviceName, discoveryHostRequest);
    discoveryService.saveHost(serviceName, discoveryHostRequest);
  }

  @DeleteMapping("/v1/registration/{serviceName}/{ipAddress}")
  public void deleteHost(@PathVariable("serviceName") String serviceName,
      @PathVariable("ipAddress") String ipAddress) throws NotFoundException {
    LOGGER.info("deleteHost: service={}, ip={}", serviceName, ipAddress);
    discoveryService.deleteHost(serviceName, ipAddress);
  }

  @PostMapping("/v1/loadbalancing/{serviceName}/{ipAddress}")
  public void loadbalancing(@PathVariable("serviceName") String serviceName,
      @PathVariable("ipAddress") String ipAddress,
      @RequestParam("load_balancing_weight") Integer loadBalancingWeight) throws NotFoundException {
    LOGGER.info("loadbalancing: service={}, ip={}", serviceName, ipAddress);
    discoveryService.loadbalancing(serviceName, ipAddress, loadBalancingWeight);
  }
}
