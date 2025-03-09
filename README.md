# Veeva Assignment
## This repository contains a test automation framework with a few automated tests using Java, Selenium, TestNG and Cucumber.

### Instructions:
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
6. Afyet running the above command, the Scenarios in the feature files will be executed in parallel.
7. Check inside the Results/ directory for the generated reports.