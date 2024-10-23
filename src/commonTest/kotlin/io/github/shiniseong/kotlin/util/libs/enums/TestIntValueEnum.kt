package io.github.shiniseong.kotlin.util.libs.enums

import io.github.shiniseong.kotlin.util.libs.ValuedEnumClass
import io.github.shiniseong.kotlin.util.libs.ValuedEnumCompanion

enum class TestIntValueEnum(override val value: Int) : ValuedEnumClass<Int> {
    T1(1),
    T2(2),
    T3(3)
    ;

    companion object : ValuedEnumCompanion<Int, TestIntValueEnum>(entries)
}

typealias TestIntValueEnumValue = Int

fun TestIntValueEnumValue.toTestIntValueEnum(): TestIntValueEnum = TestIntValueEnum.fromValue(this)
