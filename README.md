# Item API - Spring Boot REST Backend

A simple, clean, and professional RESTful API built using Spring Boot to manage a collection of items (similar to ecommerce products like Flipkart or movies like Netflix). This application demonstrates backend fundamentals including REST API design, layered architecture, input validation, exception handling, and in-memory data storage.

This project was developed as part of a freelance Java backend assignment.

---

## Live Demo

(Will be added after deployment)

Example:

```
https://itemapi.onrender.com/api/items/1
```

---

## Tech Stack

* Java 21
* Spring Boot 3
* Maven
* REST API
* ConcurrentHashMap (thread-safe in-memory storage)
* Git & GitHub

---

## Features

* Add new item
* Get item by ID
* Thread-safe in-memory storage
* Input validation
* Global exception handling
* Clean layered architecture (Controller → Service → Repository)
* Professional DTO design
* Automatic ID generation
* Timestamp tracking (createdAt, updatedAt)

---

## Project Architecture

```
com.example.itemapi
│
├── controller
│     └── ItemController.java
│
├── service
│     ├── ItemService.java
│     └── ItemServiceImpl.java
│
├── repository
│     ├── ItemRepository.java
│     └── InMemoryItemRepository.java
│
├── model
│     └── Item.java
│
├── dto
│     ├── ItemRequest.java
│     └── ItemResponse.java
│
├── exception
│     ├── ApiError.java
│     ├── ValidationException.java
│     ├── ResourceNotFoundException.java
│     └── GlobalExceptionHandler.java
│
├── util
│     └── IdGenerator.java
│
└── ItemapiApplication.java
```

---

## How to Run Locally

### Step 1: Clone the repository

```
git clone https://github.com/Harsh3358/itemapi.git
```

### Step 2: Navigate into the project folder

```
cd itemapi
```

### Step 3: Run the application

```
mvn spring-boot:run
```

Server starts on:

```
http://localhost:8080
```

---

## API Endpoints

Base URL:

```
http://localhost:8080/api/items
```

---

## 1. Add Item

**Endpoint**

```
POST /api/items
```

**Request Body**

```json
{
  "name": "iPhone 15",
  "description": "Apple smartphone",
  "price": 79999,
  "category": "Electronics"
}
```

**Response (201 Created)**

```json
{
  "id": 1,
  "name": "iPhone 15",
  "description": "Apple smartphone",
  "price": 79999,
  "category": "Electronics",
  "createdAt": "2026-02-13T12:00:00Z"
}
```

---

## 2. Get Item by ID

**Endpoint**

```
GET /api/items/{id}
```

**Example**

```
GET /api/items/1
```

**Response (200 OK)**

```json
{
  "id": 1,
  "name": "iPhone 15",
  "description": "Apple smartphone",
  "price": 79999,
  "category": "Electronics",
  "createdAt": "2026-02-13T12:00:00Z"
}
```

---

## 3. Update Item

**Endpoint**

```
PUT /api/items/{id}
```

**Description**

Updates an existing item using its ID.

If the item does not exist, a `404 Not Found` error is returned.

---

**Example Request**

```
PUT /api/items/1
```

**Request Body**

```json
{
  "name": "Updated Laptop",
  "description": "Updated gaming laptop",
  "price": 95000,
  "category": "Electronics"
}
```

**Response (200 OK)**

```json
{
  "id": 1,
  "name": "Updated Laptop",
  "description": "Updated gaming laptop",
  "price": 95000,
  "category": "Electronics",
  "createdAt": "2026-02-13T12:00:00Z"
}
```

---

## 4. Delete Item

**Endpoint**

```
DELETE /api/items/{id}
```

**Description**

Deletes an item using its ID.

If the item does not exist, a `404 Not Found` error is returned.

---

**Example Request**

```
DELETE /api/items/1
```

**Response**

```
204 No Content
```

This means the item was successfully deleted and no response body is returned.

---

## Updated API Summary

| Method | Endpoint        | Description       |
| ------ | --------------- | ----------------- |
| POST   | /api/items      | Create a new item |
| GET    | /api/items/{id} | Get item by ID    |
| PUT    | /api/items/{id} | Update item       |
| DELETE | /api/items/{id} | Delete item       |


## Error Handling

### Validation Error Example

```
POST /api/items
```

Request:

```json
{
  "description": "Test item"
}
```

Response (400 Bad Request):

```json
{
  "message": "Item name is required",
  "status": 400,
  "timestamp": "2026-02-13T12:30:00Z"
}
```

---

### Resource Not Found Example

```
GET /api/items/999
```

Response (404 Not Found):

```json
{
  "message": "Item not found with id: 999",
  "status": 404,
  "timestamp": "2026-02-13T12:30:00Z"
}
```

---

## Storage Mechanism

This application uses:

```
ConcurrentHashMap<Long, Item>
```

Benefits:

* Thread-safe
* Fast lookup (O(1))
* No external database required
* Suitable for demo and testing purposes

---

## ID Generation

IDs are generated using:

```
AtomicLong
```

This ensures:

* Unique IDs
* Thread-safe generation
* No collision

---

## Build Project

```
mvn clean install
```

---

## Run JAR file

```
java -jar target/itemapi-0.0.1-SNAPSHOT.jar
```

---

## Future Improvements

* Database integration (MySQL / PostgreSQL)
* Pagination support
* Authentication and authorization
* Docker containerization

---

## Author

Harsh Raj

GitHub:

https://github.com/Harsh3358/

---
