package com.self.cloudserver.http;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        System.out.println("路由请求。。。");

        return builder.routes()
                //cloud-one
                .route("cloud-server-one", a -> a.path("/cloud/server/one/**")
                        .uri("http://127.0.0.1:8080"))

                //cloud-two
                .route("cloud-server-two", a -> a.path("/rpc/cloud/server/two/**")
                        .uri("http://127.0.0.1:8081"))

                .build();
    }

}
