package geektime.tdd.args;

import geektime.tdd.Args;
import geektime.tdd.Option;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {
    //-l -p 8080 -d /usr/logs
    //[-l],[-p,8080],[-d,/usr/logs]
    //{-l:[],-p:[8080],-d:[/usr/logs]}
    //Single Options:
    // TODO: -Bool -l
    @Test
    public void should_set_boolean_option_to_true_if_flag_present(){
       BooleanOption option= Args.parse(BooleanOption.class,"-l");
       assertTrue(option.logging());
    }
    @Test
    public void should_set_boolean_option_to_false_if_flag_not_present(){
        BooleanOption option=Args.parse(BooleanOption.class);
        assertFalse(option.logging());
    }
    public static record BooleanOption(@Option("l")boolean logging){}

    // TODO: -Integer  -p 8080
    @Test
    public void should_set_int_option_value(){
        IntOption option=Args.parse(IntOption.class,"-p","8080");
        assertEquals(8080,option.port());
    }
    public static record IntOption(@Option("p") int port){};

    // TODO: -String   -d /usr/logs
    @Test
    public void should_set_string_option_value(){
        StringOption option=Args.parse(StringOption.class,"-d","/usr/logs");
        assertEquals("/usr/logs",option.directory());
    }
    public static record StringOption(@Option("d") String directory){};
    // TODO: multi options: -l -p 8080 -d /usr/logs
    @Test
    public void should_set_multi_options(){
        MultiOptions options= Args.parse(MultiOptions.class,"-l","-p","8080","-d","/usr/logs");
        assertTrue(options.logging());
        assertEquals(8080,options.port());
        assertEquals("/usr/logs",options.directory());
    }
    public static record MultiOptions(@Option("l")boolean logging,@Option("p")int port,@Option("d") String directory){}
    // sad path:
    // TODO: -bool -l t /
    @Test
    @Disabled
    public void should_set_boolean_incorrect_value(){
        BooleanOption option=Args.parse(BooleanOption.class,"-l","t","/");
        assertFalse(option.logging);
    }

    // TODO: -int -p/ -p 8080 0909
    // TODO: -String -d/ -d /usr/logs /usr/vars
    // default value
    // TODO: -bool : false
    // TODO: -int :0
    // TODO: -String ""


    //-g this is a list -d 1 2 -3 5
    @Test
    @Disabled
    public void should_example_2(){
        ListOptions options=Args.parse(ListOptions.class,"-g","this","is","a","list","-d","1","2","-3","5");
        assert options != null;
        assertArrayEquals(new String[]{"this","is","a","list"},options.group());
        assertArrayEquals(new int[]{1,2,-3,5},options.decimals());

}
    static record Options(@Option("l")boolean logging,@Option("p") int port,@Option("d") String directory){
    }
    static record ListOptions(@Option("g") String[] group,@Option("d") int[] decimals){

    }


}
