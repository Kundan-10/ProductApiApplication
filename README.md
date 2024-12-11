# **Product Application API and CSV File Reader**

This repository contains two main components:  
1. **Product Application API**: A Spring Boot-based RESTful API for managing product information.  
2. **CSV File Reader**: A Java utility to process and evaluate CSV files with formulas and values.  

---

## **Product Application API**

### **Description**  
The Product Application API provides endpoints to interact with product data, such as retrieving products by category and adding new products. It leverages Spring Boot's capabilities to deliver a scalable and reliable API.

### **Features**  
- **Retrieve Products by Category**: Fetch products based on their category.  
  - Example: `/api/products/category/{category}`  
- **Add a New Product**: Create a new product entry with details like title, price, and description.  
  - Example: `POST /api/products`  

### **Technologies Used**  
- **Spring Boot**: Framework for building the API.  
- **Lombok**: Reduces boilerplate code for models and services.  
- **Validation**: Ensures input data integrity.  
- **JUnit**: For testing the API.  

---

## **CSV File Reader**

### **Description**  
The CSV File Reader is a utility to process CSV files containing both static values and formulas. The program computes the formulas and outputs the resolved values in a new CSV format.  

### **Features**  
- Parses and evaluates formulas like `=A2+B2` or `=5+A1`.  
- Handles dependencies between cells, ensuring correct computation order.  
- Outputs a new CSV file with all values resolved.  

### **Technologies Used**  
- **Core Java**: To handle file reading, parsing, and formula evaluation.  
- **Data Structures**: Used for managing cell references and dependencies.  

---

## **Setup and Execution**

### **Product Application API**  
1. Clone the repository.  
2. Navigate to the API folder.  
3. Run the application using `mvn spring-boot:run`.  
4. Test the endpoints using tools like Postman or a browser.  

### **CSV File Reader**  
1. Navigate to the CSV Reader folder.  
2. Compile and run the program using `javac` and `java`.  
3. Provide a sample CSV as input.  

---

## **Future Enhancements**  
- Add authentication and authorization to the Product API.  
- Extend CSV File Reader to handle more complex formulas.  

---

This project demonstrates the application of Spring Boot for building APIs and Java for solving real-world problems like file processing.
