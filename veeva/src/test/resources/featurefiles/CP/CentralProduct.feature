@CP
Feature: This feature file contains test scenarios for the Central Product

    Background: Open the Central Product URL in browser
        Given Open a browser and load the Central Product URL

    @CP1
    Scenario: Find and store all jacket details
        Given the Central Product homepage is displayed
        When the user navigates to Shop Menu >> Men’s
        Then the user should be able to filter the list with jackets
        And the user should be able to store the details of all jackets

    @CP2
    Scenario: Find and Count Videos Feeds
        Given the Central Product homepage is displayed
        When the user navigates to Menu Item >> click on New & Features
        Then the user should be able to count the number of video feeds
        And the user should be able to count the number of video feeds present in the page >= 3d