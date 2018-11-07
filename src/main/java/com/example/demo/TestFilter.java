package com.example.demo;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;



@Component
public class TestFilter implements WebFilter {
    @NonNull
    @Override
    public Mono<Void> filter(@NonNull ServerWebExchange ctx, @NonNull WebFilterChain chain) {
        Hooks.onOperatorDebug();
        return chain.filter(ctx).log();
    }
}
