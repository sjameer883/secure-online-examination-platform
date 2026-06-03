# Database Design

## 1. Database Overview

The Secure Online Examination Platform (SOEP) uses PostgreSQL as the primary relational database.

PostgreSQL was selected because of:

* ACID Compliance
* Strong Data Integrity
* Advanced Indexing Support
* High Reliability
* Excellent Performance
* Seamless Spring Boot Integration

The database stores all application data including users, roles, examinations, questions, candidate responses, results, and audit logs.

---

# 2. Database Tables

## roles

Stores system roles.

| Column Name | Data Type   | Constraints      | Description            |
| ----------- | ----------- | ---------------- | ---------------------- |
| role_id     | BIGSERIAL   | PK               | Unique role identifier |
| role_name   | VARCHAR(50) | UNIQUE, NOT NULL | Role name              |

### Supported Roles

* ADMIN
* RECRUITER
* CANDIDATE

---

## users

Stores user information.

| Column Name   | Data Type    | Constraints      | Description                 |
| ------------- | ------------ | ---------------- | --------------------------- |
| user_id       | BIGSERIAL    | PK               | Unique user identifier      |
| first_name    | VARCHAR(100) | NOT NULL         | User first name             |
| last_name     | VARCHAR(100) | NOT NULL         | User last name              |
| email         | VARCHAR(255) | UNIQUE, NOT NULL | User email                  |
| password_hash | VARCHAR(255) | NOT NULL         | BCrypt password hash        |
| role_id       | BIGINT       | FK               | Reference to roles table    |
| is_active     | BOOLEAN      | DEFAULT TRUE     | Account status              |
| created_at    | TIMESTAMP    | NOT NULL         | Record creation timestamp   |
| updated_at    | TIMESTAMP    | NOT NULL         | Last modification timestamp |

---

## exams

Stores examination information.

| Column Name      | Data Type    | Constraints | Description                 |
| ---------------- | ------------ | ----------- | --------------------------- |
| exam_id          | BIGSERIAL    | PK          | Unique exam identifier      |
| title            | VARCHAR(255) | NOT NULL    | Exam title                  |
| description      | TEXT         | NULL        | Exam description            |
| duration_minutes | INTEGER      | NOT NULL    | Exam duration               |
| passing_score    | DECIMAL(5,2) | NOT NULL    | Passing score               |
| start_time       | TIMESTAMP    | NOT NULL    | Exam start time             |
| end_time         | TIMESTAMP    | NOT NULL    | Exam end time               |
| created_by       | BIGINT       | FK          | Recruiter who created exam  |
| created_at       | TIMESTAMP    | NOT NULL    | Record creation timestamp   |
| updated_at       | TIMESTAMP    | NOT NULL    | Last modification timestamp |

---

## questions

Stores examination questions.

| Column Name      | Data Type    | Constraints | Description                       |
| ---------------- | ------------ | ----------- | --------------------------------- |
| question_id      | BIGSERIAL    | PK          | Unique question identifier        |
| exam_id          | BIGINT       | FK          | Reference to exam                 |
| question_text    | TEXT         | NOT NULL    | Question content                  |
| question_type    | VARCHAR(50)  | NOT NULL    | SINGLE_CORRECT / MULTIPLE_CORRECT |
| difficulty_level | VARCHAR(20)  | NOT NULL    | EASY / MEDIUM / HARD              |
| marks            | DECIMAL(5,2) | NOT NULL    | Positive marks                    |
| negative_marks   | DECIMAL(5,2) | DEFAULT 0   | Negative marks                    |
| created_at       | TIMESTAMP    | NOT NULL    | Record creation timestamp         |
| updated_at       | TIMESTAMP    | NOT NULL    | Last modification timestamp       |

---

## options

Stores answer options.

| Column Name | Data Type | Constraints | Description                 |
| ----------- | --------- | ----------- | --------------------------- |
| option_id   | BIGSERIAL | PK          | Unique option identifier    |
| question_id | BIGINT    | FK          | Reference to question       |
| option_text | TEXT      | NOT NULL    | Option content              |
| is_correct  | BOOLEAN   | NOT NULL    | Correct answer indicator    |
| created_at  | TIMESTAMP | NOT NULL    | Record creation timestamp   |
| updated_at  | TIMESTAMP | NOT NULL    | Last modification timestamp |

---

## exam_assignments

Stores candidate exam assignments.

| Column Name   | Data Type   | Constraints | Description                        |
| ------------- | ----------- | ----------- | ---------------------------------- |
| assignment_id | BIGSERIAL   | PK          | Unique assignment identifier       |
| exam_id       | BIGINT      | FK          | Assigned exam                      |
| candidate_id  | BIGINT      | FK          | Assigned candidate                 |
| assigned_at   | TIMESTAMP   | NOT NULL    | Assignment timestamp               |
| started_at    | TIMESTAMP   | NULL        | Exam start timestamp               |
| submitted_at  | TIMESTAMP   | NULL        | Exam submission timestamp          |
| status        | VARCHAR(30) | NOT NULL    | ASSIGNED / IN_PROGRESS / SUBMITTED |
| created_at    | TIMESTAMP   | NOT NULL    | Record creation timestamp          |
| updated_at    | TIMESTAMP   | NOT NULL    | Last modification timestamp        |

---

## candidate_answers

Stores candidate responses.

| Column Name   | Data Type | Constraints | Description              |
| ------------- | --------- | ----------- | ------------------------ |
| answer_id     | BIGSERIAL | PK          | Unique answer identifier |
| assignment_id | BIGINT    | FK          | Assignment reference     |
| question_id   | BIGINT    | FK          | Question reference       |
| option_id     | BIGINT    | FK          | Selected option          |
| answered_at   | TIMESTAMP | NOT NULL    | Response timestamp       |

### Design Note

For Multiple Correct Answer questions, one row is stored per selected option.

This structure supports the MVP while keeping the schema simple.

---

## results

Stores examination results.

| Column Name   | Data Type    | Constraints | Description                 |
| ------------- | ------------ | ----------- | --------------------------- |
| result_id     | BIGSERIAL    | PK          | Unique result identifier    |
| assignment_id | BIGINT       | FK, UNIQUE  | Assignment reference        |
| score         | DECIMAL(5,2) | NOT NULL    | Candidate score             |
| percentage    | DECIMAL(5,2) | NOT NULL    | Result percentage           |
| status        | VARCHAR(20)  | NOT NULL    | PASS / FAIL                 |
| created_at    | TIMESTAMP    | NOT NULL    | Record creation timestamp   |
| updated_at    | TIMESTAMP    | NOT NULL    | Last modification timestamp |

---

## audit_logs

Stores audit and security events.

| Column Name | Data Type    | Constraints | Description              |
| ----------- | ------------ | ----------- | ------------------------ |
| log_id      | BIGSERIAL    | PK          | Unique log identifier    |
| user_id     | BIGINT       | FK          | User reference           |
| action      | VARCHAR(255) | NOT NULL    | Action performed         |
| entity_type | VARCHAR(100) | NOT NULL    | Target entity type       |
| entity_id   | BIGINT       | NULL        | Target entity identifier |
| ip_address  | VARCHAR(50)  | NULL        | Client IP address        |
| created_at  | TIMESTAMP    | NOT NULL    | Event timestamp          |

---

# 3. Database Relationships

## roles → users

One role can be assigned to many users.

```text
roles (1) -------- (*) users
```

---

## users → exams

One recruiter can create many exams.

```text
users (1) -------- (*) exams
```

---

## exams → questions

One exam contains many questions.

```text
exams (1) -------- (*) questions
```

---

## questions → options

One question contains many options.

```text
questions (1) -------- (*) options
```

---

## users → exam_assignments

One candidate can receive multiple exam assignments.

```text
users (1) -------- (*) exam_assignments
```

---

## exam_assignments → candidate_answers

One assignment contains multiple answers.

```text
exam_assignments (1) -------- (*) candidate_answers
```

---

## exam_assignments → results

One completed assignment generates one result.

```text
exam_assignments (1) -------- (1) results
```

---

## users → audit_logs

One user can generate many audit log records.

```text
users (1) -------- (*) audit_logs
```

---

# 4. Index Strategy

Indexes improve lookup speed and query performance.

## users.email

Purpose:

* Fast authentication lookup
* Enforce uniqueness

```sql
CREATE UNIQUE INDEX idx_users_email
ON users(email);
```

---

## exam_assignments.candidate_id

Purpose:

* Faster candidate dashboard loading
* Efficient assignment retrieval

```sql
CREATE INDEX idx_exam_assignments_candidate
ON exam_assignments(candidate_id);
```

---

## exam_assignments.exam_id

Purpose:

* Faster exam assignment searches

```sql
CREATE INDEX idx_exam_assignments_exam
ON exam_assignments(exam_id);
```

---

## questions.exam_id

Purpose:

* Faster question loading during exams

```sql
CREATE INDEX idx_questions_exam
ON questions(exam_id);
```

---

## results.assignment_id

Purpose:

* Fast result retrieval
* One result per assignment enforcement

```sql
CREATE UNIQUE INDEX idx_results_assignment
ON results(assignment_id);
```

---

## audit_logs.user_id

Purpose:

* Efficient audit searches

```sql
CREATE INDEX idx_audit_logs_user
ON audit_logs(user_id);
```

---

# 5. Database Constraints

## Unique Constraints

```sql
UNIQUE(email)
UNIQUE(role_name)
UNIQUE(assignment_id)
```

---

## Not Null Constraints

```sql
NOT NULL(first_name)
NOT NULL(last_name)
NOT NULL(email)
NOT NULL(password_hash)
```

---

## Foreign Key Constraints

```sql
users.role_id
    REFERENCES roles(role_id)

exams.created_by
    REFERENCES users(user_id)

questions.exam_id
    REFERENCES exams(exam_id)

options.question_id
    REFERENCES questions(question_id)

exam_assignments.exam_id
    REFERENCES exams(exam_id)

exam_assignments.candidate_id
    REFERENCES users(user_id)

candidate_answers.assignment_id
    REFERENCES exam_assignments(assignment_id)

candidate_answers.question_id
    REFERENCES questions(question_id)

candidate_answers.option_id
    REFERENCES options(option_id)

results.assignment_id
    REFERENCES exam_assignments(assignment_id)

audit_logs.user_id
    REFERENCES users(user_id)
```

---

## Check Constraints

### Difficulty Level

```sql
CHECK (
 difficulty_level IN (
   'EASY',
   'MEDIUM',
   'HARD'
 )
)
```

### Assignment Status

```sql
CHECK (
 status IN (
   'ASSIGNED',
   'IN_PROGRESS',
   'SUBMITTED'
 )
)
```

### Exam Duration

```sql
CHECK(duration_minutes > 0)
```

### Passing Score

```sql
CHECK(passing_score >= 0)
```

### Marks

```sql
CHECK(marks > 0)
```

### Negative Marks

```sql
CHECK(negative_marks >= 0)
```

### Score

```sql
CHECK(score >= 0)
```

### Percentage

```sql
CHECK(
 percentage >= 0
 AND percentage <= 100
)
```

---

# 6. Audit Timestamp Strategy

To support auditing and future reporting requirements, business tables include:

```sql
created_at TIMESTAMP NOT NULL
updated_at TIMESTAMP NOT NULL
```

Applied to:

* users
* exams
* questions
* options
* exam_assignments
* results

Benefits:

* Change Tracking
* Historical Analysis
* Easier Debugging
* Better Auditability

---

# 7. Database Design Decisions

## Why PostgreSQL?

* ACID Compliance
* Reliability
* Performance
* Excellent Spring Boot Integration

## Why Separate Roles Table?

* Database Normalization
* Flexible Role Management
* Future Expansion

## Why Exam Assignments?

* Supports Candidate-Specific Exams
* Tracks Exam Lifecycle
* Simplifies Result Generation

## Why Audit Logs?

* Security Monitoring
* Compliance Requirements
* User Activity Tracking

## Why Difficulty Levels?

* Better Exam Design
* Candidate Assessment Analytics

## Why Negative Marking?

* Competitive Examination Support
* More Accurate Skill Evaluation

---

# Database Status

Ready For:

1. ER Diagram Creation
2. PostgreSQL DDL Scripts
3. Flyway Migration Scripts
4. JPA Entity Design
5. Repository Layer Development

---

# Deliverable

```bash
git commit -m "Add database design documentation"
```
