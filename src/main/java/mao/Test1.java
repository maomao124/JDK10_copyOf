package mao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project name(项目名称)：JDK10_copyOf
 * Package(包名): mao
 * Class(类名): Test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/2
 * Time(创建时间)： 12:05
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test1
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        List<String> list1 = List.copyOf(list);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list == list1);
        System.out.println(list.getClass());
        System.out.println(list1.getClass());
        list1.remove(0);
    }
}
