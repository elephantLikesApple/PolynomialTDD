package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalcTest {
    @Test
    @DisplayName("trim()")
    void t0() {
        assertThat(Calc.run(" 50 + 20      ")).isEqualTo(70);
    }

    @Test
    @DisplayName("1 + 1 == 2")
    void t1() {
        assertThat(Calc.run("1 + 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("2 + 1 == 3")
    void t2() {
        assertThat(Calc.run("2 + 1")).isEqualTo(3);
    }

    @Test
    @DisplayName("2 + 2 == 4")
    void t3() {
        assertThat(Calc.run("2 + 2")).isEqualTo(4);
    }

    @Test
    @DisplayName("1000 + 280 == 1280")
    void t4() {
        assertThat(Calc.run("1000 + 280")).isEqualTo(1280);
    }

    @Test
    @DisplayName("50 - 30 == 20")
    void t5() {
        assertThat(Calc.run("50 - 20")).isEqualTo(30);
    }

    @Test
    @DisplayName("3 - 1 == 2")
    void t6() {
        assertThat(Calc.run("3 - 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("100 - 20 == 80")
    void t7() {
        assertThat(Calc.run("100 - 20")).isEqualTo(80);
    }

    @Test
    @DisplayName("10 + 20 + 30 == 60")
    void t8() {
        assertThat(Calc.run("10 + 20 + 30")).isEqualTo(60);
    }

    @Test
    @DisplayName("10 - 20 + 30 == 20")
    void t9() {
        assertThat(Calc.run("10 - 20 + 30")).isEqualTo(20);
    }

    @Test
    @DisplayName("10 - 10 - 10 - 10 == -20")
    void t10() {
        assertThat(Calc.run("10 - 10 - 10 - 10")).isEqualTo(-20);
    }

    @Test
    @DisplayName("10 - 10 - 10 - 10 -1 -1 -1 -1 -1 == -25")
    void t11() {
        assertThat(Calc.run("10 - 10 - 10 - 10 - 1 - 1 - 1 - 1 - 1")).isEqualTo(-25);
    }

    @Test
    @DisplayName("10 * 10 == 100")
    void t12() {
        assertThat(Calc.run("10 * 10")).isEqualTo(100);
    }

    @Test
    @DisplayName("10 * 10 * 10 == 1000")
    void t13() {
        assertThat(Calc.run("10 * 10 * 10")).isEqualTo(1000);
    }
}
