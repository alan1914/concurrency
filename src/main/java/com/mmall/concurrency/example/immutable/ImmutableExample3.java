package com.mmall.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author stone
 * @des TODO
 * @date 2019/2/25/025 15:54
 **/
@Slf4j
@ThreadSafe
public class ImmutableExample3 {


    private final static List<Integer> list2 = ImmutableList.of(1, 2, 3);

    private final static ImmutableList list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap<Integer,Integer> map2 = ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).build();


    public static void main(String[] args) {
//        list.add(4);
//        // 不会像上面一样 显示被废弃，但也会抛出异常
//        list2.add(4);
//
//        set.add(4);

//        map.put(1,1000);
//        map2.put(1,1000);
    }


}
