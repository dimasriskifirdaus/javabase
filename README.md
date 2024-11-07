## Getting Started

Welcome to the javabase project. This repo is for learning some very basic java code that connects to MySQL db.
P.S. This repo is using windows 11

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Requirement Dependency

1. MySQL Local db, you can download it here
   - XAMPP: https://sourceforge.net/projects/xampp/files/XAMPP%20Windows/8.2.12/xampp-windows-x64-8.2.12-0-VS16-installer.exe
   - Laragon: https://github.com/leokhoa/laragon/releases/download/6.0.0/laragon-wamp.exe

## Step to Install

1. Create your local MySQL DB First, open XAMPP or Laragon and create database with this query
   CREATE DATABASE RestaurantDB;

   USE RestaurantDB;

   CREATE TABLE Menu (
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(50) NOT NULL,
   category VARCHAR(50) NOT NULL,
   price DECIMAL(5,2) NOT NULL
   );

   -- Insert sample data
   INSERT INTO Menu (name, category, price) VALUES
   ('Burger', 'Food', 5.00),
   ('Pizza', 'Food', 7.50),
   ('Pasta', 'Food', 6.00),
   ('Salad', 'Food', 4.50),
   ('Water', 'Drink', 1.00),
   ('Soda', 'Drink', 1.50),
   ('Juice', 'Drink', 2.00),
   ('Coffee', 'Drink', 2.50);

2. Pull this repo to your local
   //If ever you don't know how to do this, follow this step//

   - Make sure you already have git on your machine, if you don't, then download on this link https://git-scm.com/download/win
   - Open Git Bash from start menu
   - cd <your-desired-project-folder>
   - git clone <this-repo-link>

3. Open the folder in your vscode, and then click run button on top-right corner of your code
   OR
   Open the terminal below your vscode, then run this command
   java -cp "bin;lib/mysql-connector-j-9.1.0.jar" Main

Now you should see the java apps for the restaurant menu is up and running well!
Thank you and happy coding!
