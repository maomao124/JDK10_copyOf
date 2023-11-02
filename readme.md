

## 集合新方法copyOf

### 概述

JDK10 给 java.util 包下的List、Set、Map新增加了一个静态方法 copyOf 。copyof方法将元素放到一个不可修改的集合并返回

```java
    /**
     * Returns an <a href="#unmodifiable">unmodifiable List</a> containing the elements of
     * the given Collection, in its iteration order. The given Collection must not be null,
     * and it must not contain any null elements. If the given Collection is subsequently
     * modified, the returned List will not reflect such modifications.
     *
     * @implNote
     * If the given Collection is an <a href="#unmodifiable">unmodifiable List</a>,
     * calling copyOf will generally not create a copy.
     *
     * @param <E> the {@code List}'s element type
     * @param coll a {@code Collection} from which elements are drawn, must be non-null
     * @return a {@code List} containing the elements of the given {@code Collection}
     * @throws NullPointerException if coll is null, or if it contains any nulls
     * @since 10
     */
    static <E> List<E> copyOf(Collection<? extends E> coll) {
        return ImmutableCollections.listCopy(coll);
    }
```







### 使用

```java
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
```



```sh
[1, 2]
[1, 2]
false
class java.util.ArrayList
class java.util.ImmutableCollections$List12
Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
	at java.base/java.util.ImmutableCollections$AbstractImmutableList.remove(ImmutableCollections.java:258)
	at mao.Test1.main(Test1.java:33)
```



copyof返回的是不可变集合，所有对元素增删改的方法都会抛出异常



```java
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
```



```sh
[1]
class java.util.ImmutableCollections$Set12
class java.util.ImmutableCollections$MapN
```



