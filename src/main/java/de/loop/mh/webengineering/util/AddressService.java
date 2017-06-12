package de.loop.mh.webengineering.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class AddressService {
    @Value("${addressService.address}")
    private String serverAddress;

    public String getServerURL() {
        return serverAddress;
    }
}