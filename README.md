# Formula 1 - Telemetry decoding

Formula 1 2020 game (by CodeMasters) for PC, PS4 and XBox, allows enabling telemetry data to be sent over UDP during a race.
This Java library provides a decoder for all the produced packets.
Starting from the raw bytes, it builds a specific model exposing all the telemetry data.

## Packets specification

The telemetry packets specification is in the official CodeMasters forum [here](https://forums.codemasters.com/topic/50942-f1-2020-udp-specification/).

## Build

In order to build and install the library in the local Maven repository, just run the following command.

```shell
mvn install
```