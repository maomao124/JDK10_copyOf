package mao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Project name(项目名称)：JDK10_copyOf
 * Package(包名): mao
 * Class(类名): Test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/2
 * Time(创建时间)： 15:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test2
{
    public static void main(String[] args)
    {
        Set<String> strings = new HashSet<>();
        strings.add("1");
        Set<String> strings1 = Set.copyOf(strings);
        System.out.println(strings1);
        System.out.println(strings1.getClass());
        Map<Object, Object> map = Map.copyOf(new HashMap<>());
        System.out.println(map.getClass());
    }
}
