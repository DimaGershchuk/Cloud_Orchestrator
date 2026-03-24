📦 CycleNest – RESTful Rental Orchestrator Service

CycleNest is a service-oriented RESTful application designed to promote a sustainable lifestyle by enabling users to rent out their unused items. Inspired by platforms like Fat Llama and Media Dog Hire, the system allows users to search for items, request rentals, and manage requests through a centralized Orchestrator service.

The Orchestrator is implemented in Java and exposes RESTful endpoints for item discovery, filtering (e.g., by price or location), rental request creation, and request cancellation. All communication is handled using JSON, with proper serialization and deserialization of custom data models.

The system integrates a cloud-based NoSQL database (e.g., MongoDB) for storing items, users, and rental requests. Additionally, it consumes an external API (OSRM) to calculate proximity between users and item locations, enhancing search capabilities.

To ensure scalability and performance, the system is tested under high load conditions using JMeter, and improvements are implemented based on Quality of Service (QoS) analysis. The project may also include advanced features such as containerisation (Docker), cloud deployment, or security enhancements.

🚀 Key Features
RESTful API built with Java (Tomcat)
Item search with filtering (price, location, etc.)
Rental request creation and cancellation
JSON-based communication
Cloud-based NoSQL database integration
External API integration (OSRM for distance calculation)
QoS testing and performance optimisation
🛠️ Technologies Used
Java (RESTful Web Services)
Apache Tomcat
MongoDB / Azure Cosmos DB
JSON (Serialization/Deserialization)
OSRM API
JMeter (Performance Testing)
(Optional) Docker / Cloud Deployment
📌 Note

This project focuses on service orchestration and system design. It does not implement a full booking/payment system.
