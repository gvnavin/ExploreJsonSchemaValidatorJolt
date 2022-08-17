package com.gvnavin.test.jolt

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.networknt.schema.JsonSchemaFactory
import com.networknt.schema.SpecVersion
import com.networknt.schema.ValidationMessage

const val inputForSchemaValidation = """{
    "id": 1,
    "name": "Lampshade",
    "price": 9
}"""

const val schema = """{
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
            "exclusiveMinimum": true
        }
    },
    "required": ["id", "name", "price"]
}"""

// https://www.baeldung.com/introduction-to-json-schema-in-java
fun main() {
    val factory: JsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4)
    val jsonSchema: com.networknt.schema.JsonSchema? = factory.getSchema(schema)
    val mapper = ObjectMapper()
    val jsonNode: JsonNode = mapper.readTree(inputForSchemaValidation)
    val errors: Set<ValidationMessage>? = jsonSchema?.validate(jsonNode)

    println("errors = ${errors}")

//    assertThat(erro?rs).isNotEmpty().asString().contains("price: must have a minimum value of 0")
}