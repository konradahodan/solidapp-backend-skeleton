package com.solidtech.zuulapigatewayserver.filters;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * Ce filtre agir sur la façon de rediriger les requêtes
 */
@Component
public class RouteFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // agir sur la façon de rediriger les requêtes
        System.out.println("Facon dont la requete est redirigé: Inside Route Filter");
        return null;
    }

}
