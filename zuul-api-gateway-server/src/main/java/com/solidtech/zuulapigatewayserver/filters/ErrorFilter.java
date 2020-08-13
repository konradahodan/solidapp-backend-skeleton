package com.solidtech.zuulapigatewayserver.filters;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * ce filtre permet d'agir en cas d'erreur lors de la redirection de la requête
 */
@Component
public class ErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
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
        System.out.println("Inside Route Filter");

        return null;
    }

}
