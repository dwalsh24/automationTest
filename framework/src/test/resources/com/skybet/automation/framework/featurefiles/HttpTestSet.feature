Feature: Test the live and sportsbook api responses

@tc_01
Scenario: Assert that the football/live page returns an api response
Given user gets live football events
#Then user gets football event "2" from live events
Then user gets football event with eventId "#tc_01,eventId" from live events
Then user verifies event name = "#tc_01,name"

