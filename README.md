# Basic Java Practice Repo

A personal Java practice repository built while learning core Java, OOP, and JDBC — created as part of the **TNS India Foundation (TNSIF)** Campus to Corporate (C2TC) training program.

## About the Program

This project was developed during a **Campus to Corporate (C2TC)** training program run by **TNS India Foundation (TNSIF)**, a non-profit organization focused on preparing under-resourced college students for the formal workforce. The C2TC program is sponsored by **Accenture** under its CSR (Corporate Social Responsibility) initiative, and provides free technical and soft-skills training to eligible students to help them become job-ready for entry-level IT roles.

This particular batch was conducted **offline, on-campus at Cambridge Institute of Technology (CITECH)**.

The package naming convention used throughout this repo reflects that origin:

```
org.tnsif.acc.c2tc.*
```
- `tnsif` → TNS India Foundation
- `acc` → Accenture
- `c2tc` → Campus to Corporate

## What This Repo Is

This is a **learning/practice repository**, not a production application. It's a running collection of small, self-contained Java programs written while working through core Java concepts during the training — each one focused on demonstrating a single concept in isolation, meant to be read, run, and referred back to rather than deployed anywhere.

## Project Structure

```
src/
├── org/tnsif/acc/
│   ├── c2tc/                          Concept-by-concept OOP & Java practice
│   │   ├── abstraction/
│   │   ├── collectionsdemo/           ArrayList, LinkedList, Stack, Queue, Set, Map, Comparator...
│   │   ├── constructordemo/
│   │   ├── datatypes/
│   │   ├── encapsulation/
│   │   ├── exceptionhandling/
│   │   ├── inheritance_hierarchical/
│   │   ├── inheritance_multilevel/
│   │   ├── inheritance_single/
│   │   ├── instanceof_demo/
│   │   ├── interfacedemo/
│   │   ├── jdbcdemo/                  JDBC CRUD against PostgreSQL (placeholder credentials)
│   │   ├── lambdaexpdemo/
│   │   ├── markerinterface/
│   │   ├── methodoverriding_super/
│   │   ├── methodoverriding_super_this/
│   │   ├── oop_basics/
│   │   ├── polymorphism/
│   │   ├── scannerclass_bufferreader/
│   │   ├── streamapi/
│   │   ├── super_variable/
│   │   ├── this_keyword/
│   │   ├── typecasting/
│   │   └── wrapperclass/
│   └── interviewquestions/            Classic coding interview questions
│       ├── arrays/                    Duplicates, min/max, second largest
│       ├── numbers/                   Palindrome check, Fibonacci
│       ├── patterns/                  Singleton
│       └── strings/                   Reverse string, palindrome, char frequency
└── com/tnsif/postgresql/              JDBC CRUD against a real local PostgreSQL COMPANY table

demo/                                  Separate Spring Boot + Maven project (spring-boot-starter-jdbc/webmvc)
```

Each `.java` file is independently runnable — no cross-file dependencies beyond what sits in the same package.

## Running the Code

Most files here are plain Java with a `main` method — run them directly from an IDE, or from the command line:

```bash
cd src
javac org/tnsif/acc/c2tc/<package>/<File>.java
java org.tnsif.acc.c2tc.<package>.<File>
```

The `demo/` folder is a separate Maven project — build/run it with Maven or your IDE's Spring Boot support.

## Database Setup (JDBC packages only)

The `jdbcdemo` and `com.tnsif.postgresql` packages, plus the `demo` Spring Boot app, connect to a local PostgreSQL instance. Credentials are **not hardcoded** — the password is read from a `.env` file (gitignored, never committed):

```
DB_PASSWORD=your_actual_password
```

Place a `.env` at the repo root (for the plain JDBC classes) and another inside `demo/` (for the Spring Boot app). You'll also need:
- A local PostgreSQL server running
- The PostgreSQL JDBC driver on the classpath (already declared as a Maven dependency for `demo/`; add it manually as a library for the plain `src/` module in your IDE)

## Note

This is an evolving practice repo — expect new topics and folders to be added over time as more concepts are covered in the training.
