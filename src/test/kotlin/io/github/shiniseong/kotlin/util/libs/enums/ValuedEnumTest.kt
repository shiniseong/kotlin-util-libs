package io.github.shiniseong.kotlin.util.libs.enums

import io.github.shiniseong.kotlin.util.libs.enums.exception.NoSuchEnumValueException
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class ValuedEnumTest {
    @Test
    fun `제대로 된 값이 주어진 경우 - String`() {
        assertEquals("1".toTestEnum(), TestEnum.A)
    }

    @Test
    fun `제대로 된 값이 주어지지 않은 경우 - String`() {
        val exception = assertThrows<NoSuchEnumValueException> {
            "5".toTestEnum()
        }
        assertEquals("No such enum value: 5", exception.message)
    }

    @Test
    fun `제대로 된 값이 주어진 경우 - Int`() {
        assertEquals(1.toTestIntValueEnum(), TestIntValueEnum.T1)
    }

    @Test
    fun `제대로 된 값이 주어지지 않은 경우 - Int`() {
        val exception = assertThrows<NoSuchEnumValueException> {
            5.toTestIntValueEnum()
        }
        assertEquals("No such enum value: 5", exception.message)
    }

    @Test
    fun `V toValuedEnum(companion C) 확장 함수 테스트 - String`() {
        assertEquals("1".toValuedEnum(TestEnum.Companion), TestEnum.A)
    }

    @Test
    fun `V toValuedEnum(companion C) 확장 함수 테스트 - Int`() {
        assertEquals(1.toValuedEnum(TestIntValueEnum.Companion), TestIntValueEnum.T1)
    }

}