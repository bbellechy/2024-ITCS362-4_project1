

# test-suite1 : ComboBox Theme Selection
## จุดประสงค์ : เพื่อตรวจสอบการเปลี่ยนแปลงของ theme
## Characteristics
## Interface-based
#### a . Identify testable functions
initThemeSelector
#### b. Identify parameters, return types, return values, and exceptional behavior
#### parameters : theme Name
#### return types : -
#### return values : -
####  exceptional behavior : -
#### c . Model the input domain
* Develop characteristics
   * C1 = type of theme
* Partition characteristics

| characteristics     | b1 |       b2 |
|:---------|-----|---------:|
| C1    |  White |     Dark |
* Identify values

| characteristics     | b1 |       b2 |
|:---------|-----|---------:|
| C1    |  White |     Dark |

#### d . Combine partition to define test requirement
* Assumption : choose All Combinations
* Test requirements -- number of test = 2

  White , Dark
#### e . Derive test value
| Test | theme | expected result |
|:----------------|------|----------------:|
| T1 (White)       |  White |           White |
| T1 (Dark)          | Dark |            Dark |
## Functionality-based
#### a . Identify testable functions 
initThemeSelector
#### b. Identify parameters, return types, return values, and exceptional behavior
#### parameters : -
#### return types : -
#### return values : -
####  exceptional behavior : - 
#### c . Model the input domain
* Develop characteristics
   * C1 = มีการเปลี่ยนแปลงสถานะของ theme หรือไม่
* Partition characteristics

| characteristics     |    b1 |       b2 |
  |:---------|------|---------:|
  | C1    |  True |    False |
* Identify values

| characteristics     | b1 |       b2 |
|:---------|-----|---------:|
| C1    |  Dark |    White |

#### d . Combine partition to define test requirement
   * Assumption : choose All Combinations
   * Test requirements -- number of test = 2 

      True , False
#### e . Derive test value
| Test | theme | expected result |
|:----------------|------|----------------:|
| T1 (True)       |  Dark |            Dark |
| T1 (False)          | White |           White |

# test-suite2 : ComboBox Calculator Type Selection
## จุดประสงค์ : เพื่อตรวจสอบการเปลี่ยนแปลงของประเภทเครื่องคิดเลข
## Characteristics
## Interface-based
#### a . Identify testable functions
initCalculatorTypeSelector
#### b. Identify parameters, return types, return values, and exceptional behavior
#### parameters : -
#### return types : -
#### return values : -
####  exceptional behavior : -
#### c . Model the input domain
* Develop characteristics
   * C1 = type of calculator
* Partition characteristics

| characteristics     | b1 |         b2 |
  |:---------|-----|-----------:|
| C1    |  Standard | Scientific |
* Identify values

| characteristics     | b1 |         b2 |
|:---------|-----|-----------:|
| C1    |  Standard | Scientific |

#### d . Combine partition to define test requirement
* Assumption : choose All Combinations
* Test requirements -- number of test = 2

  Standard , Scientific
#### e . Derive test value
| Test |     Type |                            expected result |
|:----------------|---------|-------------------------------------------:|
| T1 (Standard)       | Standard |               ปุ่มในโหมดวิทยาศาสตร์ไม่แสดง |
| T1 (Dark)          |     Scientific |                  แสดงปุ่มในโหมดวิทยาศาสตร์ |
## Functionality-based
#### a . Identify testable functions
initThemeSelector
#### b. Identify parameters, return types, return values, and exceptional behavior
#### parameters : theme Name
#### return types : -
#### return values : -
####  exceptional behavior : -
#### c . Model the input domain
* Develop characteristics
   * C1 = function การใช้งาน
* Partition characteristics

| characteristics     | b1 |         b2 |
  |:---------|-----|-----------:|
| C1    |  Standard | Scientific |
* Identify values

| characteristics     | b1 |         b2 |
|:---------|-----|-----------:|
| C1    |  Standard | Scientific |

#### d . Combine partition to define test requirement
* Assumption : choose All Combinations
* Test requirements -- number of test = 2

  Standard , Scientific
#### e . Derive test value
| Test | state |                      expected result |
|:----------------|------|-------------------------------------:|
| T1 (Standard)       |  Standard |             410 , 600 และไม่แสดงปุ่ม |
| T1 (Scientific)          | Scientific |                490 , 600 และแสดงปุ่ม |

# test-suite3 : InitButtons
## จุดประสงค์ : เพื่อตรวจสอบว่าฟังก์ชันนี้สามารถกำหนดปุ่มขึ้นมาได้จริง
## Characteristics
## Interface-based
#### a . Identify testable functions
initButtons
#### b. Identify parameters, return types, return values, and exceptional behavior
#### parameters : int[] columns , int[] rows
#### return types : -
#### return values : -
####  exceptional behavior : -
#### c . Model the input domain
* Develop characteristics
  * C1 = Length of array columns
  * C2 = Length of array rows
* Partition characteristics

| characteristics |                 b1 | 
  |:----------------|-------------------:|
| C1              | จำนวนปุ่มในแนวตั้ง | 
| C2              |  จำนวนปุ่มในแนวนอน |
* Identify values

| characteristics |            b1 | 
|:----------------|--------------:|
| C1              | {0,1,2,3,4,5} | 
| C2              | {0,1,2,3,4,5} | 

#### d . Combine partition to define test requirement
* Assumption : choose All combination 
* Test requirements -- number of test = 1

  ( C1B1 , C2B1 )
#### e . Derive test value
| Test                | int[] rows |     int[] columns |                          expected result |
|:--------------------|-----------|-----------|-----------------------------------------:|
| T1 ({0,1,2,3,4,5} ) |   {0,1,2,3,4,5} |        {0,1,2,3,4,5}        | ทุกปุ่มไม่เป็นค่า null (ทุกปุ่มถูกสร้าง) |

## Functionality-based
#### a . Identify testable functions
initButtons
#### b. Identify parameters, return types, return values, and exceptional behavior
#### parameters : int[] columns , int[] rows
#### return types : -
#### return values : -
####  exceptional behavior : -
#### c . Model the input domain
* Develop characteristics
  * C1 = Array of columns 
  * C2 = Array of rows
* Partition characteristics

| characteristics |                       b1 | 
  |:----------------|-------------------------:|
| C1              | ตาม Location จริงของปุ่ม | 
| C2              | ตาม Location จริงของปุ่ม | 
* Identify values

| characteristics |                       b1 | 
  |:----------------|-------------------------:|
| C1              | {20, 110, 200, 290, 380} | 
| C2              | {60, 160, 240, 320, 400, 480} | 

#### d . Combine partition to define test requirement
* Assumption : choose All Combinations
* Test requirements -- number of test = 1

  ( C1B1 , C2B1 )
#### e . Derive test value
| Test                | int[] rows |     int[] columns |                                expected result |
|:--------------------|-----------|-----------|-----------------------------------------------:|
| T1 ( C1B1 , C2B1 ) |   {20, 110, 200, 290, 380} |        {60, 160, 240, 320, 400, 480}      | ปุ่มถูกสร้างในตำแหน่งเดียวกับปุ่มที่มีอยู่จริง |

# test-suite4 : Create Button
## จุดประสงค์ : เพื่อตรวจสอบว่าฟังก์ชันนี้สามารถสร้างปุ่มขึ้นมาได้จริง
## Characteristics
## Interface-based
#### a . Identify testable functions
createButton
#### b. Identify parameters, return types, return values, and exceptional behavior
#### parameters : String label, int x, int y
#### return types : JButton
#### return values : ปุ่ม JButton ตาม label
####  exceptional behavior : -
#### c . Model the input domain
* Develop characteristics
  * C1 = string is null
  * C2 = type of int
  * C3 = type of int
* Partition characteristics

| characteristics |                b1 | b2            |           b3 |
  |:----------------|------------------|---------------|-------------:|
| C1              |               yes | No            |              |
| C2              |       จำนวนเต็มลบ | จำนวนเต็มศูนย์ | จำนวนเต็มบวก |
| C3              | จำนวนเต็มลบ | จำนวนเต็มศูนย์ |       จำนวนเต็มบวก       |
* Identify values

| characteristics | b1 | b2 | b3 |
|:----------------|---|---|---:|
| C1              | '' | No |    |
| C2              | -1 | 0 |  1 |
| C3              | -1 | 0 |  1 |

#### d . Combine partition to define test requirement
* Assumption : choose Base choice coverage 
* Test requirements -- number of test = 6

  Base = ( C1B2 , C2B3 , C3B3 )

  ( C1B2 , C2B1 , C3B3 ) ( C1B2 , C2B2 , C3B3 ) ( C1B1 , C2B3 , C3B3 )
  ( C1B2 , C2B3 , C3B1 ) ( C1B2 , C2B3 , C3B3 )
#### e . Derive test value
| Test                      | label |  x |  y |             expected result |
|:--------------------------|------|---|---|----------------------------:|
| T1 ( C1B2 , C2B3 , C3B3 ) |     A |  1 |  1 | มี label นั้น (row column ) |
| T2 ( C1B2 , C2B1 , C3B3 ) |     B | -1 |  2 | มี label นั้น (row column ) |
| T3 ( C1B2 , C2B2 , C3B3 )|     C |  0 |  3 | มี label นั้น (row column ) |
| T4 ( C1B1 , C2B3 , C3B3 ) |    '' |  2 |  4 | มี label นั้น (row column ) |
| T5 ( C1B2 , C2B3 , C3B1 ) |     D |  3 | -1 | มี label นั้น (row column ) |
| T6 ( C1B2 , C2B3 , C3B3 ) |     E |  4 |  0 | มี label นั้น (row column ) |

## Functionality-based
#### a . Identify testable functions
createButton
#### b. Identify parameters, return types, return values, and exceptional behavior
#### parameters : String label, int x, int y
#### return types : JButton
#### return values : ปุ่ม JButton ตาม label
####  exceptional behavior : -
#### c . Model the input domain
* Develop characteristics
  * C1 = Type of button from Calculator
* Partition characteristics

| characteristics     |                       b1 |       b2 |
  |:---------|-------------------------|---------:|
| C1    | Standard |      Scientific    | 

* Identify values

| characteristics | b1               |                  b2 |
  |:----------------|------------------|--------------------:|
| C1              | ('*', 290 , 240) | ('log' , 380 , 320) | 

#### d . Combine partition to define test requirement
* Assumption : choose Base choice coverage
* Test requirements -- number of test = 2

  Base = ( C1B1 )

  ( C1B2) 
#### e . Derive test value
| Test        | label | x   | y   |                expected result |
|:------------|-------|-----|-----|-------------------------------:|
| T1 ( C1B1 ) | '*'   | 290 | 240 |   label * ,column 290, row 240 |
| T2 ( C1B2 ) | 'log' | 380 | 320 | label log ,column 380, row 320 |



# test-suite7 : Scientific Functions

**จุดประสงค์ของ Test Suite**:  
ทดสอบการทำงานของฟังก์ชันทางวิทยาศาสตร์ ได้แก่ square root (รากที่สอง), power (ยกกำลัง), และ logarithm (ลอการิทึม) เพื่อให้แน่ใจว่าฟังก์ชันทำงานได้ถูกต้องตามคาดสำหรับ input ที่แตกต่างกัน รวมถึงกรณีที่เป็นไปได้ของการป้อนข้อมูลที่ไม่เหมาะสม (NaN หรือ Infinity)

---
# **Interface-based Testing**

### **1. Identify Testable Functions:**
- btnRoot , btnPower , btnLog

---

### **2. Identify Parameters:**
- **Parameters:** `inputScreen`
- **Return Type:** `string`
- **Return Value:** `ตัวเลขหลังจากทำ operation`

---

### **3. Model the Input Domain:**

- **c1:** InputScreen is double
- **c2:** operation

### **3.1 Partition Characterization (Interface-based Testing)**

| **Characteristic** | **b1**     | **b2**         | **b3**|
|--------------------|------------|----------------|------------|
| c1| false | true |
| c3   | Root       | Power           |Log|

---

### **3.2 Identify Test Values (Interface-based Testing)**

| **Characteristic** | **b1** | **b2** |  **b3**|
|--------------------|--------|--------|------------|
| c1                 | 1      | 0.5    |
| c2                 | "√"    | "pow"  |   "ln" |    

---

### **4. Combine Values**
Assumption : Each Choice Coverage

No. of tests = 2

(c1b1,c2b1) , (c1b2,c2b2) , (c1b1,c2b3)

---

### **5. Derive Expected Values (Interface-based Testing)**

| **Test** | **Double** | **Char** | **Expected result**|
|----------|------------|------------|:-------------------|
| T1  (c1b1,c2b1)    | 1          | "√"          |         1           |
| T2   (c1b2,c2b2)      | 0.5 ,  0.5 | "pow"          |      0.7071067811865476           |
| T3    (c1b1,c2b3)    | 1          | "ln"        |        0            |
---


# **Functionality-based Testing**

### **1. Identify Testable Functions:**
-btnRoot , btnPower , btnLog

### **2. Identify Parameters:**
- **Parameters:**  `inputScreen`
- **Return Type:** `string`
- **Return Value:** `ตัวเลขหลังจากทำ operation`

---

### **3. Model the Input Domain:**
**c1:** classification by operation

---

### **3.1 Develop Partition Characterization**

| **Characteristic** | **b1**     | **b2**         | **b3**|
|--------------------|------------|----------------|------------|
| c1                 | Root       | Power           |Log|

---

### **3.2 Identify Test Values**

| **Characteristic** | **b1** | **b2** | **b3** |
|--------------------|--------|--------|--------|
| **c1**             | √2     | 2^0    | ln10   |

---

### **4. Combine Values**
Assumption : Each Choice Coverage

จำนวนการทดสอบทั้งหมด = 3

c1b1 , c1b2 , c1b3


---

### **5. Derive Expected Values**

| **Test**     | **Double** | **Char** | **Expected result** |
|--------------|------------|------------|:--------------------|
| T1  (c1b1)   | 2          | "√"          | 1.4142135623730951  |
| T2   (c1b2)  | 2 ,  0     | "pow"          | 1                   |
| T3    (c1b3) | 10         | "ln"        | 2.302585092994046                    |
---



### **Test Suite 8: initInputScreen**

### **จุดประสงค์ของ Test Suite:**
ชุดทดสอบนี้มีจุดประสงค์เพื่อทดสอบการเริ่มทำงานของ Inputscreen

---

### **1. Identify Testable Functions:**
- initInputScreen

---

### **2. Identify Parameters:**
- **Parameters:** int[] columns, int[] rows
- **Return Type:**
  - `void` (ไม่มีค่าที่คืน)
- **Return Value:**
  - ไม่มี 

---

### **3. Model the Input Domain**
* Develop characteristics
  * C1 = Length of array columns is 1
  * C2 = Length of array rows is 1
* Partition characteristics
*
| characteristics | b1         |   b2 |
  |:----------------|------------|-----:| 
| C1              | false      | true |
| C2              | false |   true   |
* Identify values

| characteristics | b1        |   b2 |
  |:----------------|-----------|-----:| 
| C1              | {1,2,3,4} | {10} |
| C2              | {1,2,3,4} | {10} |
---



### **4. Combine Values (การผสมค่าทดสอบ)**
Assumption : Each Choice Coverage

No of tests = 2

(c1b1,c2b1) , (c1b2,c2b2)


---

### **5. Derive Expected Values (Interface-based Testing)**

| Test                | int[] rows |     int[] columns |                                                                                                                          expected result |
|:--------------------|-----------|-----------|-----------------------------------------------------------------------------------------------------------------------------------------:|
| T1 (c1b1,c2b1)|   {1,2,3,4} |        {1,2,3,4}       |   inputScreen = 0 , ไม่สามารถแก้ไขได้ , พื้นหลังเป็นสีขาว , front Comic Sans MS <br/>มีตำแหน่ง x = 1, y = 1 และขนาด Width 350 ,Height 70 |
| T1 (c1b2,c2b2) |   {10} |        {10}      | inputScreen = 0 , ไม่สามารถแก้ไขได้ , พื้นหลังเป็นสีขาว , front Comic Sans MS <br/>มีตำแหน่ง x = 10, y = 10 และขนาด Width 350 ,Height 70 |
---




# Functionality-based Testing

### **1. Identify Testable Functions:**
- initInputScreen

---

### **2. Identify Parameters:**
- **Parameters:** int[] columns, int[] rows
- **Return Type:**
  - `void` (ไม่มีค่าที่คืน)
- **Return Value:**
  - ไม่มี

---

### 3. Model the Input Domain
* Develop characteristics
  * C1 = Index column
  * C2 = Index row
* Partition characteristics

| characteristics |                                  b1 | 
  |:----------------|------------------------------------:|
| C1              | Index ตำแหน่งที่ 0 ของ array colums | 
| C2              |   Index ตำแหน่งที่ 0 ของ array rows | 
* Identify values

| characteristics     |                       b1 | 
  |:---------|-------------------------:|
| C1    | {20} | 
| C1    | {60} | 

---


### 4. Combine Values

Assumption : Each Choice Coverage

No. of tests = 2

(c1b1,c2b1)

---

### 5. Derive Expected Values (Functionality-based Testing)


| Test                | int[] rows |     int[] columns |                                                                                                                          expected result |
|:--------------------|----------|-----------|-----------------------------------------------------------------------------------------------------------------------------------------:|
| T1 ( C1B1 , C2B1 ) |   {20} |        {60}      | inputScreen = 0 , ไม่สามารถแก้ไขได้ , พื้นหลังเป็นสีขาว , front Comic Sans MS <br/>มีตำแหน่ง x = 20, y = 60 และขนาด Width 350 ,Height 70 |















































































































































