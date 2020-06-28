package dongguabai.demo;

import dongguabai.demo.hash.ConsistentHashLoadBalance;
import dongguabai.demo.random.SimpleRandomLoadBalance;
import dongguabai.demo.random.CopyWeightRandomLoadBalance;
import dongguabai.demo.random.SectionWeightRandomLoadBalance;
import dongguabai.demo.roundrobin.CopyWeightRoundRobinLoadBalance;
import dongguabai.demo.roundrobin.SectionWeightRoundRobinLoadBalance;
import dongguabai.demo.roundrobin.SimpleRoundRobinLoadBalance;
import dongguabai.demo.roundrobin.SmoothWeightRoundRobinLoadBalance;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-24 10:57
 */
public class LoadBalanceTest {

    @Test
    public void testSimpleRandomLoadBalance(){
        List<Invoker> invokers = Lists.newArrayList(
                new Invoker("176.170.209.1"),
                new Invoker("176.170.209.2"),
                new Invoker("176.170.209.3"),
                new Invoker("176.170.209.4"),
                new Invoker("176.170.209.5"),
                new Invoker("176.170.209.6"),
                new Invoker("176.170.209.7"),
                new Invoker("176.170.209.8"),
                new Invoker("176.170.209.9"),
                new Invoker("176.170.209.10"));
        AbstractLoadBalance randomLoadBalance = new SimpleRandomLoadBalance(invokers);
        randomLoadBalance.result(20000);
    }

    @Test
    public void testCopyWeightRandomLoadBalance(){
        List<Invoker> invokers = Lists.newArrayList(
                new Invoker("176.170.209.1",1),
                new Invoker("176.170.209.2",9),
                new Invoker("176.170.209.3",1),
                new Invoker("176.170.209.4",9),
                new Invoker("176.170.209.5",4),
                new Invoker("176.170.209.6",6),
                new Invoker("176.170.209.7",1),
                new Invoker("176.170.209.8",9),
                new Invoker("176.170.209.9",1),
                new Invoker("176.170.209.10",9));
        AbstractLoadBalance simpleWeightRandomLoadBalance1 = new CopyWeightRandomLoadBalance(invokers);
        simpleWeightRandomLoadBalance1.result(20000);
    }

    @Test
    public void testWeightRandomLoadBalance(){
        List<Invoker> invokers = Lists.newArrayList(
                new Invoker("176.170.209.1",1),
                new Invoker("176.170.209.2",9),
                new Invoker("176.170.209.3",1),
                new Invoker("176.170.209.4",9),
                new Invoker("176.170.209.5",4),
                new Invoker("176.170.209.6",6),
                new Invoker("176.170.209.7",1),
                new Invoker("176.170.209.8",9),
                new Invoker("176.170.209.9",1),
                new Invoker("176.170.209.10",9));
        AbstractLoadBalance simpleWeightRandomLoadBalance1 = new SectionWeightRandomLoadBalance(invokers);
        simpleWeightRandomLoadBalance1.result(20000);
    }

    @Test
    public void testSimpleRoundRobinLoadBalance(){
        List<Invoker> invokers = Lists.newArrayList(
                new Invoker("176.170.209.1"),
                new Invoker("176.170.209.2"),
                new Invoker("176.170.209.3"),
                new Invoker("176.170.209.4"),
                new Invoker("176.170.209.5"),
                new Invoker("176.170.209.6"),
                new Invoker("176.170.209.7"),
                new Invoker("176.170.209.8"),
                new Invoker("176.170.209.9"),
                new Invoker("176.170.209.10"));
        AbstractLoadBalance roundRobinLoadBalance = new SimpleRoundRobinLoadBalance(invokers);
        IntStream.range(0,22).parallel().forEach(i-> System.out.println(roundRobinLoadBalance.selectHost()));
    }

    @Test
    public void testCopyWeightRoundRobinLoadBalance(){
        List<Invoker> invokers = Lists.newArrayList(
                new Invoker("176.170.209.1",1),
                new Invoker("176.170.209.2",9),
                new Invoker("176.170.209.3",1),
                new Invoker("176.170.209.4",9),
                new Invoker("176.170.209.5",4),
                new Invoker("176.170.209.6",6),
                new Invoker("176.170.209.7",1),
                new Invoker("176.170.209.8",9),
                new Invoker("176.170.209.9",1),
                new Invoker("176.170.209.10",9));
        AbstractLoadBalance copyWeightRoundRobinLoadBalance = new CopyWeightRoundRobinLoadBalance(invokers);
        IntStream.range(0,50).forEach(i-> System.out.println(copyWeightRoundRobinLoadBalance.selectHost()));
       // copyWeightRoundRobinLoadBalance.result(20000);
    }

    @Test
    public void testSectionWeightRoundRobinLoadBalance(){
        List<Invoker> invokers = Lists.newArrayList(
                new Invoker("176.170.209.1",1),
                new Invoker("176.170.209.2",9),
                new Invoker("176.170.209.3",1),
                new Invoker("176.170.209.4",9),
                new Invoker("176.170.209.5",4),
                new Invoker("176.170.209.6",6),
                new Invoker("176.170.209.7",1),
                new Invoker("176.170.209.8",9),
                new Invoker("176.170.209.9",1),
                new Invoker("176.170.209.10",9));
        AbstractLoadBalance sectionWeightRoundRobinLoadBalance = new SectionWeightRoundRobinLoadBalance(invokers);
        IntStream.range(0,50).forEach(i-> System.out.println(sectionWeightRoundRobinLoadBalance.selectHost()));
    }

    @Test
    public void testSmoothWeightRoundRobinLoadBalance(){
        List<Invoker> invokers = Lists.newArrayList(
                new Invoker("A",1),
                new Invoker("B",2),
                new Invoker("C",3));
        AbstractLoadBalance smoothWeightRoundRobinLoadBalance = new SmoothWeightRoundRobinLoadBalance(invokers);
        IntStream.range(0,12).parallel().forEach(i-> System.out.println(smoothWeightRoundRobinLoadBalance.selectHost()));
        System.out.println(smoothWeightRoundRobinLoadBalance.getInvokers());
    }

    @Test
    public void testConsistentHashLoadBalance(){
        List<Invoker> invokers = Lists.newArrayList(
                new Invoker("176.170.209.1",1),
                new Invoker("176.170.209.2",9),
                new Invoker("176.170.209.3",1),
                new Invoker("176.170.209.4",9),
                new Invoker("176.170.209.5",4),
                new Invoker("176.170.209.6",6),
                new Invoker("176.170.209.7",1),
                new Invoker("176.170.209.8",9),
                new Invoker("176.170.209.9",1),
                new Invoker("176.1709.10",9));
        AbstractLoadBalance consistentHashLoadBalance = new ConsistentHashLoadBalance(invokers);
        consistentHashLoadBalance.result(1000000);
        Invoker changeInvoker = new Invoker("176.1709.11", 1);
        System.out.println("add......");
        consistentHashLoadBalance.addInvoker(changeInvoker);
        consistentHashLoadBalance.result(1000000);
        System.out.println("remove.....");
        consistentHashLoadBalance.removeInvoker(changeInvoker);
        consistentHashLoadBalance.result(1000000);
    }
}
