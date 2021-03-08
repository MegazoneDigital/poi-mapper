package com.mz.poi.mapper.annotation;

import com.mz.poi.mapper.structure.CellType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ArrayCell {

  int column() default 0;

  int cols() default 1;

  String columnAfter() default "";

  int columnAfterOffset() default 0;

  CellType cellType();

  boolean ignoreParse() default false;

  boolean required() default false;

  CellStyle style() default @CellStyle;

  int size() default 0;
}
