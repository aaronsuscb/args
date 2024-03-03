package geektime.tdd;

import geektime.tdd.Option;

import java.util.List;

interface OptionParser {
    Object parse(List<String> arguments, Option option);
}
