package com.knoldus
import java.io.IOException

trait Calculation{
  def divide(divident: Int,divisor: Int): Double
  def fibonacci(upto:Int):List[Int]
}

class CalculationImpl extends Calculation{
    // Function to divide a number by another number
    def divide(divident: Int,divisor: Int) :Double = {
        // Through Exception if a number is divided by zero
        if(divisor == 0){
            throw new ArithmeticException("Not divisible by zero") 
        }
        divident/divisor
    }
    // Return Fibonacci Sequence Up to a Certain Number
    def fibonacci(upto:Int):List[Int]={
        if(upto<0)
            throw new IllegalArgumentException("Negetive number not allowed") 
        var FibonacciSeries = List.empty[Int]
        var firstTerm = 0
        var secondTerm = 1
        var nextTerm=0
        while(nextTerm<=upto){
            // Append next term in the list
            FibonacciSeries=FibonacciSeries:+nextTerm
            firstTerm=secondTerm
            secondTerm=nextTerm
            nextTerm=firstTerm+secondTerm
        }
        FibonacciSeries
    }
}