/* Copyright (C) 2024 Rittichon Phonrat, Jirachaya Rachpolsaen - All Rights Reserved * You may use, distribute and modify this code under the terms of the MIT license. */


package com.houarizegai.calculator;

import com.houarizegai.calculator.ui.CalculatorUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTestsuite1_4 {

    private CalculatorUI calculatorUI;


    //CreateButton
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 70;

    @BeforeEach
    void setUp() {
        calculatorUI = new CalculatorUI();

    }
    private int getPrivateWindowWidth() throws NoSuchFieldException, IllegalAccessException {
        Field widthField = CalculatorUI.class.getDeclaredField("WINDOW_WIDTH");
        widthField.setAccessible(true);
        return (int) widthField.get(null); // null เพราะเป็น static field
    }

    private int getPrivateWindowHeight() throws NoSuchFieldException, IllegalAccessException {
        Field heightField = CalculatorUI.class.getDeclaredField("WINDOW_HEIGHT");
        heightField.setAccessible(true);
        return (int) heightField.get(null); // null เพราะเป็น static field
    }
    private boolean isButtonVisible(String buttonName) throws NoSuchFieldException, IllegalAccessException {
        Field buttonField = CalculatorUI.class.getDeclaredField(buttonName);
        buttonField.setAccessible(true);
        JButton button = (JButton) buttonField.get(calculatorUI);
        return button.isVisible();
    }
    // ฟังก์ชันสำหรับเข้าถึง private field ของ window
    private Object getPrivateWindow() throws NoSuchFieldException, IllegalAccessException {
        Field windowField = CalculatorUI.class.getDeclaredField("window");
        windowField.setAccessible(true); // ให้เข้าถึงฟิลด์ private
        return windowField.get(calculatorUI);
    }

    // Helper methods to access private fields using reflection
    private JComboBox<String> getPrivateComboBox(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = CalculatorUI.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (JComboBox<String>) field.get(calculatorUI);
    }

    private JButton getPrivateButton(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = CalculatorUI.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (JButton) field.get(calculatorUI);
    }


    /* 1. Test Suite: ComboBox Theme Selection */
    // Interface-base
    @Test
    void testDefaultThemeIsWhite() throws NoSuchFieldException, IllegalAccessException {
        // Access private field comboTheme using reflection
        Field comboThemeField = CalculatorUI.class.getDeclaredField("comboTheme");
        comboThemeField.setAccessible(true); // Allow access to the private field

        // Get the value of the comboTheme field
        JComboBox<String> comboTheme = (JComboBox<String>) comboThemeField.get(calculatorUI);

        // Assume that the default theme is white if no selection is made
        String defaultTheme = "Light"; // or whatever the default theme's name is

        // Test to ensure the default theme is applied
        assertEquals(defaultTheme, comboTheme.getSelectedItem());
    }
    //Functional-Base
    @Test
    void testComboBoxTheme() throws NoSuchFieldException, IllegalAccessException {
        // Access private field comboTheme using reflection
        Field comboThemeField = CalculatorUI.class.getDeclaredField("comboTheme");
        comboThemeField.setAccessible(true); // Allow access to the private field

        // Get the value of the comboTheme field
        JComboBox<String> comboTheme = (JComboBox<String>) comboThemeField.get(calculatorUI);

        // Set and test the theme selection
        comboTheme.setSelectedItem("Dark");
        assertEquals("Dark", comboTheme.getSelectedItem());

    }
    @Test
    void testComboBoxThemeEmpty() throws NoSuchFieldException, IllegalAccessException {
        // Access private field comboTheme using reflection
        Field comboThemeField = CalculatorUI.class.getDeclaredField("comboTheme");
        comboThemeField.setAccessible(true); // Allow access to the private field
        // Get the value of the comboTheme field
        JComboBox<String> comboTheme = (JComboBox<String>) comboThemeField.get(calculatorUI);
        // Set and test the theme selection
        comboTheme.setSelectedItem(" ");
        assertEquals("Light", comboTheme.getSelectedItem());

    }

    /* 2. Test Suite: ComboBox Calculator Type Selection */
    @Test
    void testStandardMode() throws NoSuchFieldException, IllegalAccessException {
        JComboBox<String> comboCalculatorType = getPrivateComboBox("comboCalculatorType");
        comboCalculatorType.setSelectedItem("Standard");

        // ตรวจสอบว่าปุ่มวิทยาศาสตร์ถูกซ่อน
        JButton scientificButton = getPrivateButton("btnRoot"); // ตัวอย่างการเข้าถึงปุ่ม
        assertFalse(scientificButton.isVisible(), "Root button should be hidden in Standard mode.");
        assertFalse(getPrivateButton("btnPower").isVisible(), "Power button should be hidden in Standard mode.");
        assertFalse(getPrivateButton("btnLog").isVisible(), "Log button should be hidden in Standard mode.");
    }

    @Test
    void testScientificMode() throws NoSuchFieldException, IllegalAccessException {
        JComboBox<String> comboCalculatorType = getPrivateComboBox("comboCalculatorType");
        comboCalculatorType.setSelectedItem("Scientific");

        // ตรวจสอบว่าปุ่มวิทยาศาสตร์แสดง
        assertTrue(getPrivateButton("btnRoot").isVisible(), "Root button should be visible in Scientific mode.");
        assertTrue(getPrivateButton("btnPower").isVisible(), "Power button should be visible in Scientific mode.");
        assertTrue(getPrivateButton("btnLog").isVisible(), "Log button should be visible in Scientific mode.");
    }
    // Functional-Base
    @Test
    void testStandardModes() throws NoSuchFieldException, IllegalAccessException {
        JComboBox<String> comboCalculatorType = getPrivateComboBox("comboCalculatorType");
        comboCalculatorType.setSelectedItem("Standard");

        // เข้าถึง window ผ่าน Reflection
        Object window = getPrivateWindow();
        Dimension size = ((JFrame) window).getSize(); // สมมุติว่า window เป็น JFrame

        // ใช้ฟังก์ชันที่สร้างขึ้นเพื่อเข้าถึงค่าคงที่
        int expectedWidth = getPrivateWindowWidth();
        int expectedHeight = getPrivateWindowHeight();

        // ตรวจสอบขนาดของหน้าต่าง
        assertEquals(410, size.width, "Window width should be " + expectedWidth + " in Standard mode.");
        assertEquals(600, size.height, "Window height should be " + expectedHeight + " in Standard mode.");

        // ตรวจสอบว่าปุ่ม Scientific ถูกซ่อนไว้
        assertFalse(isButtonVisible("btnRoot"), "Root button should be hidden in Standard mode.");
        assertFalse(isButtonVisible("btnPower"), "Power button should be hidden in Standard mode.");
        assertFalse(isButtonVisible("btnLog"), "Log button should be hidden in Standard mode.");
    }
    @Test
    void testScientificModes() throws NoSuchFieldException, IllegalAccessException {
        JComboBox<String> comboCalculatorType = getPrivateComboBox("comboCalculatorType");
        comboCalculatorType.setSelectedItem("Scientific");

        // เข้าถึง window ผ่าน Reflection
        Object window = getPrivateWindow();
        Dimension size = ((JFrame) window).getSize(); // สมมุติว่า window เป็น JFrame

        // ใช้ฟังก์ชันที่สร้างขึ้นเพื่อเข้าถึงค่าคงที่
        int expectedWidth = getPrivateWindowWidth();
        int expectedHeight = getPrivateWindowHeight();

        // ตรวจสอบขนาดของหน้าต่าง
        assertEquals(490, size.width, "Window width should be " + expectedWidth + " in Standard mode.");
        assertEquals(600, size.height, "Window height should be " + expectedHeight + " in Standard mode.");

        // ตรวจสอบว่าปุ่ม Scientific ถูกซ่อนไว้
        assertTrue(isButtonVisible("btnRoot"), "Root button should be hidden in Standard mode.");
        assertTrue(isButtonVisible("btnPower"), "Power button should be hidden in Standard mode.");
        assertTrue(isButtonVisible("btnLog"), "Log button should be hidden in Standard mode.");
    }

    /* 3. Test Suite: InitButtons */
    //  การทดสอบการสร้างปุ่ม  InterfaceBase
    @Test
    public void testInitButtons() throws Exception {
        int[] columns = {0, 1, 2, 3, 4, 5};
        int[] rows = {0, 1, 2, 3, 4, 5};

        // ใช้ Reflection เพื่อเข้าถึงเมธอด initButtons
        Method method = CalculatorUI.class.getDeclaredMethod("initButtons", int[].class, int[].class);
        method.setAccessible(true); // ทำให้ฟังก์ชัน private สามารถเข้าถึงได้

        // เรียกใช้ฟังก์ชัน initButtons โดยใช้ Reflection
        method.invoke(calculatorUI, columns, rows);
        // เช็คว่าปุ่มถูกสร้างขึ้นในคอลเลกชัน
        String[] buttonLabels = {"C", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Add", "Sub", "Mul", "Div",
                "Point", "Equal", "Power", "Log", "Root", "Mod", "Back"};

        for (String label : buttonLabels) {
            // ใช้ Reflection เพื่อเข้าถึงฟิลด์ปุ่มตามชื่อ
            Field btnField = CalculatorUI.class.getDeclaredField("btn" + label);
            btnField.setAccessible(true);
            Object btn = btnField.get(calculatorUI);

            // ตรวจสอบว่าปุ่มไม่เป็น null
            assertNotNull(btn);
        }
    }

    //    FunctionalBase
    @Test
    public void testInitButtonsFunctional() throws Exception {
        int[] columns = {20, 110, 200, 290, 380}; // ตำแหน่ง X ของคอลัมน์
        int[] rows = {60, 160, 240, 320, 400, 480}; // ตำแหน่ง Y ของแถว

        // ใช้ Reflection เพื่อเข้าถึงเมธอด initButtons
        Method method = CalculatorUI.class.getDeclaredMethod("initButtons", int[].class, int[].class);
        method.setAccessible(true); // ทำให้ฟังก์ชัน private สามารถเข้าถึงได้

        // เรียกใช้ฟังก์ชัน initButtons โดยใช้ Reflection
        method.invoke(calculatorUI, columns, rows);

        // เช็คว่าปุ่มถูกสร้างขึ้นในคอลเลกชัน
        String[] buttonLabels = {"C", "Back", "Mod", "Div",
                "7", "8", "9", "Mul",
                "4", "5", "6", "Sub",
                "1", "2", "3", "Add",
                "Point", "0", "Equal",
                "Root", "Power", "Log"};

        // จำนวนปุ่มทั้งหมด
        int totalColumns = 4; // ปุ่มถูกจัดเป็น 4 คอลัมน์

        for (int i = 0; i < buttonLabels.length; i++) {
            String label = buttonLabels[i];

            // ใช้ Reflection เพื่อเข้าถึงฟิลด์ปุ่มตามชื่อ
            Field btnField = CalculatorUI.class.getDeclaredField("btn" + label);
            btnField.setAccessible(true);
            Object btn = btnField.get(calculatorUI);

            // ตรวจสอบว่าปุ่มไม่เป็น null
            assertNotNull(btn, "Button " + label + " should not be null.");

            // ตรวจสอบว่าปุ่มพิเศษที่วางในคอลัมน์พิเศษหรือไม่
            if (label.equals("Root")) {
                // ปรับตำแหน่งสำหรับปุ่ม Root
                int expectedX = columns[4]; // ตำแหน่ง X ของ Root
                int expectedY = rows[1]; // แถวสุดท้ายสำหรับปุ่ม Root
                Method getXMethod = btn.getClass().getMethod("getX");
                Method getYMethod = btn.getClass().getMethod("getY");
                int actualX = (int) getXMethod.invoke(btn);
                int actualY = (int) getYMethod.invoke(btn);

                // ตรวจสอบตำแหน่งปุ่ม Root
                assertEquals(expectedX, actualX, "Button " + label + " should be at the correct X position.");
                assertEquals(expectedY, actualY, "Button " + label + " should be at the correct Y position.");
            } else if (label.equals("Power")) {
                // ปรับตำแหน่งสำหรับปุ่ม Power
                int expectedX = columns[4]; // ตำแหน่ง X ของ Power
                int expectedY = rows[2]; // แถวสุดท้ายสำหรับปุ่ม Power
                Method getXMethod = btn.getClass().getMethod("getX");
                Method getYMethod = btn.getClass().getMethod("getY");
                int actualX = (int) getXMethod.invoke(btn);
                int actualY = (int) getYMethod.invoke(btn);

                // ตรวจสอบตำแหน่งปุ่ม Power
                assertEquals(expectedX, actualX, "Button " + label + " should be at the correct X position.");
                assertEquals(expectedY, actualY, "Button " + label + " should be at the correct Y position.");
            } else if (label.equals("Log")) {
                // ปรับตำแหน่งสำหรับปุ่ม Log
                int expectedX = columns[4]; // ตำแหน่ง X ของ Log
                int expectedY = rows[3]; // แถวถัดไปสำหรับปุ่ม Log
                Method getXMethod = btn.getClass().getMethod("getX");
                Method getYMethod = btn.getClass().getMethod("getY");
                int actualX = (int) getXMethod.invoke(btn);
                int actualY = (int) getYMethod.invoke(btn);

                // ตรวจสอบตำแหน่งปุ่ม Log
                assertEquals(expectedX, actualX, "Button " + label + " should be at the correct X position.");
                assertEquals(expectedY, actualY, "Button " + label + " should be at the correct Y position.");
            } else {
                // คำนวณตำแหน่งที่คาดหวังของปุ่มอื่นๆ
                int expectedColumnIndex = i % totalColumns; // คำนวณตำแหน่งคอลัมน์
                int expectedRowIndex = i / totalColumns; // คำนวณตำแหน่งแถว (เริ่มจากแถวที่ 0)
                int expectedX = columns[expectedColumnIndex]; // ค่า X คอลัมน์
                int expectedY = rows[expectedRowIndex + 1]; // ค่า Y แถว (เพิ่ม 1 ให้เริ่มจากแถวที่ 1)
                Method getXMethod = btn.getClass().getMethod("getX");
                Method getYMethod = btn.getClass().getMethod("getY");
                int actualX = (int) getXMethod.invoke(btn);
                int actualY = (int) getYMethod.invoke(btn);

                // ตรวจสอบตำแหน่งที่คาดหวัง
                assertEquals(expectedX, actualX, "Button " + label + " should be at the correct X position.");
                assertEquals(expectedY, actualY, "Button " + label + " should be at the correct Y position.");
            }
        }
    }

    /* 4. Function Create Button */
    @Test
    public void testCreateButton() throws Exception {
        // ใช้ Reflection เพื่อเข้าถึงเมธอด createButton ที่เป็น private
        Method createButtonMethod = CalculatorUI.class.getDeclaredMethod(
                "createButton", String.class, int.class, int.class);
        createButtonMethod.setAccessible(true);  // ทำให้เข้าถึงได้แม้เป็น private

        // เรียกใช้เมธอด createButton เพื่อสร้างปุ่ม Tase case1
        JButton btnT1 = (JButton) createButtonMethod.invoke(calculatorUI, "A", 1, 1);

        // ตรวจสอบว่าปุ่มถูกสร้าง (ไม่เป็น null)
        assertNotNull(btnT1, "ปุ่มควรจะถูกสร้างและต้องไม่เป็น null");
        // ตรวจสอบว่า label ถูกต้อง
        assertEquals("A", btnT1.getText(), "Label ของปุ่มควรเป็น 'Test'");

        //Tase case2
        JButton btnT2 = (JButton) createButtonMethod.invoke(calculatorUI, "B", -1, 2);
        assertNotNull(btnT2, "ปุ่มควรจะถูกสร้างและต้องไม่เป็น null");
        assertEquals("B", btnT2.getText(), "Label ของปุ่มควรเป็น 'Test'");

        //Tase case3
        JButton btnT3 = (JButton) createButtonMethod.invoke(calculatorUI, "C", 0, 3);
        assertNotNull(btnT3, "ปุ่มควรจะถูกสร้างและต้องไม่เป็น null");
        assertEquals("C", btnT3.getText(), "Label ของปุ่มควรเป็น 'Test'");

        //Tase case4
        JButton btnT4 = (JButton) createButtonMethod.invoke(calculatorUI, "", 2, 4);
        assertNotNull(btnT4, "ปุ่มควรจะถูกสร้างและต้องไม่เป็น null");
        assertEquals("", btnT4.getText(), "Label ของปุ่มควรเป็น 'Test'");

        //Tase case5
        JButton btnT5 = (JButton) createButtonMethod.invoke(calculatorUI, "D", 3, -1);
        assertNotNull(btnT5, "ปุ่มควรจะถูกสร้างและต้องไม่เป็น null");
        assertEquals("D", btnT5.getText(), "Label ของปุ่มควรเป็น 'Test'");

        //Tase case6
        JButton btnT6 = (JButton) createButtonMethod.invoke(calculatorUI, "E", 4, 0);
        assertNotNull(btnT6, "ปุ่มควรจะถูกสร้างและต้องไม่เป็น null");
        assertEquals("E", btnT6.getText(), "Label ของปุ่มควรเป็น 'Test'");

        //Tase Functional Standard
        JButton btnMul = (JButton) createButtonMethod.invoke(calculatorUI, "*", 290, 240);
        assertNotNull(btnMul, "ปุ่มควรจะถูกสร้างและต้องไม่เป็น null");
        assertEquals("*", btnMul.getText());

        assertEquals(290, btnMul.getX());
        assertEquals(240, btnMul.getY());

        //Tase Functional Scientific
        JButton btnLog = (JButton) createButtonMethod.invoke(calculatorUI, "log", 380, 320);
        assertNotNull(btnLog, "ปุ่มควรจะถูกสร้างและต้องไม่เป็น null");
        assertEquals("log", btnLog.getText());

        assertEquals(380, btnLog.getX());
        assertEquals(320, btnLog.getY());
    }











}
