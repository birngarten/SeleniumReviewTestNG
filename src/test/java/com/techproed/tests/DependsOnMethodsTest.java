package com.techproed.tests;

import org.testng.annotations.Test;

public class DependsOnMethodsTest {

    @Test(dependsOnMethods = "test02")
    public void test01(){

        System.out.println("test01");
    }

    @Test
    public void test02(){

        System.out.println("test02");
    }

    @Test
    public void test03(){

        System.out.println("test03");
    }
}
