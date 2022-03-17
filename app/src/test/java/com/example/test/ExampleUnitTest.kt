package com.example.test

import org.testng.Assert
import org.testng.annotations.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        System.out.print("testing the new stuff")
        Assert.assertEquals(4,2+2)
    }
}
