/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;

/**
 *
 * @author sirac
 */
@Stateless
public class CalculatorBean implements CalculatorBeanLocal {

    @Override
    public int Add(int num1, int num2) {
        return num1+num2;
    }

    @Override
    public int Sub(int num1, int num2) {
        return num1-num2;
    }

    @Override
    public int Mul(int num1, int num2) {
        return num1*num2;
    }

    @Override
    public float Divide(int num1, int num2) {
        return 0.0F;
    }
 
    
}
