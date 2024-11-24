"# Test" 
# System Testing (Integration Test) 
# Test 1: ทดสอบการ Log in ของผู้ใช้

## วัตถุประสงค์:
การทดสอบฟังก์ชัน Log In ของผู้ใช้มีเป้าหมายเพื่อยืนยันว่าระบบสามารถทำงานได้อย่างถูกต้องในการจัดการบัญชีผู้ใช้ในการเข้าสู่ระบบ โดยผู้ใช้สามารถเข้าสู่ระบบได้ด้วยข้อมูลที่ลงทะเบียนไว้แล้ว
## Test Case Details

| **Test Scenario ID** | ITDS-SC1 |
|----------------------|----------|
| **Test Case ID**      | ITDS-TC1A |
| **Test Case Description** | ทดสอบการ Log in ของผู้ใช้ |
| **Test Priority**     | สูง     |
| **Pre-Requisite**     | NA      |
| **Post-Requisite**    | ผู้ใช้เข้าสู่ระบบสำเร็จ |
## Test Execution Steps

| S.No | Action | Inputs | Expected Output | Actual Output | Test Browser | Test Result | Test Comments |
|------|--------|--------|-----------------|---------------|--------------|-------------|---------------|
| 1    | เปิดเว็บไซต์ | URL: http://45.136.236.146:8081/ | เว็บไซต์โหลดได้สำเร็จ | เว็บไซต์โหลดสำเร็จ | Chrome | Pass | เว็บไซต์โหลดสำเร็จ |
| 2    | ค้นหาปุ่ม "Log In" และคลิก | - | ป็อปอัพสำหรับเข้าสู่ระบบปรากฏ | ป็อปอัพเข้าสู่ระบบปรากฏ | Chrome | Pass | ป็อปอัพทำงานได้อย่างถูกต้อง |
| 3    | ค้นหาช่องกรอก Username และ Password | - | ช่องสำหรับกรอก Username และ Password ปรากฏ | ช่องกรอก Username และ Password ปรากฏ | Chrome | Pass | ช่องกรอกแสดงผลถูกต้อง |
| 4    | กรอกรายละเอียดการ Login | Username: u6587042<br>Password: Wat094926 | ผู้ใช้กรอก Username และ Password ถูกต้อง | ผู้ใช้สามารถกรอก Username และ Password ได้ | Chrome | Pass | ข้อมูลที่กรอกถูกต้อง |
| 5    | คลิกปุ่ม "Log In" ในป็อปอัพ | - | ระบบตรวจสอบ Username และ Password | ระบบตรวจสอบข้อมูลสำเร็จ | Chrome | Pass | ระบบตรวจสอบข้อมูลได้ถูกต้อง |
| 6    | ตรวจสอบชื่อผู้ใช้ที่ปรากฏบนหน้าเว็บ | - | ชื่อผู้ใช้ที่แสดงผลตรงกับ Username ที่กรอก | ชื่อผู้ใช้ที่แสดงผล: u6587042 | Chrome | Pass | Login Test Passed! Username is correct: u6587042 |
