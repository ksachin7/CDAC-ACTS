
### **Problem Statement: Library Management System**

Design and implement a **Library Management System** using **Object-Oriented Programming (OOP)** principles in **Java**, focusing on **hierarchical inheritance** and **interfaces** for business logic. The system should manage different types of books (such as academic, fiction, and non-fiction) and handle operations such as borrowing and returning books. An interface should be used for implementing the business logic to calculate fines for late returns.

#### **Requirements**:

1. **Book Class (Base Class)**:
    - **Attributes**:
        - `int bookId`: A unique identifier for each book.
        - `String title`: The title of the book.
        - `String author`: The author of the book.
        - `boolean isAvailable`: Whether the book is currently available for borrowing.
    - **Methods**:
        - Constructor to initialize book details.
        - `displayBookDetails()`: Method to display the book details.
        - Getter and setter methods for attributes like `isAvailable`.

2. **AcademicBook Class (Derived Class)**:
    - **Attributes**:
        - `String subject`: The subject to which the academic book belongs.
    - **Methods**:
        - Constructor to initialize academic book details.
        - Override `displayBookDetails()` to include subject information.

3. **FictionBook Class (Derived Class)**:
    - **Attributes**:
        - `String genre`: The genre of the fiction book (e.g., thriller, fantasy).
    - **Methods**:
        - Constructor to initialize fiction book details.
        - Override `displayBookDetails()` to include genre information.

4. **NonFictionBook Class (Derived Class)**:
    - **Attributes**:
        - `String topic`: The topic covered in the non-fiction book (e.g., history, biography).
    - **Methods**:
        - Constructor to initialize non-fiction book details.
        - Override `displayBookDetails()` to include topic information.

5. **Interface: FineCalculable**:
    - **Method**:
        - `double calculateFine(int daysLate)`: This method should be implemented by all book types to calculate the fine based on the number of days a book is returned late.
            - **Academic books**: Fine of ₹5 per day.
            - **Fiction books**: Fine of ₹3 per day.
            - **Non-fiction books**: Fine of ₹4 per day.

6. **Operations to be Performed**:
    - **Add a New Book**: Create objects of all subclasses (Academic, Fiction, or Non-fiction) and add them to the system.
    - **View All Books**: Implement a method `viewAllBooks()` to display the details of all the books, showing their type-specific information.
    - **Borrow a Book**: Implement a method `borrowBook(int bookId)` that allows a user to borrow a book if it is available. The method should update the `isAvailable` field of the book.
    - **Return a Book**: Implement a method `returnBook(int bookId, int daysLate)` to allow a user to return a borrowed book. If the book is returned late, the fine should be calculated using the `calculateFine()` method based on the type of book.

7. **Business Logic**:
    - **Fine Calculation on Late Returns**: Implement the `calculateFine(int daysLate)` method in each derived class (AcademicBook, FictionBook, and NonFictionBook) based on the rules mentioned above.

---