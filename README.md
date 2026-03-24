📦 CycleNest – RESTful Rental Orchestrator Service

CycleNest is a service-oriented RESTful application designed to promote a sustainable lifestyle by enabling users to rent out their unused items.

Inspired by platforms like Fat Llama and Media Dog Hire, the system allows users to:

search for available items
request rentals
manage rental requests

All interactions are handled through a centralized Orchestrator service.

🧩 Overview

The Orchestrator is implemented in Java and exposes RESTful endpoints for:

🔍 Item discovery and filtering (e.g., by price or location)
📩 Rental request creation (status: pending)
❌ Request cancellation (status: cancelled)

Communication is handled using JSON, with proper serialization and deserialization of custom data models.

☁️ Data & External Integration
Uses a cloud-based NoSQL database (Azure Cosmos DB)
Stores:
Items
Users
Rental requests
Integrates with OSRM API to:
calculate distance between user and item
enhance location-based search
⚙️ Performance & Scalability

The system is tested under high-load conditions using JMeter to simulate:

concurrent users
large data payloads

Based on the results, performance improvements are implemented using QoS (Quality of Service) analysis.

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
Azure Cosmos DB
JSON (Serialization / Deserialization)
OSRM API
JMeter (Performance Testing)
(Optional) Docker / Cloud Deployment
📌 Important Note

This project focuses on service orchestration and system design.
It does not implement a full booking or payment system.
