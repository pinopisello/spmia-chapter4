package com.thoughtmechanix.licenses.clients;


import com.thoughtmechanix.licenses.model.Organization;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("organizationservice")							 //target serviceid  da risolvere in eurekaserver [risolve ip e porta]
public interface OrganizationFeignClient {
    @RequestMapping(
            method= RequestMethod.GET, 						 //http metodo da usare
            value="/v1/organizations/{organizationId}",      //path da invocare verso  organizationservice
            consumes="application/json")                     //http accept header da inviare 
    Organization getOrganization(@PathVariable("organizationId") String organizationId);//setta il {organizationId} in value
}
