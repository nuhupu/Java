/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Local;

/**
 *
 * @author sirac
 */
@Local
public  interface CalculatorBeanLocal {

    int Add(int num1, int num2);

    int Sub(int num1, int num2);

    int Mul(int num1, int num2);

    float Divide(int num1, int num2);
    
}
