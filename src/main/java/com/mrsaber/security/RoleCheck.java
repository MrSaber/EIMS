package com.mrsaber.security;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RoleCheck {
    int[] level() default 0;
}
