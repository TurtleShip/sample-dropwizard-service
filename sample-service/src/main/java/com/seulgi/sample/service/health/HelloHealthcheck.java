package com.seulgi.sample.service.health;

import com.codahale.metrics.health.HealthCheck;

public class HelloHealthcheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
