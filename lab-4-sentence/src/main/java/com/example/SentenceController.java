package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by Vít on 11. 12. 2016.
 */
@RestController
public class SentenceController {

    @Autowired
    private LoadBalancerClient discoveryClient;

    @RequestMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return
                getWord("LAB-4-SUBJECT") + " "
                        + getWord("LAB-4-VERB") + " "
                        + getWord("LAB-4-ARTICLE") + " "
                        + getWord("LAB-4-ADJECTIVE") + " "
                        + getWord("LAB-4-NOUN") + "."
                ;
    }

    public String getWord(String service) {
        ServiceInstance serviceInstance = discoveryClient.choose(service);
        URI uri = serviceInstance.getUri();
        if (uri != null ) {
            return (new RestTemplate()).getForObject(uri,String.class);
        }
        return null;
    }
}
