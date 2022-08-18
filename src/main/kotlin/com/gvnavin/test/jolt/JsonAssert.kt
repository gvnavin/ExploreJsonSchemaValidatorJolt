package com.gvnavin.test.jolt

import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode

fun main() {

    val actual = """{
            id: 123, 
            name: "John"
       }"""

    JSONAssert.assertEquals(
        """{
                id: 123,
                name: "John"
            }""", actual, JSONCompareMode.STRICT
    )

}