package com.hans.taxcalculator.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JSONType implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String fileType = conditionContext.getEnvironment().getProperty("input.file.type");
        return "json".equals(fileType);
    }
}
