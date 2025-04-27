# Comprehensive Artifact and Asset Console Project

Welcome to the **Comprehensive Artifact and Asset Console Project**!  
This is an advanced **Java console-based application** designed to manage a wide variety of valuable objects — including **weapons**, **jewelry**, **coins**, and **museum artifacts**.  
It provides powerful CRUD operations, filtering, and database interactions to simulate a real-world museum or archaeological management system.

---
## ✨ Screens
![j1](https://github.com/user-attachments/assets/40b6e39d-50f8-4a50-ad29-8c328824e97d)
![j2](https://github.com/user-attachments/assets/73a262a5-87ad-4a24-8790-71a5473a76f2)
![j3](https://github.com/user-attachments/assets/f8f75291-c94c-4ae8-994c-34f75bad3557)
![j4](https://github.com/user-attachments/assets/b407977d-f781-49d2-af84-add8bc7f1d18)


## ✨ Features

- **Add New Artifacts**  
  Insert new records for different categories such as Coins, Weapons, Jewelry, and more.

- **View All Discovered Artifacts**  
  Display detailed information about all objects in the collection, including descriptions, materials, and discovery locations.

- **Filter by Discovery Date**  
  List artifacts discovered before a user-specified date.

- **Artifact Count Overview**  
  Quickly retrieve the total number of recorded artifacts.

- **View Records from Specific Categories**  
  Fetch and display records separately from tables like `Person`, `Museum`, `Coin`, `Weapon`, and `Jewelry`.

- **Read Artifact Data from Text File**  
  Read and display artifact data stored in a text file (such as `funn.txt`).

---

## 🛠️ Technology Stack

- **Java** (Console Application)
- **MySQL** (Database Management)
- **JDBC** (Java Database Connectivity)
- **Text File Handling** (for additional artifact data)

---

## 🗄️ Database Structure

The application interacts with a MySQL database containing the following tables:

| Table        | Description                                    |
|--------------|------------------------------------------------|
| `Person`     | Stores data about individuals (Name, Phone, Email) |
| `Museum`     | Information about museums and exhibition sites  |
| `Coin`       | Coin-specific records (Material, Value, Found Date) |
| `Weapon`     | Records of discovered weapons (Type, Material, Age) |
| `Jewelry`    | Records about jewelry (Gemstone, Material, Estimated Value) |

---

## ⚙️ Setup Instructions

### Prerequisites
- Java JDK installed (version 8 or above)
- MySQL Server installed
- Git installed (optional but recommended)

---

### 1. Clone the Repository

```bash
git clone https://github.com/MuhammadSaqibAbro/Comprehensive-Artifact-and-Asset-Console-Project.git
cd Comprehensive-Artifact-and-Asset-Console-Project
