package io.github.shiniseong.kotlin.util.libs.enums

import io.github.shiniseong.kotlin.util.libs.enums.exception.NoSuchEnumValueException
import kotlin.enums.EnumEntries

abstract class ValuedEnumCompanion<V : Any, E>(
    private val entries: EnumEntries<E>
) : FromValue<V, E> where E : Enum<E>, E : ValuedEnumClass<V> {
    override fun fromValue(value: V): E =
        entries.firstOrNull { it.value == value } ?: throw NoSuchEnumValueException(value)
}

interface FromValue<ValueT, EnumT : Enum<EnumT>> {
    fun fromValue(value: ValueT): EnumT
}

fun <V : EnumValue, E, C : ValuedEnumCompanion<V, E>> V.toValuedEnum(companion: C): E = companion.fromValue(this)

typealias EnumValue = Any