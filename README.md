# Veeva Assignment
## This repository contains a test automation framework with a few automated tests using Java, Selenium, TestNG and Cucumber.

## Instructions:
1. Install JDK and Maven in the system where the tests should be executed.
2. Install the browser according to the requirement i.e. Chrome, Firefox etc. in the system.
3. clone this repo from the Github
4. Set the current working directory as ./veeva/ from the shell/bash
```shell
cd ./veeva/
```
5. There are 4 profiles in this repo for Chrome, Edge & Firefox. To execute the tests in a particular browser, run the command from the shell/bash
```shell
mvn clean test -P<Browsername> verify
```
Example: If you need to execute the tests in Edge browser, run:
```shell
mvn clean test -Pedge verify
```
6. After running the above command, the Scenarios in the feature files will be executed in parallel.
7. Check inside the Results/ directory for the generated reports.

## Specifications:
### Design and Execution Approach : Must to Have - Mandatory Section:
1. - [x] Maven project with root folders as src/main and src/test
2. - [x] Feature Files, Step Definitions, Business Logics, Page Objects, Test Data and Reusable Utility Methods are independent but interlinked.
3. - [x] src/main root folder should not hold any test classes/methods and src/test should not hold any reusable component classes/methods
4. - [x] Project configuration settings and Test data should be Parameterized not hard coded
5. - [x] Usage of Static waits should be limited
6. - [x] Page locators should be organized in proper Page Object Model design pattern
7. - [x] Cucumber Runner class should be created with appropriate Cucumber Options
8. - [x] Test cases should be run parallely from testng.xml file in one or multiple browsers (Chrome, Firefox etc..)
9. - [x] Proper Report should be generated

### Design & Execution Approach :Good to Have - Bonus Section Additional
1. - [ ] As the assessment is to automate 3 products, design the framework in the Multi Module Maven project with 4 modules.
    1.	Module 1: automation-framework
    2.	Module 2: core-product-tests
    3.	Module 3: derived-product1-tests
    4.	Module 4: derived-product2-tests
2. - [ ] The automation-framework module will hold all the reusable code and it will be shared to all 3 test modules.Test modules will hold their product specific codes that cannot be shared across.
3. - [x] Dynamic use of browser binaries(Chrome,Firefox etc..) for web driver creation
4. - [ ] Zero Usage of By class, if you are designing Page Object Model design pattern
5. - [N/A] If you are using the Page Factory design pattern,PageFactory.initElements() should be called only in one place throughout the Framework. It should not be called in each Page class constructor.
6. - [N/A] Use JSON/YAML file to maintain test data
7. - [x] Use Cucumber Hooks effectively
8. - [ ] Don’t pass cucumber Tags from Runner Class, Pass cucumber tags from testng.xml file and bind the tag to Runner Class during runtime
9. - [ ] Generate Runner classes for each Feature file during runtime.
10. - [x] Run the test scenarios in multiple threads without using testng.xml file and by using maven commands

## Test Case(s) Automated: (Minimum 2 Test Cases Were Required)

1. Test Case 1: for CP
    1. From the CP home page , go to >> Shop Menu >> Men’s
    2. Find all Jackets ( from all paginated pages)
    3. Store each Jacket Price, Title and Top Seller message to a text file
    4. Attach the text file to the report
2. Test Case 2: for CP
    1. From the CP home page , hover on [...] menu Item >> click on New & Features
    2. Count total number of Videos Feeds and count the videos feeds those are present in the page >= 3d