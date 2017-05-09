package com.thoughtmechanix.licenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  //Inietta EurekaDiscoveryClient in DiscoveryClient in OrganizationDiscoveryClient

@EnableFeignClients     //Inietta OrganizationFeignClient in LicenseService.Vedi anche @FeignClient in OrganizationFeignClient
public class Application {

  @LoadBalanced         //Inietta RestTemplate  in  OrganizationRestTemplateClient configurando un LoadBalancerInterceptor 
  @Bean
  public RestTemplate getRestTemplate(){
      return new RestTemplate();
  }

  public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
  }
}
