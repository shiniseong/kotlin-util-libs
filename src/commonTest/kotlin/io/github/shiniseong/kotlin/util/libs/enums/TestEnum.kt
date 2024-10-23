package io.github.shiniseong.kotlin.util.libs.enums

import io.github.shiniseong.kotlin.util.libs.ValuedEnumClass
import io.github.shiniseong.kotlin.util.libs.ValuedEnumCompanion

enum class TestEnum(override val value: String) : ValuedEnumClass<String> {
    A("1"),
    B("2"),
    C("3")
    ;

    companion object : ValuedEnumCompanion<String, TestEnum>(entries)
}

typealias TestEnumValue = String

fun TestEnumValue.toTestEnum(): TestEnum = TestEnum.fromValue(this)
