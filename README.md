# 📚 Java Multithreaded Chat Application

## 📋 Project Description
This is a **Client-Server Chat Application** built using **Java Sockets** and **Multithreading**.  
It allows **multiple clients** to connect to a **central server** and **communicate** with each other **in real time**.

✅ Supports multiple clients  
✅ Each client has a **unique username**  
✅ **Real-time message broadcasting**  
✅ **Efficient and optimized** multithreaded code  
✅ Proper **connection and disconnection** handling

## 🏗️ Project Structure
```
ChatApplication/
├── Server.java         (Server main class)
├── ClientHandler.java   (Handles each client thread)
├── Client.java          (Client main class)
├── ReadTask.java        (Reads incoming messages at client side)
├── WriteTask.java       (Sends messages from client to server)
```

## 🔥 Features
- 🌐 **Multi-client support**: Many users can chat at the same time.
- 🧑 **Username assignment**: Each user is identified by a name.
- 📢 **Broadcast messaging**: Messages are sent to all connected users.
- 🔗 **Stable connections**: Proper resource management (sockets, streams).
- ⚡ **Optimized multithreading**: Smooth and efficient communication.
- 🚪 **User disconnection alerts**: Notifies when a user leaves.

## 🛠️ Technologies Used
- Java SE (Standard Edition)
- Java Sockets (`java.net`)
- Java Multithreading (`java.lang.Thread`)
- Java IO Streams (`java.io`)

## 🚀 How to Run

### 1. Compile all `.java` files:
```bash
javac *.java
```

### 2. Start the Server:
```bash
java Server
```
You will see:
```
Chat server started...
```

### 3. Start multiple Clients (open several terminals):
```bash
java Client
```
- Each client will be asked:
  ```
  Enter your username:
  ```
- Then start chatting!

## 📸 Sample Flow

**Terminal 1 (Server):**
```
Chat server started...
New client connected
User joined: Alice
User joined: Bob
```

**Terminal 2 (Client 1):**
```
Enter your username:
Alice
[Bob]: Hi Alice!
[Alice]: Hello Bob!
```

**Terminal 3 (Client 2):**
```
Enter your username:
Bob
[Alice]: Hello Bob!
[Bob]: Hi Alice!
```

## ⚡ Future Enhancements (Optional Ideas)
- 🖥️ Add a simple GUI (Java Swing)
- 🔒 Implement end-to-end encryption
- 📬 Support private messaging (`/msg username message`)
- 🌍 Deploy the server on a remote cloud server

