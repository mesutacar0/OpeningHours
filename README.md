## Problem Definition

Amy and Valerie own a shop. They need you to develop a simple program that allows
their customers to know their open hours that satisfies the following requirements:

- The opening days and hours of the shop need to be configurable, and can be
  scattered in the week (e.g. Mon, Wed, Fri from 08:00 to 16:00)
- Amy needs to display the date of the next opening on a billboard outside of the
  shop
- Amy also wants to display on the website of the shop whether it is opened or
  closed at the moment
  Write a small module that follows this contract, so that Valerie can easily integrate it:

```shell
OpeningHours.isOpenOn(date)
OpeningHours.nextOpeningDate(date)
```

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Test Cases

There are four unit tests, which can be runned on OpeingHoursTest.java

```shell
Shop opening days: Mon, Wed, Fri
Shop opening hours: 08:00 - 16:00
wednesday = '2016-05-11T12:22:11.824Z'
thursday = '2016-05-12T12:22:11.824Z'
fridayMorning = '2016-05-13T08:00:00.000Z'
OpeningHours.isOpenOn(wednesday) == true
OpeningHours.isOpenOn(thursday) == false
OpeningHours.nextOpeningDate(wednesday) === fridayMorning
```
