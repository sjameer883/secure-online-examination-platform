# Software Requirements Specification (SRS)

# Online Test & Recruitment Platform (OTRP)

Version: 2.0
Prepared By: Shaik Zameer

---

# 1. Introduction

## 1.1 Purpose

The Online Test & Recruitment Platform (OTRP) is a secure web-based system that enables educational institutions, training organizations, and companies to conduct assessments, coding tests, communication evaluations, aptitude tests, and online interviews. The platform streamlines the complete recruitment and assessment lifecycle from candidate registration to final selection.

---

## 1.2 Scope

The platform provides:

* User Registration and Authentication
* Role-Based Access Control
* Assessment Management
* Question Bank Management
* Coding Assessment Environment
* Technical Skill Evaluation
* Communication Skill Evaluation
* Aptitude & Logical Reasoning Tests
* Automated Evaluation & Scoring
* Interview Scheduling
* Secure Online Interview Environment
* Candidate Analytics & Reporting
* Recruitment Workflow Management

---

## 1.3 Intended Users

### Educational Institutions

* Schools
* Colleges
* Universities
* Online Learning Platforms

### Hiring Industries & Companies

* IT Companies
* Product-Based Companies
* Startups
* Consulting Firms
* BPO/KPO Organizations
* Corporate Training Departments
* Recruitment Agencies

### Training Organizations

* Technical Training Institutes
* Certification Providers
* Skill Development Centers

### Government Organizations

* Recruitment Boards
* Public Sector Enterprises

---

# 2. Overall Description

## 2.1 Product Perspective

The platform is a cloud-based web application accessible through desktop and mobile browsers. It supports online assessments, coding challenges, and interview management.

---

## 2.2 User Roles

### Super Admin

* Manage Organizations
* Manage System Configuration
* Monitor Platform Usage
* Manage Subscription Plans
* View Global Analytics

### Recruiter/Admin

* Create Assessments
* Manage Candidates
* Schedule Interviews
* View Reports
* Publish Results

### Interviewer

* Conduct Interviews
* Evaluate Candidates
* Submit Feedback
* Access Assigned Assessments

### Candidate

* Register/Login
* Take Assessments
* Attend Interviews
* View Results
* Track Application Status

---

# 3. Functional Requirements

## FR-1 User Authentication & Authorization

### Features

* User Registration
* Secure Login
* Logout
* Password Reset
* Email Verification
* Multi-Factor Authentication (Optional)
* JWT-Based Authentication
* Role-Based Access Control

---

## FR-2 Organization Management

### Features

* Organization Registration
* Organization Profile Management
* Recruiter Management
* Department Management
* Subscription Management

---

## FR-3 Candidate Management

### Features

* Candidate Registration
* Profile Creation
* Resume Upload
* Skills Management
* Experience Management
* Application Tracking

---

## FR-4 Question Bank Management

### Features

* Create Questions
* Edit Questions
* Delete Questions
* Import Questions
* Export Questions
* Categorize Questions
* Difficulty Levels

### Question Types

#### Technical Questions

* MCQ
* Coding Challenges
* SQL Queries
* Debugging Problems
* System Design Questions

#### Aptitude Questions

* Quantitative Aptitude
* Logical Reasoning
* Analytical Reasoning

#### Communication Questions

* English Grammar
* Reading Comprehension
* Verbal Ability
* Writing Skills

#### Domain-Specific Questions

* Java
* Spring Boot
* Python
* JavaScript
* React
* SQL
* DevOps
* Cloud Computing
* Cybersecurity
* AI/ML

---

## FR-5 Assessment Management

### Features

* Create Assessment
* Schedule Assessment
* Configure Duration
* Configure Passing Score
* Randomize Questions
* Assign Candidates
* Enable Proctoring Rules
* Publish Assessment

### Assessment Types

* Technical Assessment
* Coding Assessment
* Aptitude Test
* Communication Assessment
* Domain Skill Assessment
* Hybrid Assessment

---

## FR-6 Coding Test Environment

### Features

* Browser-Based Code Editor
* Syntax Highlighting
* Auto Save
* Code Compilation
* Code Execution
* Hidden Test Cases
* Custom Test Cases
* Runtime Validation
* Memory Usage Validation
* Submission Tracking

### Supported Languages

* Java
* Python
* JavaScript
* C
* C++
* SQL

---

## FR-7 Online Examination Module

### Features

* Start Test
* Save Answers
* Review Answers
* Submit Test
* Timer Countdown
* Auto Submission
* Question Navigation
* Progress Tracking

---

## FR-8 Evaluation Engine

### Features

* Automatic MCQ Evaluation
* Coding Evaluation
* Score Calculation
* Percentage Calculation
* Ranking Generation
* Pass/Fail Determination

---

## FR-9 Interview Scheduling Module

### Features

* Schedule Interview
* Assign Interviewer
* Calendar Integration
* Email Notifications
* SMS Notifications
* Reschedule Interview
* Cancel Interview

---

## FR-10 Secure Interview Environment

### Features

* Video Interview Room
* Live Coding Environment
* Whiteboard Collaboration
* Screen Sharing
* Candidate Verification
* Interview Recording
* Chat Support
* Feedback Submission

---

## FR-11 Proctoring & Security Module

### Features

* Browser Tab Monitoring
* Full-Screen Enforcement
* Webcam Monitoring
* Face Verification
* Multiple Login Detection
* Activity Tracking
* Session Recording
* Suspicious Activity Alerts

---

## FR-12 Results & Analytics

### Candidate Features

* View Results
* Download Reports
* View Performance Insights

### Recruiter Features

* Candidate Ranking
* Assessment Analytics
* Hiring Reports
* Interview Feedback Reports

---

## FR-13 Recruitment Workflow Management

### Recruitment Flow

1. Candidate Registration
2. Resume Submission
3. Assessment Assignment
4. Online Test Completion
5. Automated Evaluation
6. Candidate Shortlisting
7. Interview Scheduling
8. Technical Interview
9. HR Interview
10. Final Evaluation
11. Offer Release
12. Candidate Onboarding

---

## FR-14 Notification Module

### Features

* Email Notifications
* SMS Notifications
* Interview Reminders
* Assessment Reminders
* Result Notifications
* Recruitment Status Updates

---

# 4. Non-Functional Requirements

## Performance

* Support 1,000+ Concurrent Users
* Response Time < 3 Seconds
* Assessment Auto Save < 1 Second

## Security

* JWT Authentication
* Password Encryption
* HTTPS Communication
* Role-Based Access Control
* Secure Coding Sandbox
* Data Encryption

## Reliability

* 99.9% Availability
* Automatic Backup
* Disaster Recovery Support

## Scalability

* Multi-Tenant Architecture
* Horizontal Scaling Support
* Cloud Deployment Ready

## Usability

* Responsive UI
* Mobile-Friendly Design
* Accessibility Compliance

---

# 5. Database Requirements

## Users

* UserID
* Name
* Email
* Password
* Role
* Status

## Organizations

* OrganizationID
* OrganizationName
* SubscriptionType

## Candidates

* CandidateID
* UserID
* ResumeURL
* Experience
* Skills

## Assessments

* AssessmentID
* AssessmentName
* Duration
* PassingScore

## Questions

* QuestionID
* AssessmentID
* QuestionType
* DifficultyLevel

## CodingSubmissions

* SubmissionID
* CandidateID
* SourceCode
* Language
* ExecutionResult

## Interviews

* InterviewID
* CandidateID
* InterviewerID
* ScheduleTime
* Status

## Results

* ResultID
* CandidateID
* AssessmentID
* Score
* Percentage
* Rank
* Status

---

# 6. Technology Stack

## Frontend

* React.js
* TypeScript
* HTML5
* CSS3
* Bootstrap / Material UI

## Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA

## Database

* PostgreSQL

## Authentication

* JWT
* OAuth 2.0

## Cloud & DevOps

* Docker
* Kubernetes
* AWS / Azure

## Version Control

* Git
* GitHub

---

# 7. Future Enhancements

* AI-Based Candidate Evaluation
* AI Interview Assistant
* Voice Analysis
* Emotion Detection
* Resume Screening using AI
* Certificate Generation
* Multi-Language Support
* Mobile Application
* Integration with Job Portals
* ATS (Applicant Tracking System) Integration

---

# 8. Success Criteria

* Organizations can conduct secure assessments.
* Candidates can complete tests without interruptions.
* Recruiters can evaluate candidates efficiently.
* Interviews can be conducted securely online.
* Results are generated accurately and automatically.
* Recruitment time is significantly reduced.
* Platform supports large-scale hiring processes securely and reliably. can i add this as 2.0 version
