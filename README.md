<p align="center">
  <img src="https://github.com/alvarorichard/ArmaSecBank/assets/102667323/e4689d85-a747-4334-a0ab-6c3abd95224b" alt="Imagem logo" />
</p>

# ArmaSecBank
[![GitHub license](https://img.shields.io/github/license/alvarorichard/ArmaSecBank)](alvarorichard/ArmaSecBank/blob/master/LICENSE)
![GitHub stars](https://img.shields.io/github/stars/alvarorichard/ArmaSecBank)
![Build Status](https://github.com/alvarorichard/ArmaSecBank/actions/workflows/ci.yml/badge.svg)
![GitHub languages top](https://img.shields.io/github/languages/top/alvarorichard/ArmaSecBank)
[![GitHub contributors](https://img.shields.io/github/contributors/alvarorichard/ArmaSecBank)](https://github.com/alvarorichard/ArmaSecBank/graphs/contributors)

This project is a Java-based application designed for managing banking operations. It consists of several classes that represent different components of a bank, such as branches (Agencia), authentication (Autenticacao), bank accounts (Conta), customers (Pessoa), and transactions (Transacao).

## Installation

To install this project:

1. Ensure you have Java installed on your system. You can download Java from the official Oracle website.
2. Download the source code from this repository.
3. Extract the files to your preferred directory.
   
## Usage
To use this application:

1. Open your command line or terminal.
2. Navigate to the directory where you extracted the project files.
3. Compile the Java files using the command: javac *.java
4. Run the main application file (assuming Sistema.java is your main file) using: java Sistema

## Features

* Bank Branch Management: Handle operations related to bank branches.
* User Authentication: Securely manage user access.
* [Additional features based on other classes like Conta, Pessoa, Transacao, etc.]
  

## Running in IntelliJ IDEA

1. Install IntelliJ IDEA: Download and install IntelliJ IDEA from JetBrains.
2. Open the Project: Launch IntelliJ IDEA, select 'Open', and navigate to your project directory.
3. Import Project: IntelliJ IDEA will automatically recognize the Java files. If prompted, set the project SDK to the appropriate Java version.
4. Build and Run: Navigate to the main class (likely Sistema.java), right-click, and select 'Run [main class name].main()' to compile and run the project.
   
## Running in Terminal

Compile the Project: Open your terminal, navigate to the project directory, and compile the Java files using:

```bash
javac *.java
```

Run the Application: After compilation, run the main application file using:

```bash
java [main class name]
```

## Running on docker

To run your Java application using Docker, follow these steps:

Build the Docker Image:
```bash
docker build -t arma-sec-bank .
```

Run the Docker Container:
```bash
docker run arma-sec-bank
```

## Contributing
Contributions to this project are welcome. Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes.
4. Push to the branch.
5. Submit a pull request
