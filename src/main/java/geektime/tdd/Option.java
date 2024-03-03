package geektime.tdd;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Option {
    //@Option("l")boolean logging
    //代表在option中能指定参数
    //如果是:String[] value();代表在option中可以指定字符型数值作为参数
    String value();
}

