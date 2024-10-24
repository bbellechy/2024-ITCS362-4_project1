/* Copyright (C) 2024 Kunlaphorn Rattanatarin - All Rights Reserved * You may use, distribute and modify this code under the terms of the MIT license. */

package com.houarizegai.calculator;

import com.houarizegai.calculator.ui.CalculatorUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTestsuite7_8 {

    private CalculatorUI calculatorUI;
    private JTextField inputScreen;
    private JButton btnRoot, btnPower, btnLog;
    @BeforeEach
    void setUp() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        calculatorUI = new CalculatorUI();

        Method initCalculatorTypeSelector = CalculatorUI.class.getDeclaredMethod("initCalculatorTypeSelector");
        initCalculatorTypeSelector.setAccessible(true);
        initCalculatorTypeSelector.invoke(calculatorUI);


        Field btnRootField = CalculatorUI.class.getDeclaredField("btnRoot");
        btnRootField.setAccessible(true);
        btnRoot = (JButton) btnRootField.get(calculatorUI);

        Field btnPowerField = CalculatorUI.class.getDeclaredField("btnPower");
        btnPowerField.setAccessible(true);
        btnPower = (JButton) btnPowerField.get(calculatorUI);

        Field btnLogField = CalculatorUI.class.getDeclaredField("btnLog");
        btnLogField.setAccessible(true);
        btnLog = (JButton) btnLogField.get(calculatorUI);

        // เข้าถึง inputScreen
        Field inputScreenField = CalculatorUI.class.getDeclaredField("inputScreen");
        inputScreenField.setAccessible(true);
        inputScreen = (JTextField) inputScreenField.get(calculatorUI);

    }



    // 7. Test Suite: Scientific Functions
    @Test
    public void testSquareRoot() {
        // กำหนดค่า inputScreen เป็น 1
        inputScreen.setText("1");

        // จำลองการกดปุ่ม √
        btnRoot.doClick();

        // ค่าที่คาดหวังคือ 1
        assertEquals("1", inputScreen.getText(), "Input screen should show the correct square root value");
    }

    @Test
    public void testPowerCalculation() throws NoSuchFieldException, IllegalAccessException {
        // Step 1: กำหนดค่า inputScreen เป็นฐาน (0.5)
        inputScreen.setText("0.5");

        // Step 2: กดปุ่ม pow ครั้งแรก (กำหนดฐาน)
        btnPower.doClick();  // selectedOperator = '^', go = false

        // Step 3: ตั้งค่า go = true เพื่อจำลองสถานะการคำนวณรอบถัดไป
        Field goField = calculatorUI.getClass().getDeclaredField("go");
        goField.setAccessible(true);
        goField.set(calculatorUI, true);

        // Step 4: กำหนดค่า inputScreen เป็นเลขชี้กำลัง (0.5)
        inputScreen.setText("0.5");

        // Step 5: กดปุ่ม pow ครั้งที่สอง (ทำการคำนวณ 0.5 ^ 0.5)
        btnPower.doClick();


        // ตรวจสอบผลลัพธ์ที่ได้จาก inputScreen
        assertEquals("0.7071067811865476", inputScreen.getText());
    }

    @Test
    public void testLogarithm() {
        // กำหนดค่า inputScreen เป็น 1
        inputScreen.setText("1");

        // จำลองการกดปุ่ม ln
        btnLog.doClick();

        // ค่าที่คาดหวังคือ ln(1) = 0
        assertEquals("0", inputScreen.getText(), "Input screen should show the correct logarithm value");
    }

    @Test
    public void testCalculatorFunctions() throws Exception {
        // Test Case T1: คำนวณ √2
        inputScreen.setText("2"); // ตั้งค่า inputScreen เป็น 2
        btnRoot.doClick(); // กดปุ่ม √
        double expectedSqrt = Math.sqrt(2);
        assertEquals(expectedSqrt, Double.parseDouble(inputScreen.getText()), "Input screen should show the correct square root value for 2");

        // Test Case T2: คำนวณ 2^0
        inputScreen.setText("2"); // ตั้งค่า inputScreen เป็น 2
        btnPower.doClick(); // กดปุ่ม pow เพื่อเก็บฐาน

        // ใช้ Reflection เพื่อเข้าถึงฟิลด์ go
        Field goField = calculatorUI.getClass().getDeclaredField("go");
        goField.setAccessible(true);
        goField.set(calculatorUI, true); // ตั้งค่า go เป็น true

        inputScreen.setText("0"); // ตั้งค่า inputScreen เป็น 0 (เลขชี้กำลัง)
        btnPower.doClick(); // กดปุ่ม pow อีกครั้ง

        double expectedPow = Math.pow(2, 0);
        assertEquals(expectedPow, Double.parseDouble(inputScreen.getText()), "Input screen should show the correct power value for 2^0");
    }

    @Test
    public void testNaturalLog() throws Exception {
        // ตั้งค่า inputScreen เป็น 10
        inputScreen.setText("10");

        // กดปุ่ม ln
        btnLog.doClick();

        // คำนวณลอการิธึมของ 10
        double expectedLog = Math.log(10);

        // ตรวจสอบว่า inputScreen แสดงค่าที่คาดหวัง
        assertEquals(expectedLog, Double.parseDouble(inputScreen.getText()), "Input screen should show the correct natural log value for 10");
    }


    // 8. Test Suite: initInputScreen

    @Test
    public void testInitInputScreen_testcase1() throws Exception {
        int[] columns = {1,2,3,4} ; // ตัวอย่างค่า columns
        int[] rows = {1,2,3,4} ;    // ตัวอย่างค่า rows
        // เข้าถึง method initInputScreen โดยใช้ reflection
        Method method = CalculatorUI.class.getDeclaredMethod("initInputScreen", int[].class, int[].class);
        method.setAccessible(true); // ให้สามารถเข้าถึงเมธอด private ได้

        // เรียกใช้ method ด้วยค่า columns และ rows
        method.invoke(calculatorUI, columns, rows);

        // ใช้ reflection เพื่อเข้าถึงตัวแปร inputScreen
        Field field = CalculatorUI.class.getDeclaredField("inputScreen");
        field.setAccessible(true); // ให้สามารถเข้าถึงตัวแปร private ได้

        // ตรวจสอบค่าของ inputScreen ว่าตรงตามที่คาดหวัง
        JTextField inputScreen = (JTextField) field.get(calculatorUI);

        assertEquals("0", inputScreen.getText(), "Input screen initial value should be '0'");
        assertEquals(false, inputScreen.isEditable(), "Input screen should not be editable");
        assertEquals(Color.WHITE, inputScreen.getBackground(), "Input screen background should be white");
        assertEquals(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 33), inputScreen.getFont(), "Font should match expected settings");

        // ตรวจสอบตำแหน่งและขนาด
        assertEquals(1, inputScreen.getX(), "X position should match columns[0]");
        assertEquals(1, inputScreen.getY(), "Y position should match rows[0]");
        assertEquals(350, inputScreen.getWidth(), "Width should be 350");
        assertEquals(70, inputScreen.getHeight(), "Height should be 70");
    }


    @Test
    public void testInitInputScreen_testcase2() throws Exception {
        int[] columns = {10}; // ตัวอย่างค่า columns
        int[] rows = {10};    // ตัวอย่างค่า rows
        // เข้าถึง method initInputScreen โดยใช้ reflection
        Method method = CalculatorUI.class.getDeclaredMethod("initInputScreen", int[].class, int[].class);
        method.setAccessible(true); // ให้สามารถเข้าถึงเมธอด private ได้

        // เรียกใช้ method ด้วยค่า columns และ rows
        method.invoke(calculatorUI, columns, rows);

        // ใช้ reflection เพื่อเข้าถึงตัวแปร inputScreen
        Field field = CalculatorUI.class.getDeclaredField("inputScreen");
        field.setAccessible(true); // ให้สามารถเข้าถึงตัวแปร private ได้

        // ตรวจสอบค่าของ inputScreen ว่าตรงตามที่คาดหวัง
        JTextField inputScreen = (JTextField) field.get(calculatorUI);

        assertEquals("0", inputScreen.getText(), "Input screen initial value should be '0'");
        assertEquals(false, inputScreen.isEditable(), "Input screen should not be editable");
        assertEquals(Color.WHITE, inputScreen.getBackground(), "Input screen background should be white");
        assertEquals(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 33), inputScreen.getFont(), "Font should match expected settings");

        // ตรวจสอบตำแหน่งและขนาด
        assertEquals(10, inputScreen.getX(), "X position should match columns[0]");
        assertEquals(10, inputScreen.getY(), "Y position should match rows[0]");
        assertEquals(350, inputScreen.getWidth(), "Width should be 350");
        assertEquals(70, inputScreen.getHeight(), "Height should be 70");
    }

    @Test
    public void testInitInputScreenWithMargins() throws Exception {
        int[] columns = {20}; // ตัวอย่างค่า columns
        int[] rows = {60};

        // เข้าถึง method initInputScreen โดยใช้ reflection
        Method method = CalculatorUI.class.getDeclaredMethod("initInputScreen", int[].class, int[].class);
        method.setAccessible(true); // ให้สามารถเข้าถึงเมธอด private ได้

        // เรียกใช้ method ด้วยค่า columns และ rows
        method.invoke(calculatorUI, columns, rows);

        // ใช้ reflection เพื่อเข้าถึงตัวแปร inputScreen
        Field field = CalculatorUI.class.getDeclaredField("inputScreen");
        field.setAccessible(true); // ให้สามารถเข้าถึงตัวแปร private ได้

        // ตรวจสอบค่าของ inputScreen ว่าตรงตามที่คาดหวัง
        JTextField inputScreen = (JTextField) field.get(calculatorUI);

        assertEquals("0", inputScreen.getText(), "Input screen initial value should be '0'");
        assertEquals(false, inputScreen.isEditable(), "Input screen should not be editable");
        assertEquals(Color.WHITE, inputScreen.getBackground(), "Input screen background should be white");
        assertEquals(new Font("Comic Sans MS", Font.PLAIN, 33), inputScreen.getFont(), "Font should match expected settings");

        // ตรวจสอบตำแหน่งและขนาด
        assertEquals(20, inputScreen.getX(), "X position should match MARGIN_X");
        assertEquals(60, inputScreen.getY(), "Y position should match MARGIN_Y");
        assertEquals(350, inputScreen.getWidth(), "Width should be 350");
        assertEquals(70, inputScreen.getHeight(), "Height should be 70");
    }

}
