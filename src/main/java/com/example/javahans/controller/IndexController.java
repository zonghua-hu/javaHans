package com.example.javahans.controller;

import com.example.javahans.annotion.TestMathAnnotion;
import com.example.javahans.proxy.alisms.AliSmsMethodInterceptor;
import com.example.javahans.proxy.alisms.AliSmsService;
import com.example.javahans.proxy.jdkProxy.HansProxyFactory;
import com.example.javahans.proxy.sms.SmsService;
import com.example.javahans.proxy.sms.SmsServiceTmpl;
import com.example.javahans.proxy.handel.JdkProxyFactory;
import com.example.javahans.redis.RedisLock;
import com.example.javahans.utils.SnowFlakeId;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.sf.cglib.proxy.Enhancer;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.javahans.service.polymorphism.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@RestController
@ResponseBody
//@EnableCircuitBreaker
@RequestMapping("index")
public class IndexController
{
    RedisLock redisLock;
    int count = 0;

    //    Logger logger = (Logger) LoggerFactory.getLogger(Logger.class);
    @GetMapping("info")
//    @HystrixCommand(fallbackMethod="errorCallBack")
    public String index() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, InterruptedException {
//        Dog dog = new Dog("tomDog");
//        dog.setDogAge(11);
//        System.out.println(dog.getDogAge());

//        Employ empOne = new Employ("Tom");
//        Employ empTwo = new Employ("Sam");
//
//        empOne.empAge(21);
//        empOne.age = 33;
//        empOne.setSalary(1000.00);
//        empOne.setDescription("低级程序员");
//
//        empTwo.setDescription("高级程序员");
//        empTwo.empAge(33);
//        empTwo.setSalary(8000.00);
//
//        empOne.printEmployee();
//        empTwo.printEmployee();

        //增强型for循环==php的foreach
//        int [] arrayAge = {10,20,30,40,50,60};
//        for (int ageInfo: arrayAge) {
//            System.out.println(ageInfo);
//        }

//        Integer hansAge = 30;
//        hansAge += 20;
//        System.out.println(hansAge);

//        char c;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符：");
//        do {
//            c = (char)br.read();
//            System.out.println(c);
//        } while (c != 'q');
//        System.out.println("输入结束");

//        show(new DogAnimal());
//        show(new CatAnimal());

//        String s1 = new StringBuilder("go").append("od").toString();
//        System.out.println(s1.intern() == s1);
//        String s2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(s2.intern() == s2);

        //注解
        //这里先通过反射拿到NoBug类的所有方法，然后在判断哪个方法有注解，对于有注解的方法，我们执行一下此方法，用invoke
        //这里是对注解的一个简单应用，就是说基于注解来判断哪些方法需要进行测试
//        NoBug noBug = new NoBug();
//        Method[] methods = NoBug.class.getDeclaredMethods();
//        StringBuilder log = new StringBuilder();
//        int errorNum = 0;
//        for (Method m: methods) {
//            if (m.isAnnotationPresent(TestMathAnnotion.class)) {
//                try {
//                    m.setAccessible(true);
//                    m.invoke(noBug, null);
//                } catch (Exception e) {
//                    errorNum++;
//                    log.append(m.getName());
//                    log.append(" ");
//                    log.append("has error:");
//                    log.append("\n\r caused by");
//                    log.append(e.getCause().getClass().getSimpleName());
//                    log.append("\n\r");
//                }
//            }
//        }
////        log.append(clazz.getSimpleName());
//        log.append("has:");
//        log.append(errorNum);
//        log.append(" error.");

//        int a = 3;
//        int b = 5;
//        System.out.println(a+b);

        //大数值没有重载+运算符，必须要调用指定的加减乘除方法
//        BigInteger aBig = BigInteger.valueOf(100);
//        BigInteger bBig = BigInteger.valueOf(200);
//        BigDecimal bd = new BigDecimal("0.102");
//        System.out.println(aBig.add(bBig));

        //数组循环和打印数组
//        int arr[] = {1,2,3,4,5,6,7,8,98,9,22};
//        for (int element: arr) {
//            System.out.println(element);
//        }
//        System.out.println(Arrays.toString(arr));

//        ArrayList arr = new ArrayList();
//        arr.add(12);
//        arr.add(13);
//        arr.add(12);
//        arr.add(13);
//        arr.add(12);
//        arr.add(13);
//        for (int i=0; i< arr.size();i++) {
//            System.out.println(arr.get(i));
//        }
        //break每次只跳出当前的循环体
//        for (int i=0;i<10;i++) {
//            for (int j=0;j<10;j++) {
//                if (i==j) {
//                    break;
//                }
//                System.out.println("i*j="+(i*j));
//            }
//            System.out.println("i==j" + i);
//        }

//        //泛型
//        Point<String> p = new Point<String>() ; // 里面的var类型为String类型
//        p.setLength("it"); ;        // 设置字符串
//        System.out.println(p.getLength().length()) ;   // 取得字符串的长度

        //反射
//        /**
//         * 获取TargetObject类的Class对象并且创建TargetObject类实例
//         */
//        Class<?> target = Class.forName("com.example.javahans.logic.TargetObject");
//        TargetObject targets = (TargetObject)target.getDeclaredConstructor().newInstance();
//        /**
//         * 获取对象的全部方法
//         */
//        Method[] methods = target.getDeclaredMethods();
//        for (Method method:methods) {
//            System.out.println(method.getName());
//        }
//        /**
//         *调用指定方法
//         */
//        Method publicMethod = target.getDeclaredMethod("publicMethod", String.class);
//        publicMethod.invoke(targets, "hans");
//        /**
//         * 获取指定参数进行修改并取消安全检查
//         */
//        Field field = target.getDeclaredField("value");
//        field.setAccessible(true);
//        field.set(targets, "hans1234");
//        Method privateMethod = target.getDeclaredMethod("privateMethod");
//        privateMethod.setAccessible(true);
//        privateMethod.invoke(targets);

        //代理--自己实现（底层原理是反射）
//        SmsService service = (SmsService) JdkProxyFactory.getProxy(new SmsServiceTmpl());
//        service.send("hans1234");
        //雪花算法+redis分布式锁
//        int clientCount = 1000;
//        SnowFlakeId snowFlakeId = new SnowFlakeId(0L, 0L);
//        CountDownLatch countDownLatch = new CountDownLatch(clientCount);
//        ExecutorService executorService = Executors.newFixedThreadPool(clientCount);
//        long start = System.currentTimeMillis();
//        for (int i=0;i<clientCount;i++) {
//            executorService.execute(()->{
//                String id = snowFlakeId.generateNextId();
//                try {
//                    redisLock.lock(id);
//                    count++;
//                } finally {
//                    redisLock.unlock(id);
//                }
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        long end = System.currentTimeMillis();
//        System.out.printf("线程数%d", clientCount);
//        System.out.printf("总耗时%d", end-start);
//        System.out.printf("count总数%d", count);

        return "hello world";
    }

    /**
     *
     * @param animal
     */
    public static void show(Animal animal)
    {
        animal.eat();
    }
    @PostMapping("hello")
    public String hello()
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AliSmsService.class);
        enhancer.setCallback(new AliSmsMethodInterceptor());

        AliSmsService aliSmsService = (AliSmsService) enhancer.create();
        aliSmsService.send("hello hans 1234567");

        return "hello java";
    }
    /**
     * 服务降级
     * @return
     */
    public Object errorCallBack()
    {
        return "请稍后重试";
    }
}
