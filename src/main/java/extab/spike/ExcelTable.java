package extab.spike;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExcelTable {
  public String name();
  public String comments() default "";
  public int fromRow() default 0;
  public int fromColumn()default 0;
}
