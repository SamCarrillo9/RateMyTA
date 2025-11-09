# RateMyTA Project AI Instructions

## Project Overview
RateMyTA is a 24-hour hackathon project that provides a platform for University at Buffalo CS students to rate and review their Teaching Assistants. The project is inspired by RateMyProfessor.com but focused specifically on UB CS TAs.

## Core Features
- View and search UB CS TAs
- Display TA ratings and reviews
- Submit new ratings and reviews
- Simple course association for TAs

## Tech Stack & Architecture
- Frontend: Basic HTML + CSS for quick implementation
- Backend: Spring Boot (Java 21) for REST API endpoints
- Database: MongoDB Atlas (chosen for simplicity and no-SQL setup)
- Main entry point: `src/main/java/com/example/ratemyta/RatemytaApplication.java`

## Data Models
Expected core entities:
- TA: name, courses, average rating
- Review: rating score, comments, timestamp
- Course: course code, course name

## Quick Start Development
1. Ensure Java 21 JDK is installed
2. Run the application:
   ```bash
   ./gradlew bootRun
   ```
3. Access the web interface at `http://localhost:8080`

## Database Setup (Simplified for Hackathon)
- Using MongoDB Atlas free tier
- Connection string already configured in `application.properties`
- No complex schemas or relationships to maintain
- Keep queries simple and focused on basic CRUD operations

## Project Structure Conventions
- Frontend: Place HTML/CSS in `src/main/resources/static/`
- Controllers: `src/main/java/com/example/ratemyta/controllers/`
- Models: `src/main/java/com/example/ratemyta/models/`
- Services: `src/main/java/com/example/ratemyta/services/`

## Security Note
⚠️ Current `application.properties` contains database credentials that should be moved to environment variables for production use.

## Development Priorities (Hackathon Context)
1. Focus on core features first (viewing/adding ratings)
2. Keep the UI simple but functional
3. Minimize complex database queries
4. Skip authentication for MVP (can be added if time permits)
5. Aim for working demo over perfect code