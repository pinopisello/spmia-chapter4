package com.thoughtmechanix.licenses.clients;

import com.thoughtmechanix.licenses.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrganizationRestTemplateClient {
	
	/*@EnableDiscoveryClient abilita Ribbon intercepton nelle istanze  
	 * RestTemplate managed da Spring!!
	 * Ego la url dell organizzationservice e' automaticamente trovato!!
	 *   "http://organizationservice/v1/organizations/{organizationId}" diventa a runtime 
	 *   http://10.195.171.96:8080/v1/organizations/442adb6e-fa58-47f3-9ca2-ed1fecdfe86c
	 */
	
	
    @Autowired
    RestTemplate restTemplate;

    public Organization getOrganization(String organizationId){
        ResponseEntity<Organization> restExchange =  //Invia GET verso http://10.195.170.155:8080/v1/organizations/442adb6e-fa58-47f3-9ca2-ed1fecdfe86c
                restTemplate.exchange(
                        "http://organizationservice/v1/organizations/{organizationId}",  //String url
                        HttpMethod.GET,    												 //HttpMethod method,
                        null, 															 //HttpEntity<?> requestEntity
                        Organization.class,                                              //Class<T> responseType
                        organizationId); 												 //Object... uriVariables)
       
        return restExchange.getBody();
    }
}
