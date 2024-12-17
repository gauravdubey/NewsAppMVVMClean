package com.example.newsappwithmvvmclean.data.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
   /* runBlocking {
        concurrentTask()
    }*/
    val n = 15
    /*for (i in 1 .. n step 2){
        println("First type loop : $i")
    }
    for (i in 1 until  n step 2){
        println("Second type loop : $i")
    }
    for (i in n downTo   1 step 2){
        println("Third type loop : $i")
    }*/
//    var fn = ::addition
//    println(fn(2, 3))
    var arr= arrayOf("one","two","three")
    var arr2= arrayOf(1,2,3)
    val list1= listOf(1,2,3,4,5,)
    var list2= mutableListOf(7,8,9,10)
    list2.addAll(list1)
    var map1= mutableMapOf<Int,String>()
    var map2= hashMapOf<Int,String>()
    map1.put(1,"Gaurav")
    map1.put(2,"Rahul")
    map2.put(3,"Gagan")
    map2.put(4,"Ramesh")
    for ((key,value) in map1){
        println("$key = $value")
    }
    for ((key,value) in map2){
        println("$key = $value")
    }
//    println(map2.get(3))
    /*for (i in arr2){
        println(i)
    }*/
    /*arr.set(0,"four")
    for ((i, e )in arr.withIndex()){
        println("$i -> $e")
    }*/
//    println("Name: ${CompanCls.name} and Age : ${CompanCls.age}")
//    println("Name: ${CompanCls.B.name} and Age : ${CompanCls.B.age}")

//    calculator(5.0,6.0,::sum)
}

fun addition(a: Int, b: Int) = a + b



open class calculator{
    open fun add(a:Int,b:Int):Int{
        return a+b
    }
    fun substract(a:Int,b:Int):Int{
        return a-b
    }
}

class Employee : calculator() {
    override
    fun add(a: Int, b: Int): Int {
        return a+b
    }
}
class CompanCls{
    companion object A{
        var age=10
        var name="Gaurav"
    }
    object B{
        var age=20
        var name="Rahul"

    }
}
fun sum(a:Double,b:Double):Double{
    return a+b;
}
//High Order function
fun calculator(a: Double,b:Double,fn:(Double,Double)->Double){
    val result=fn(a,b)
    println(result)
}


/**
 * Concurrent task and return the result
 */
suspend fun concurrentTask() {
    val result1 = CoroutineScope(Dispatchers.Default).async {
        fetchData1()
    }
    val result2 = CoroutineScope(Dispatchers.Default).async {
        fetchData2()
    }
    val finalResult=result1.await()+result2.await();
    println("Final Result: $finalResult")
}

suspend fun fetchData1(): String {
    delay(100)
    return "Data from fetchData1"
}

suspend fun fetchData2(): String {
    delay(100)
    return "Data from fetchData2"
}