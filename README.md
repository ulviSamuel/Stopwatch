# Stopwatch

An educational Java 11 command-line stopwatch that tracks total elapsed time and lap time through an explicit state-machine implementation.

[![Java 11](https://img.shields.io/badge/Java-11-007396?style=flat-square&logo=openjdk&logoColor=white)](https://docs.oracle.com/en/java/javase/11/)
[![Command-line application](https://img.shields.io/badge/Interface-Command--line-555555?style=flat-square)](#usage)
[![Academic project](https://img.shields.io/badge/Category-Academic%20project-6f42c1?style=flat-square)](#project-context)

> [!NOTE]
> This repository contains an academic project originally developed during earlier programming studies. It is preserved as a record of the technical knowledge, design decisions, and development experience acquired at the time.

## Overview

The application runs an interactive stopwatch in a terminal. It uses a small state machine to distinguish between a reset stopwatch, a running stopwatch, and a paused stopwatch. Console events report state changes and measured times to standard output.

## Features

- Start a new timing session from the reset state.
- Display total elapsed time and the current lap time.
- Record a lap while the stopwatch is running.
- Pause and resume timing while excluding paused intervals from the measured totals.
- Reset the stopwatch from the paused state.
- Exit the interactive console with a single command.

## Technology stack

- **Language:** Java
- **Target Java release:** Java 11
- **Interface:** Standard input and standard output
- **Build configuration:** Eclipse Java project metadata, with compiled output configured for `bin/`

## Architecture

The stopwatch is implemented as a state machine. `Cronometro` owns the timing data and delegates button actions to a `StatiCronometro` state. `StatoReset`, `StatoGo`, and `StatoPause` implement the transitions for reset, running, and paused modes. `CronoConsoleListener` receives `CronoEvent` instances and prints their messages.

## Project structure

```text
src/
└── it/volta/ts/ulivisamuel/cronometro/
    ├── Main.java                         # Application entry point
    ├── Console.java                      # Interactive command loop
    ├── biz/Cronometro.java                # Timing state and calculations
    ├── stati/                             # Stopwatch state implementations
    ├── listener/                          # Console event listener types
    └── util/Util.java                     # Console input helpers
```

The repository also contains Eclipse project metadata and precompiled classes under `bin/`.

## Prerequisites

- Java Development Kit (JDK) 11 or a compatible Java installation that can compile for Java 11.

## Build

From the repository root, compile the source tree into a separate output directory:

```bash
rm -rf /tmp/stopwatch-bin
mkdir -p /tmp/stopwatch-bin
javac -encoding ISO-8859-1 -d /tmp/stopwatch-bin $(find src -name '*.java' -print)
```

The repository's Eclipse configuration instead uses `bin/` as its output directory.

## Usage

Run the compiled application with:

```bash
java -cp /tmp/stopwatch-bin it.volta.ts.ulivisamuel.cronometro.Main
```

At the prompt, enter:

| Input | Action |
| --- | --- |
| `S` | Start the stopwatch, resume after a pause, or record a lap while running |
| `R` | Pause the stopwatch, or reset it when already paused |
| `E` | Exit the application |

The commands are case-insensitive. The application prints state changes and timing values in the console.

## Testing

No automated test sources or test runner are included in the repository. The compilation command above verifies that the Java source tree can be compiled; interactive behavior can be exercised by launching the application and entering the commands described in [Usage](#usage).

## Project context

The package namespace (`it.volta.ts`), Italian instructional comments, and Eclipse Java project structure provide evidence of an educational context. The repository does not include a project report, assignment brief, or other documentation that identifies a specific institution or course.

## License

No license file or explicit license statement is included in the repository.
