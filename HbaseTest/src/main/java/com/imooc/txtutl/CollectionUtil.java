package com.imooc.txtutl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dell on 2020/8/11.
 */
public class CollectionUtil {

    /**
     * 求差集
     *
     * @param masterList 主数据列表
     * @param slaveList  从数据列表
     * @param <T>
     * @return
     */
    public static <T> List<T> getDifferenceSet(List<T> masterList, List<T> slaveList) {
        return masterList.stream().filter(t -> !slaveList.contains(t)).collect(Collectors.toList());
    }

    /**
     * 求并集
     *
     * @param masterList 主数据列表
     * @param slaveList  从数据列表
     * @param <T>
     * @return
     */
    public static <T> List<T> getUnionSet(List<T> masterList, List<T> slaveList) {
        List<T> list = new ArrayList<>();
        list.addAll(masterList);
        list.addAll(slaveList);
        return list.stream().distinct().collect(Collectors.toList());
    }
}
