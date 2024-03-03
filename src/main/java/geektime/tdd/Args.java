package geektime.tdd;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Args {
    public static <T> T parse(Class<T> optionsClass, String... args) {
        try{
            List<String> arguments = Arrays.asList(args);
            Constructor<?> constructor= optionsClass.getDeclaredConstructors()[0];
            Parameter parameter=constructor.getParameters()[0];
            //Java中,0表示false,非0表示true
            //arguments.contains 返回值为boolean。所以当参数类型为-l,如果匹配返回就是boolean。当参数为-p,arguments中还有具体的值时，则用取下一个下标才是我们需要的具体值
            Object[] values=Arrays.stream(constructor.getParameters()).map(it->parseOptions(it,arguments)).toArray();
            return (T) constructor.newInstance(values);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    private static Object parseOptions(Parameter parameter, List<String> arguments) {
        Class<?> type = parameter.getType();
        return PARSERS.get(type).parse(arguments, parameter.getAnnotation(Option.class));
    }
    private static Map<Class<?>, OptionParser> PARSERS = Map.of(
            boolean.class,new BooleanOptionParser(),
            int.class, new SingleValueOptionParser<>(Integer::parseInt),
            String.class, new SingleValueOptionParser<>(String::valueOf));

}
