# Problem Statement

## 1. Title

Travel Entertainment Planning and Sharing Platform

## 2. Domain

Travel and Tourism

## 3. Who is the User?

### 1. Traveler / User
- Plans trips based on destination, budget, number of days, and mood.
- Views personalized day-wise itineraries.
- Checks estimated trip costs.

### 2. Admin
- Manages users, destinations, activities, and travel information.
- Maintains application data.

### 3. Travel Enthusiast
- Explores travel plans and activities.
- Uses shared travel information to plan future trips.

## 4. What Problem Are We Solving?

Planning a trip manually can be time-consuming because travelers need to search for destinations, activities, budgets, and daily schedules separately. Users may also find it difficult to create a travel plan that matches their budget, available days, and preferred mood.

For example, a traveler planning a 5-day trip with a limited budget may spend several hours searching for suitable places and activities. This application solves the problem by generating a personalized day-wise itinerary based on the user's destination, number of days, budget, and mood.

The application helps users save time and organize their travel plans in one platform.

## 5. Proposed Solution

The application will provide the following features:

- User registration and login.
- User authentication and role-based access.
- Destination selection.
- Number of days selection.
- Smart budget-based trip planning.
- Smart mood-based itinerary generation.
- Dynamic day-wise itinerary generation.
- Activity and place suggestions.
- Trip cost estimation.
- Trip cost summary.
- Travel plan management.
- Admin management of users and travel information.

### Unique Features

#### Smart Budget-Based Trip Planner

Creates a travel plan according to the user's available budget and helps manage estimated expenses.

#### Smart Mood-Based Itinerary

Generates itinerary suggestions based on the user's preferred mood such as:

- Adventure
- Relaxation
- Nature
- Culture
- Entertainment

#### Trip Cost Summary

Provides an estimated summary of travel expenses so that users can understand their expected trip cost.

## 6. Core Entities / Database Tables

1. User
2. Destination
3. Trip
4. Itinerary
5. Activity
6. Budget
7. Mood
8. TripCost

## 7. User Roles & Permissions

### Admin

- Login to the admin section.
- Manage users.
- Add, update, and delete destinations.
- Manage activities and travel information.
- Manage trip-related data.

### User / Traveler

- Register and login.
- Create a trip.
- Select a destination.
- Select the number of days.
- Set a travel budget.
- Select a preferred mood.
- Generate a personalized itinerary.
- View day-wise travel plans.
- View estimated trip cost summary.

## 8. Success Criteria

- Users can register and login successfully.
- Users can create a trip using destination, number of days, budget, and mood.
- The system generates the correct number of itinerary days.
- The system provides a budget-based travel plan.
- The system generates itinerary suggestions based on the selected mood.
- Users can view their day-wise itinerary.
- Users can view an estimated trip cost summary.
- Admin can manage users and travel-related information.
- Users can complete their basic trip planning through a single application.

## 9. Out of Scope

The following features are not included in the current version:

- Real-time flight ticket booking.
- Real-time hotel booking.
- Online payment gateway integration.
- Live GPS tracking.
- Real-time weather forecasting.
- Real-time flight and train status.
- Integration with external travel booking platforms.
- AI chatbot integration.
- Actual ticket or hotel reservation processing.

These features may be considered as future enhancements.

## 10. Chosen Track

Java (Spring Boot)

### Technology Stack

- Programming Language: Java
- Backend Framework: Spring Boot
- Database: MySQL
- ORM: Hibernate / JPA
- Frontend: HTML, CSS
- Build Tool: Maven
- IDE: Visual Studio Code
- Version Control: Git & GitHub

## Project Objective

The main objective of this project is to develop a centralized travel planning platform that helps users create personalized trips based on their destination, number of days, budget, and mood.

The application aims to make travel planning simple, personalized, and budget-friendly by providing a day-wise itinerary and estimated trip cost in one platform.