package org.example

import com.dslplatform.json.CompiledJson
import com.dslplatform.json.DslJson
import com.dslplatform.json.runtime.Settings
import java.io.FileOutputStream

@CompiledJson
abstract class A(val t: String)

@CompiledJson
class B(val r: String): A("hello")
fun main() {
    val dsljson = DslJson(
        Settings.basicSetup<Any>()
            .skipDefaultValues(false)
            .includeServiceLoader()
    )
    FileOutputStream("t.json").use {
        dsljson.serialize(B("toto"), it)
    }
}

