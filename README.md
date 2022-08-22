[![Build](https://github.com/ppatierno/formula1-telemetry/actions/workflows/build.yml/badge.svg)](https://github.com/ppatierno/formula1-telemetry/actions/workflows/build.yml)
[![Open in Visual Studio Code](https://open.vscode.dev/badges/open-in-vscode.svg)](https://open.vscode.dev/ppatierno/formula1-telemetry)

# Formula 1 - Telemetry decoding

Formula 1 2020 game (by CodeMasters) for PC, PS4 and XBox, allows enabling telemetry data to be sent over UDP during a race.
This Java library provides a decoder for all the produced packets.
Starting from the raw bytes, it builds a specific model exposing all the telemetry data.

## Packets specification

The telemetry packets specification is in the official CodeMasters forum [here](https://forums.codemasters.com/topic/54423-f1%C2%AE-2020-udp-specification/).

## Build

In order to build and install the library in the local Maven repository, just run the following command.

```shell
mvn install
```

## Tools

The `f1-telemetry-enum-extractor` project provides a tool for converting a CSV file with teams, drivers or tracks information into corresponding Java enums.
The CSV has to have a couple per line in the format `<ID, team|driver|track>`.
The produced Java enums list is useful for developer purposes when adding new seasons to the library.