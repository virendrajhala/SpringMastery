package com.springmastery.module1;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyPostProcessor
        implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(
            BeanDefinitionRegistry registry) {
        System.out.println(">>> STEP 5: bean definitions = "
                + registry.getBeanDefinitionCount());
        System.out.println("Bean definition names : "+ Arrays.toString(registry.getBeanDefinitionNames()));
        System.out.println(">>> ExpensiveBean defined? "
                + registry.containsBeanDefinition("expensiveBean"));
    }

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory f) {}
}
