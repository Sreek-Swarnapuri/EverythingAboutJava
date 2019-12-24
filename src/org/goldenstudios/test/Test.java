package org.goldenstudios.test;

public class Test {

    public void printIt(){
        System.out.println(Test.class.getClassLoader());
        System.out.println(getClass().getClassLoader());
    }

    public static void main(String[] args){

        Test t = new Test();
        t.printIt();

    }

}