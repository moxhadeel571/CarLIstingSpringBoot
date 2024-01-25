# CarDekho

CarDekho is a car listing application that allows users to browse, buy, and sell cars. It features an integrated SMS contact system using Twilio for efficient communication between buyers and sellers.

## Table of Contents

1. [Introduction](#introduction)
   - [Overview](#overview)
   - [Features](#features)

2. [Installation](#installation)
   - [Prerequisites](#prerequisites)
   - [Setup Instructions](#setup-instructions)
   - [Configuration](#configuration)

## Introduction

### Overview

CarDekho is designed to simplify the process of buying and selling cars. Users can explore various car listings, contact sellers via SMS using Twilio, and list their cars for sale.

### Features

- Browse and search for cars
- Contact sellers through SMS
- List cars for sale with details and images

## Installation

### Prerequisites

Before setting up CarDekho, ensure you have the following:

- Java Development Kit (JDK)
- Gradle build tool
- Twilio account for SMS integration
- MongoDB installed
- IDE (IntelliJ or Eclipse)

### Setup Instructions

1. **Clone the Repository:**
   ```
   git clone <repository-url>
   ```

2. **Import Project into IDE:**
   - Open the project in your preferred IDE.

3. **Configure Twilio Credentials:**
   - Obtain Twilio API credentials and update them in the project.

4. **Configure MongoDB Connection:**
   - Set up MongoDB connection details in `application.properties`.

5. **Build the Project:**
   ```
   ./gradlew build
   ```

6. **Run the Application:**
   - Run the main application class.

7. **Access the Application:**
   - Open the application in your web browser.

### Configuration

Customize configurations for:

- Application properties
- Database connection
- Twilio integration

Ensure the configurations align with your environment and requirements.

---
