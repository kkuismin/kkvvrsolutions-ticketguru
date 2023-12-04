# TicketGuru Test Documentation

## 1. Introduction
This is an overview of the tests made for ticketguru's ticket selling platform.

## 2. Test Environment
- **Technologies and Tools**: Spring Boot, JUnit
- **Configuration**:
  - Spring Boot version: (3.0.1)
  - Database configuration:
```spring.datasource.url=jdbc:mysql://localhost:3306/ticketgurudb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC```
  - MockMvc for secure API testing 
    
## 3. Test Types
### Unit Tests
- JUnit tests for individual methods and class functionalities.
- Example: Testing CRUD operations for Event, TicketType and Venue class.
### Integration Tests
- API tests for the co-operation between the database and the subsystem.
- Example: Testing API status, application response type and authorization.

### End-to-End Tests (E2E)
- Testing the complete user journey.
- Example: Buy New Ticket test case using Robot Framework.

![image](https://github.com/kkuismin/kkvvrsolutions-ticketguru/assets/131862365/08a366af-3683-45b9-87d3-42eccd45d3e6)

  
## 4. Test Case Details
- **Test Case: Buy New Ticket Succesfully Path**
  - **Steps**: 
    1. User selects an event.
    2. User chooses a ticket type: student.
    3. User clicks on a "Buy" button.
    4. System should contain "Purchase successful".
  - **Expected Result**: Ticket is successfully purchased and appears on the page.

## 5. Test Code Example (Authorization)
```
   @Test
	    public void testTicketUnauthorized() throws Exception {
	        mockMvc.perform(get("/api/tickets/1"))
	                .andExpect(status().isUnauthorized());
	    }
```

## 6. Test Results and Analysis
- **Results**: The test shows that without authorization one cannot get a ticket from Ticket API.
- **Analysis**: If tests pass it means that Ticket API is working properly.
  
## 7. Conclusions
- **Conclusions**: The created test cases success in testing the core functionalities of the TicketGuru system, for example authorization and ticket purchase.
  
