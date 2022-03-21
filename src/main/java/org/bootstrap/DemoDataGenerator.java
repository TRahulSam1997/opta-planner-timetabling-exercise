package org.bootstrap;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class DemoDataGenerator {

    @Transactional
    public void generateDemoDate(@Observes StartupEvent startupEvent) {

    }
}
