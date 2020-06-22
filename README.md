**Application Goals**
1) Use different Spring technologies - Spring Data JPA, Spring Security with JWT Authentication, Starter Mail, Lombok,
Web, Thymeleaf
2) Implement MySQL as the database and connect it to the backend
3) Use Angular 9 as the frontend framework and Bootstrap as the CSS framework
4) Grow a stronger understanding of developing full-stack applications

**Project Structure/Setup**
Models (Domains - all .java files) - Comment, NotificationEmail, Post, Subreddit, User, VerificationToken, Vote, 
VoteType (ENUM)
Repositories (repos are always interfaces) - Each model needs a corresponding repo besides NotificationEmail

## Spring Security 
- create SecurityConfig file that enables web security, configure Spring to allow requests and contains
a password encoder

**Implement API to Register Users**
- The API requires a controller class, request body class (DTO - Data Transfer Object), and a service class that will 
register the user and save the user to the UserRepository

**User Verification & Sending Verification Email to Users**
- Service class will contain a method that will generate a verification token to verify a user's account
- Thymeleaf dependency will need to be added to pom.xml file, so the template engine will be available to send the emails
- MailContentBuilder class will build email messages that users will receive, and the message will be injected into the
HTML by utilizing the Context object of the TemplateEngine

## “http://localhost:8080/api/auth/accountVerification” - Activation URL
- Send emails using MailTrap.io (fake SMTP server) & mail will be sent by utilizing methods created in the MailService
class
- Create a custom exception class in order to provide custom error messages to the users
- Send a notification email to user when the user signs up for an account
- Create an endpoint that will allow us to test user registration and verification functionalities

### Testing User Signup
Use "http://localhost:8080/api/auth/signup" url in Postman to test user signup.  Create raw JSON object with all the user 
info and determine if the activation email sent.  Check the activation url provided in the email and determine if it 
redirects user to "Account Activated Successfully" page.  
_Test the user signup response time with and without sending emails asynchronously._

#### JSON object example:
{
    "username":"TestUser3",
    "email":"test3@programmingtechie.com",
    "password":"password3"
}
