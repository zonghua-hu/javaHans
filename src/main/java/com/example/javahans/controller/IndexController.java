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
//        empOne.setDescription("???????????????");
//
//        empTwo.setDescription("???????????????");
//        empTwo.empAge(33);
//        empTwo.setSalary(8000.00);
//
//        empOne.printEmployee();
//        empTwo.printEmployee();

        //?????????for??????==php???foreach
//        int [] arrayAge = {10,20,30,40,50,60};
//        for (int ageInfo: arrayAge) {
//            System.out.println(ageInfo);
//        }

//        Integer hansAge = 30;
//        hansAge += 20;
//        System.out.println(hansAge);

//        char c;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("???????????????");
//        do {
//            c = (char)br.read();
//            System.out.println(c);
//        } while (c != 'q');
//        System.out.println("????????????");

//        show(new DogAnimal());
//        show(new CatAnimal());

//        String s1 = new StringBuilder("go").append("od").toString();
//        System.out.println(s1.intern() == s1);
//        String s2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(s2.intern() == s2);

        //??????
        //???????????????????????????NoBug????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????invoke
        //??????????????????????????????????????????????????????????????????????????????????????????????????????
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

        //?????????????????????+??????????????????????????????????????????????????????
//        BigInteger aBig = BigInteger.valueOf(100);
//        BigInteger bBig = BigInteger.valueOf(200);
//        BigDecimal bd = new BigDecimal("0.102");
//        System.out.println(aBig.add(bBig));

        //???????????????????????????
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
        //break?????????????????????????????????
//        for (int i=0;i<10;i++) {
//            for (int j=0;j<10;j++) {
//                if (i==j) {
//                    break;
//                }
//                System.out.println("i*j="+(i*j));
//            }
//            System.out.println("i==j" + i);
//        }

//        //??????
//        Point<String> p = new Point<String>() ; // ?????????var?????????String??????
//        p.setLength("it"); ;        // ???????????????
//        System.out.println(p.getLength().length()) ;   // ????????????????????????

        //??????
//        /**
//         * ??????TargetObject??????Class??????????????????TargetObject?????????
//         */
//        Class<?> target = Class.forName("com.example.javahans.logic.TargetObject");
//        TargetObject targets = (TargetObject)target.getDeclaredConstructor().newInstance();
//        /**
//         * ???????????????????????????
//         */
//        Method[] methods = target.getDeclaredMethods();
//        for (Method method:methods) {
//            System.out.println(method.getName());
//        }
//        /**
//         *??????????????????
//         */
//        Method publicMethod = target.getDeclaredMethod("publicMethod", String.class);
//        publicMethod.invoke(targets, "hans");
//        /**
//         * ???????????????????????????????????????????????????
//         */
//        Field field = target.getDeclaredField("value");
//        field.setAccessible(true);
//        field.set(targets, "hans1234");
//        Method privateMethod = target.getDeclaredMethod("privateMethod");
//        privateMethod.setAccessible(true);
//        privateMethod.invoke(targets);

        //??????--???????????????????????????????????????
//        SmsService service = (SmsService) JdkProxyFactory.getProxy(new SmsServiceTmpl());
//        service.send("hans1234");
        //????????????+redis????????????
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
//        System.out.printf("?????????%d", clientCount);
//        System.out.printf("?????????%d", end-start);
//        System.out.printf("count??????%d", count);

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
     * ????????????
     * @return
     */
    public Object errorCallBack()
    {
        return "???????????????";
    }
}
