package com.springmastery.module1;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class EarlySelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata m) {
        System.out.println(">>> EARLY: runs immediately");
        return new String[]{};
    }
}