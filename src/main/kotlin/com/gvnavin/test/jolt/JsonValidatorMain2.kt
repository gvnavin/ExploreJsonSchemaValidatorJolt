package com.gvnavin.test.jolt

import net.pwall.json.schema.JSONSchema

const val inputForSchemaValidation2 = """{
    "id": 1,
    "name": "Lampshade",
    "price": 10
}"""

const val schema2 = """{
    "schema": "http://json-schema.org/draft-04/schema#",
    "title": "Product",
    "description": "A product from the catalog",
    "type": "object",
    "properties": {
        "id": {
            "description": "The unique identifier for a product",
            "type": "integer"
        },
        "name": {
            "description": "Name of the product",
            "type": "string"
        },
        "price": {
            "type": "number",
            "minimum": 0,
            "exclusiveMinimum": 0
        }
    },
    "required": ["id", "name", "price"]
}"""

// https://www.baeldung.com/introduction-to-json-schema-in-java
fun main() {

    val schema = JSONSchema.parse(schema2)
    val validate = schema.validate(inputForSchemaValidation2)
    println("validate = ${validate}")

    val validateBasic = schema.validateBasic(inputForSchemaValidation2)
    println("validateBasic.valid = ${validateBasic.valid}")
    validateBasic.errors?.forEach{
        println("${it.error} - ${it.instanceLocation}")
    }

//    val validateDetailed = schema.validateDetailed(inputForSchemaValidation2)
//    println("validateDetailed.valid = ${validateDetailed.valid}")
//    validateDetailed.errors?.forEach{
//        println("validateDetailed.errors - ${it.valid}")
//    }
//    println("validateDetailed.error = ${validateDetailed.error}")
//    println("validateDetailed.error = ${validateDetailed.}")

}