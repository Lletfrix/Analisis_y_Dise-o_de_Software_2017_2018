package com.test;

import com.practica3.Butaca;

public class ButacaTest {

    public static void main(String[] args) {
        int numTests, totalTests;
	    Butaca b = new Butaca(3, 4);
	    numTests = totalTests = 0;
	    if(b.getColumna()==4 && b.getFila()==3 && b.isFree()==true){
	        System.out.println("Los getters funcionan correctamente.");
	        numTests++;
        }
        totalTests++;
        b.setFree(false);
	    if(b.isFree()==false){
	        System.out.println("Los setters funcionan correctamente.");
	        numTests++;
        }
        totalTests++;
	    System.out.println(numTests+"/"+totalTests+" test(s) fueron correctos.");
    }
}
