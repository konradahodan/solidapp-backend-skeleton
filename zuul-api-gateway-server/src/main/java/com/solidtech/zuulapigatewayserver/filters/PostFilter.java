package com.solidtech.zuulapigatewayserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * Ce filtre permet d'exécuter du code après que la requête a été redirigée.
 */
@Component
public class PostFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "post";
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
        System.out.println("Inside Response Filter");

        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        // response.setStatus(400);
        log.info(" Requete intercepté après que la requete a été dirigée : CODE HTTP {} ", response.getStatus());

        return null;
    }

}
