package com.springmastery.module1;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupWatcher {

    @EventListener
    public void onEnvReady(ApplicationEnvironmentPreparedEvent e) {
        System.out.println(">>> ENV READY");
    }

    @EventListener
    public void onRefreshed(ContextRefreshedEvent e) {
        System.out.println(">>> CONTEXT REFRESHED");
    }

    @EventListener
    public void onStarted(ApplicationStartedEvent e) {
        System.out.println(">>> STARTED");
    }

    @EventListener
    public void onReady(ApplicationReadyEvent e) {
        System.out.println(">>> READY");
    }

    @EventListener
    public void onStarting(ApplicationStartingEvent e) {
        System.out.println(">>> STARTING");
    }
}
