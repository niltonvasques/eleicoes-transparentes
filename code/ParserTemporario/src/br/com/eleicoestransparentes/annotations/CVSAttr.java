package br.com.eleicoestransparentes.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CVSAttr {
	String name();
	boolean foreignKey() default false;
	boolean canBeNull() default false;
}

