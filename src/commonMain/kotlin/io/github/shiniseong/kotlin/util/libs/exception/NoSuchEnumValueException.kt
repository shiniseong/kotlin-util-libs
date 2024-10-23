package io.github.shiniseong.kotlin.util.libs.enums.exception

class NoSuchEnumValueException(value: Any) : IllegalArgumentException("No such enum value: $value")