package geektime.tdd.args;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

public class BooleanOptionPaserTest {
    @Test
    public void should_not_accept_extra_argument_for_boolean_option(){
        TooManyArgumentsException e=  assertThrows(TooManyArgumentsException.class,()->{
            new BooleanOptionParser().parse(asList("-l","t"),option("l"));
        });
        assertEquals(e.getOption());
    }
    static Option option(String value){
        return new Option{
            @Override
                    public Class<? extends Annotation> annotationType(){
                return Option.class;
            }
            @Override
                    public String value(){
                return value;
            }
        }
    }
}
