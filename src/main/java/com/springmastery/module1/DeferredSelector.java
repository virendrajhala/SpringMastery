package com.springmastery.module1;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class DeferredSelector implements DeferredImportSelector {
    public String[] selectImports(AnnotationMetadata m) {
        System.out.println(">>> DEFERRED: runs after all regular configs");
        return new String[]{};
    }
}