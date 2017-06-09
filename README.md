# Alarmclock++
# Aidan McCoy Spring 2017

[![Build Status](https://travis-ci.org/cpe305Spring17/spring2017-project-amccoy.svg?branch=master)](https://travis-ci.org/cpe305Spring17/spring2017-project-amccoy)

![Landing Screen](https://raw.githubusercontent.com/cpe305Spring17/spring2017-project-amccoy/blob/master/Screenshot%20from%202017-06-02%2014-29-43.png)

Alarmclock++ is an Android Application that is changing the way we set, manage and use alarm clocks in out daily lives. To start, Alarmclock++ has the basic functionality that we all expect, setting alarms manually for each day. To keep things simple, one alarm is set for each day of the week and will continue on this schedule until it is changed. This functionality is shown below...

![Alarm Set](https://github.com/cpe305Spring17/spring2017-project-amccoy/blob/master/Screenshot%20from%202017-06-02%2014-29-58.png)

As we take alarm clocks to the next level, I have pushed the project towards full automation. Since alarm clocks are used to wake you up in time to make it to certain events, you only need an alarm if you are sleeping. In order to check your state, the application checks your current locaiton. When you set up this service, you set a home location. The application pulls this info from the location you have set as home on your google maps. This is shown below...

![Location setting1](https://github.com/cpe305Spring17/spring2017-project-amccoy/blob/master/SetLocation.png)

![Location setting2](https://github.com/cpe305Spring17/spring2017-project-amccoy/blob/master/LocaitonSet.png)
![Location setting](https://github.com/cpe305Spring17/spring2017-project-amccoy/blob/master/Emulator.png)


Once you have your location set, your alarms will only go off if you are at home. If you are somewhere else, the application assumes that you are awake and ready to make it to where ever you are going.

Now that we only have alarms going off when we need them, we need them to be set automatically as well to complete the automation functionality. Alarmclock++ integrates with the users Google Calendar getting a list of events for each day. Based off of these events, it then grabs the first event of each day and sets the alarm accordingly. This action is done by selecting the set alarms with calendar option on the set alarms screen. This then takes you to a calendar screen to view events for each upcoming day. If there are no events for that day, no alarms are set and you are free to sleep in!!!

![Calendar](https://github.com/cpe305Spring17/spring2017-project-amccoy/blob/master/Screenshot%20from%202017-06-02%2014-30-07.png)


Here is an overall class diagram representing the structure of the program

![Class Diagram](https://github.com/cpe305Spring17/spring2017-project-amccoy/blob/master/Alarmclock%2B%2B%20Class%20diagram.png)

# Design Patterns

Singleton for locaiton listeners and google calendar

Strategy pattern for setting alarm times
