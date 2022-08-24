[![Build](https://github.com/ppatierno/formula1-telemetry/actions/workflows/build.yml/badge.svg)](https://github.com/ppatierno/formula1-telemetry/actions/workflows/build.yml)
[![Open in Visual Studio Code](https://open.vscode.dev/badges/open-in-vscode.svg)](https://open.vscode.dev/ppatierno/formula1-telemetry)

# Formula 1 - Telemetry decoding

Formula 1 202x game (by CodeMasters/EA Sports) for PC, PS4 and XBox, allows enabling telemetry data to be sent over UDP during a race.
This Java library provides a decoder for all the produced packets.
Starting from the raw bytes, it builds a specific model exposing all the telemetry data.

The packet format is the one from the 2020 edition, but the library can be used with the latest game editions as well.
In order to do so, you have to select the packet format as 2020 when enabling the telemetry in the game.
Anyway, the library allows selecting the latest seasons for teams, drivers and tracks even if using the old 2020 packet format.
For more information see [season selection](#season-selection)

## Packets specification

The telemetry packets specification is in the official CodeMasters forum [here](https://forums.codemasters.com/topic/54423-f1%C2%AE-2020-udp-specification/).

## Season selection

In order to select the season to be used for teams, drivers and tracks, you need to set the `F1_TELEMETRY_SEASON` environment variable when starting the application using the library itself.

## Build

In order to build and install the library in the local Maven repository, just run the following command.

```shell
mvn install
```

## Tools

The `f1-telemetry-enum-extractor` project provides a tool for converting a CSV file with teams, drivers or tracks information into corresponding Java enums.
The CSV has to have a couple per line in the format `<ID, team|driver|track>`.
The produced Java enums list is useful for developer purposes when adding new seasons to the library.