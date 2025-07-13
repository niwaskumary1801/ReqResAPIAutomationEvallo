# ReqResAPIAutomationEvallo
API Automation Demo Assessment Project

# ReqRes API Automation Framework

This project is an **API test automation framework** built using **Java**, **RestAssured**, **TestNG**, and **ExtentReports** to validate the core functionalities of the [User API](https://reqres.in/). The framework supports **CI/CD using GitHub Actions** and **generates test reports**.

## Tech Stack

| Tool/Library      | Purpose                                |
|-------------------|----------------------------------------|
| Java (21)         | Programming language                   |
| RestAssured       | API automation                         |
| TestNG            | Test execution framework               |
| ExtentReports     | HTML reporting                         |
| Maven             | Build and dependency management        |
| GitHub Actions    | CI/CD pipeline                         |
                         |

## API Coverage

The framework covers all **CRUD operations** and includes:

- **User Management**  
  - Create User   
  - Get User
  - Get All users   

- **Update and Delete**  
  - Update the User Details 
  - Delete User 

## Testing Strategy

### 1. **Approach to Writing Test Flows**
- Created modular tests for user and book operations.
- Ensured test data like names are **randomized using Math.Random class** to avoid conflicts for duplicacy.
- Used request chaining (e.g., name from `/User ).

### 2. **Reliability & Maintainability**
- Centralized base URL and credentials in `config.properties`.
- Separated test logic, config, utilities, and reporting.
- Used assertions on status codes, response payloads.
- Included positive test scenarios.
- Implemented `BaseTest` to initialize ExtentReports and RestAssured.

### 3. **Challenges & Solutions**
| Challenge | Solution |
|----------|----------|
| Some API endpoints returned 400/401 unexpectedly | Added proper headers and verified request bodies |
| Dynamic data | Used randomization to generate unique names |

## CI/CD Pipeline

### Trigger:  
Runs on **every push** and **pull request** to `main`.

### Steps in CICD process:
- Checkout code
- Setup Java (Temurin 17)
- Build and run tests via Maven
- Upload test reports:
  - Surefire Reports (TestNG)
  - ExtentReports (HTML)
  - JaCoCo (code coverage)

## Running Tests Locally

### Clone the repo in the required directory on your PC if you want to run locally:
git clone 

cd ReqResAPIAutomationEvallo

Run test using Maven:
mvn clean test

View the report in your browser. Reports are present in the path:
test-output/ExtentReports.html

## How to View GitHub Actions Reports
Go to repo URL (https://github.com/niwaskumary1801/ReqResAPIAutomationEvallo.git) → Actions
Click on the latest workflow run.
Scroll to Artifacts.

Download-

Extent Report (ExtentReports.html)

JaCoCo Report (index.html)

Surefire Report

## Contributing to repo:
Fork the repo

Create your feature branch (git checkout -b feature/add-new-test)

Commit and push

Submit a pull request


## Authors

- https://github.com/niwaskumary1801/ReqResAPIAutomationEvallo
