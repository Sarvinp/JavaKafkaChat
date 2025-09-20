# 🚀 Kafka Java Producer-Consumer Project

A simple yet powerful Java-based Kafka implementation demonstrating real-time message streaming between producer and consumer applications. Perfect for learning Apache Kafka fundamentals without Docker complexity.

## 📋 Project Overview

This project implements a basic chat messaging system using Apache Kafka, showcasing the core producer-consumer pattern. It's designed specifically for Windows environments without requiring Docker or WSL.

## 🎯 Learning Objectives

- ✅ Understand Kafka architecture and components
- ✅ Implement Kafka producers and consumers in Java
- ✅ Learn message serialization/deserialization
- ✅ Manage Kafka topics and partitions
- ✅ Set up Kafka without Docker on Windows
- ✅ Work with Kafka client libraries

## 🛠️ Tech Stack

- **Java 8** - Core programming language
- **Apache Kafka 3.6.1** - Distributed streaming platform
- **Maven** - Dependency management and build tool
- **Windows Native** - No Docker/WSL required

## 📁 Project Structure
```text
JavaKafkaProject/
├── Producer/                 # Message sender application
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── sarv/
│   │                   └── kafka/
│   │                       └── ChatProducer.java
│   └── pom.xml
├── Consumer/                 # Message receiver application  
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── sarv/
│   │                   └── kafka/
│   │                       └── ChatConsumer.java
│   └── pom.xml
├── docker-compose.yml        # Docker Compose for Kafka setup
├── pom.xml                   # Main parent POM
└── README.md
```
## ⚡ Quick Start

### Prerequisites
- Java JDK 8 or higher
- Apache Kafka 3.6.1+ downloaded
- Maven installed

### 1. Download and Setup Kafka
```bash
# Download Kafka from https://kafka.apache.org/downloads
# Extract to C:\kafka
```
### 2. Start Kafka Services
```bash
# Terminal 1 - Start Zookeeper
cd C:\kafka\kafka_2.13-3.6.1
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
# Terminal 2 - Start Kafka Server  
cd C:\kafka\kafka_2.13-3.6.1
.\bin\windows\kafka-server-start.bat .\config\server.properties
# Terminal 3 - Create Topic
cd C:\kafka\kafka_2.13-3.6.1
.\bin\windows\kafka-topics.bat --create --topic chat-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```
### 3. Build and Run Applications

# Build both projects
```bash
cd Producer
mvn clean compile

cd ../Consumer  
mvn clean compile

# Terminal 4 - Run Consumer (run first)
cd Consumer
java -cp "target/classes;C:\kafka\kafka_2.13-3.6.1\libs\*" com.sarv.kafka.ChatConsumer

# Terminal 5 - Run Producer 
cd Producer
java -cp "target/classes;C:\kafka\kafka_2.13-3.6.1\libs\*" com.sarv.kafka.ChatProducer
```
##📖 Code Overview
### Producer (ChatProducer.java)
```java
// Sends messages to Kafka topic
Properties props = new Properties();
props.put("bootstrap.servers", "localhost:9092");
props.put("key.serializer", "StringSerializer");
props.put("value.serializer", "StringSerializer");

Producer<String, String> producer = new KafkaProducer<>(props);
producer.send(new ProducerRecord<>("chat-topic", "user1", "Hello from Sarv!"));
```

### Consumer (ChatConsumer.java)
```java
// Receives messages from Kafka topic
Properties props = new Properties();
props.put("bootstrap.servers", "localhost:9092");
props.put("group.id", "chat-group");
props.put("key.deserializer", "StringDeserializer");
props.put("value.deserializer", "StringDeserializer");

KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
consumer.subscribe(Collections.singletonList("chat-topic"));
```
## 🔧 Configuration
### Kafka Properties
Bootstrap Server: localhost:9092

Topic: chat-topic

Partitions: 1

Replication Factor: 1

Consumer Group: chat-group

## Maven Dependencies

``xml
<dependency>
    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka-clients</artifactId>
    <version>3.6.1</version>
</dependency>
``
##🐛 Troubleshooting
Common Issues
Zookeeper/Kafka not running: Ensure both services are started

Topic not created: Create topic manually using kafka-topics.bat

Classpath issues: Verify Kafka libs path in java -cp command

Port conflicts: Check if port 9092 is available

Log4j Warnings
The log4j warnings are normal and don't affect functionality:

text
log4j:WARN No appenders could be found for logger...
This is expected behavior and doesn't impact message processing.

## 🚀 Next Steps
Add multiple consumers to demonstrate consumer groups

Implement different serialization formats (JSON, Avro)

Add error handling and retry mechanisms

Implement message filtering and processing

Add Docker support for cross-platform compatibility

## 📚 Learning Resources
Apache Kafka Documentation

Kafka Java Client API

Confluent Kafka Tutorials

##🤝 Contributing
This is a learning project. Feel free to:

Fork the repository

Submit issues and suggestions

Create pull requests with improvements

Share your learning experience

##📄 License
This project is open source and available under the MIT License.

Happy Learning! 🎉 Build something amazing with Kafka!

text

This README provides:
- Clear project overview and learning objectives
- Step-by-step setup instructions
- Code examples and explanations
- Troubleshooting guide
- Professional structure and formatting
- Learning resources and next steps

It's comprehensive yet beginner-friendly, perfect for showcasing your Kafka learning project!

