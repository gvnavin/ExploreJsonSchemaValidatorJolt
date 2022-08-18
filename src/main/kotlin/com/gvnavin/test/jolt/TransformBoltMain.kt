package com.gvnavin.test.jolt

import com.bazaarvoice.jolt.Chainr
import com.bazaarvoice.jolt.JsonUtils;

val input = """
    {
      "rating": {
        "primary": {
          "value": 3
        },
        "quality": {
          "value": 3
        }
      }
    }
""".trimIndent()

val spec = """
[
    {
        "operation": "shift",
        "spec": {
            "rating": {
                "primary": {
                    "value": "Rating"
                },
                "*": {
                    "value": "SecondaryRatings.&1.Value",
                    "${'$'}": "SecondaryRatings.&.Id"
                }
            }
        }
    },
    {
        "operation": "default",
        "spec": {
            "Range" : 5,
            "SecondaryRatings" : {
                "*" : {
                    "Range" : 5
                }
            }
        }
    }
]
""".trimIndent()

fun main() {

    transform(spec, input)

}

// https://docs.google.com/presentation/d/1sAiuiFC4Lzz4-064sg1p8EQt2ev0o442MfEbvrpD1ls/edit#slide=id.g94901479_2113
// https://www.hascode.com/2017/01/transforming-and-reducing-json-structures-with-jolt/
// https://github.com/bazaarvoice/jolt/blob/master/gettingStarted.md
private fun transform(spec: String, input: String) {

    val chainrSpecJSON = JsonUtils.jsonToList(spec)
    val chainr = Chainr.fromSpec(chainrSpecJSON)

    val inputJSON = JsonUtils.jsonToObject(input)

    val transformedOutput = chainr.transform(inputJSON)
    println(JsonUtils.toPrettyJsonString(transformedOutput))
}