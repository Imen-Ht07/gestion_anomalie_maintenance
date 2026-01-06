package gateway_service.gateway_service.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class LoggingGlobalFilter {

    @Bean
    public GlobalFilter logFilter() {
        return (exchange, chain) -> {
            var request = exchange.getRequest();

            log.info("➡️ {} {}", request.getMethod(), request.getURI());

            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() ->
                            log.info("Réponse envoyée pour {}", request.getURI())
                    ));
        };
    }
}