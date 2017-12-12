package com.lab.test.annotationFeature;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by elotoma on 2017/12/12.
 */
public class UseCaseTracker {
    public static void trackUseCase(List<Integer> useCase, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " " + uc.decription() );
                // 自动装箱的歧义，发现存在int类型的重载方法，就不会再自动装箱了
                // 所以实际调用的函数原型是 remove(int index):移除第index个对象
                // useCase.remove(uc.id());
                useCase.remove(new Integer(uc.id()));
            }
        }

        for (int i : useCase) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48,49,50);

        trackUseCase(useCases, PasswordUtils.class);
    }
}
