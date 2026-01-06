package gateway_service.gateway_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("surveillance-service",
                        r -> r.path("/api/surveillance/**")
                                .uri("lb://surveillance-service"))
                .route("maintenance-service",
                        r -> r.path("/api/maintenance/**")
                                .uri("lb://maintenance-service"))
                .build();
    }
}
