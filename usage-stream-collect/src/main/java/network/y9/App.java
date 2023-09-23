package network.y9;

/**
 * collect 处理
 *
 * 1. collectors 收集，元素不会发毫升变化
 * list.stream().collect(Collectors.toList())
 * toSet,
 * toCollection
 * 2. 计算比较汇总
 * collectors.summingInt()：对流中元素的整数属性求和
 * counting：计算流中元素的个数
 * averagingInt：计算流中元素整数属性的平均值
 * summarizingInt：计算流中Integer属性的统计值，例如平均值
 * joining：连接流中的每一个字符串
 * maxBy()：根据比较器获取最大值
 * mingBy(): 根据比较器获取最小值
 * reducing(): 归约
 * countingAndThen：统计后处理
 * 3. 分区分组
 * collectors.groupingBy()：根据属性分组，k为属性值，v为指定值
 * partitioningBy()：根据true或者false进行分区
 *
 */
public class App 
{
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );
    }
}
