[![Develop Build](https://travis-ci.com/mmonkeyteam/a-new-todos.svg?branch=develop)](https://travis-ci.com/mmonkeyteam/a-new-todos)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
[![CodeFactor](https://www.codefactor.io/repository/github/mmonkeyteam/a-new-todos/badge)](https://www.codefactor.io/repository/github/mmonkeyteam/a-new-todos)

# A new TODOs

## Join the chat 

[![Slack chat](https://slack.global.ssl.fastly.net/272a/img/icons/favicon-32.png)](https://join.slack.com/t/monkeyteam-hq/shared_invite/enQtNzI4MTg2OTU2MzA4LTM0MzkzMDJhYjIzYzUwOTNjYWFjMmM1NDM3NGRhNGExMWU3NmU0YmZhNGExMzY5N2Y1MTUwNWM3MmI3MWJhMjc)  

## Description


## Build environment requirements

-  JDK 1.8 or later

## Building

The project is built with Gradle, and a wrapper in the root is provided.
Run Gradle to build the project and to run the tests using the following command on Unix/macOS:

```bash
./gradlew <tasks-and-options>
```

or the following command on Windows:

```dos
gradlew <task-and-options>
```
To build the project, type:

```bash
gradlew build
```
### Execute test in verbose mode

```bash
./gradlew test -i
```

### Apply [ktlin rules](https://ktlint.github.io/#rules)  

This project uses the plugin [kotlinder](https://github.com/jeremymailen/kotlinter-gradle) 
to check the style of the code in Kotlin.
 
To check if the style is ok, type:

```bash
./gradlew lintKotlin
```

To format the code automatically, use:

```bash
./gradlew formatKotlin
```
