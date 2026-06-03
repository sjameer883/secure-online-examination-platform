# Software Requirements Specification (SRS)

# Online Test Platform (OTP)

Version: 1.0
Prepared By: Shaik Zameer

---

# 1. Introduction

## 1.1 Purpose

The Online Test Platform (OTP) is a web-based application that enables administrators to create and manage examinations while allowing students to take tests online securely. The platform automates exam scheduling, question management, test evaluation, and result generation.

## 1.2 Scope

The system provides:

* User registration and authentication
* Role-based access (Admin, Student)
* Question bank management
* Test creation and scheduling
* Online examination interface
* Automatic evaluation
* Result generation and reporting
* Secure exam environment

## 1.3 Intended Users

* Administrators
* Students
* Educational Institutions
* Training Organizations

---

# 2. Overall Description

## 2.1 Product Perspective

The Online Test Platform is a standalone web application accessible through modern web browsers.

## 2.2 User Roles

### Admin

* Manage users
* Create tests
* Manage questions
* View reports
* Publish results

### Student

* Register/Login
* View available tests
* Take exams
* View results

---

# 3. Functional Requirements

## FR-1 User Authentication

### Description

Users must be able to register and login securely.

### Features

* Registration
* Login
* Logout
* Password Reset

---

## FR-2 User Management

### Admin Features

* Add Student
* Edit Student
* Delete Student
* Activate/Deactivate Accounts

---

## FR-3 Question Bank Management

### Admin Features

* Create Questions
* Update Questions
* Delete Questions
* Categorize Questions by Subject
* Import Questions via Excel/CSV

### Question Types

* Multiple Choice Questions (MCQ)
* True/False
* Fill in the Blanks

---

## FR-4 Test Management

### Admin Features

* Create Test
* Edit Test
* Delete Test
* Set Duration
* Set Passing Marks
* Schedule Test Date & Time

---

## FR-5 Examination Module

### Student Features

* Start Test
* Answer Questions
* Navigate Between Questions
* Submit Test

### System Features

* Auto Save Answers
* Timer Countdown
* Auto Submit on Timeout

---

## FR-6 Evaluation Module

### System Features

* Automatic Scoring
* Calculate Total Marks
* Generate Percentage
* Determine Pass/Fail Status

---

## FR-7 Results Module

### Student Features

* View Results
* Download Score Report

### Admin Features

* View All Results
* Export Results

---

## FR-8 Dashboard

### Admin Dashboard

* Total Students
* Total Tests
* Average Scores
* Recent Activity

### Student Dashboard

* Upcoming Tests
* Completed Tests
* Latest Results

---

# 4. Non-Functional Requirements

## Performance

* Support 100+ concurrent users
* Response time less than 3 seconds

## Security

* Password Encryption
* JWT Authentication
* Role-Based Access Control
* Secure Session Management

## Reliability

* 99% Availability
* Automatic Backup

## Usability

* Responsive Design
* Mobile Friendly Interface

## Scalability

* Support future growth up to 10,000 users

---

# 5. Database Requirements

## Users

* UserID
* Name
* Email
* Password
* Role

## Tests

* TestID
* TestName
* Duration
* TotalMarks
* StartTime
* EndTime

## Questions

* QuestionID
* TestID
* QuestionText
* OptionA
* OptionB
* OptionC
* OptionD
* CorrectAnswer

## Results

* ResultID
* UserID
* TestID
* Score
* Percentage
* Status

---

# 6. Technology Stack

## Frontend

* React.js
* HTML5
* CSS3
* Bootstrap

## Backend

* Spring Boot
* Java 21
* REST APIs

## Database

* MySQL

## Security

* Spring Security
* JWT

## Version Control

* Git
* GitHub

---

# 7. Future Enhancements

* AI-Based Proctoring
* Webcam Monitoring
* Face Recognition
* Certificate Generation
* Email Notifications
* Multi-Language Support

---

# 8. Success Criteria

* Students can complete exams online successfully.
* Admin can manage tests efficiently.
* Results are generated automatically.
* System remains secure and scalable.
