@DP
Feature: This feature file contains test scenarios for the Derived Product 2

    Background: Open the Derived Product 2 URL in browser
        Given Open a browser and load the Derived Product 2 URL


    @DP2
    Scenario: In DP2 Find and store all footer hyperlink details
        Given the Second Derived Product homepage is displayed
        When the user scrolls down to the footer
        Then the user should be able to store the hyperlinks of all the links and report duplicates