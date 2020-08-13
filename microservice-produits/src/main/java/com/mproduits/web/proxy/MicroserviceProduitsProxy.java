package com.mproduits.web.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "microservice-produits")
public interface MicroserviceProduitsProxy {
}
