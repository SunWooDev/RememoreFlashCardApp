# Personal Project: Rememore - a Leitner System Software


## *Liether System is a studying technique that helps students learn and memorize better.*


#### **What will the application do?**

Rememore is a portmanteau of "remember" and "more".
Rememore is a software implementation of the Leitner System.
Leitner System is a studying technique using flash cards and boxes.
There are 5 boxes that stores flash cards labeled from 1 to 5 and each has an associated timer with increasing interval that indicates when the user should study the flash cards in the box again.

For example, box 1 has timer of 30 minutes, box 2 has timer of 1 day, box 3 has timer of 3 days, box 4 has timer of 7 days, and box 5 has timer of 14 days. User tests him/herself with the flash cards from the box 1 every 30 minutes, from the box 2 every day, from the box 3 every 3 days, and so on.

When a user starts using the program, the user makes flash cards with questions on the front and answers on the back.
The program initially stores the card in the first box (box 1).
When the user tests him/herself with the flash cards from the box 1 and get the answer correct, the card moves to the next box, box 2.
If the user get the answer incorrect, the card moves back one box. However, in this case the card remains in box 1 as there is no box to move back from.
By testing cards that the user gets correct less and less frequently, the user can focus on studying cards that user frequently gets incorrect.
Hence, this is an efficient studying technique that can shorten student's time to learn on a new material.



#### **Who will use it?**
- Students (Kindergarten to graduate's degree) of any subject or major*
- Independent learners of any subject or major*

**Usually, the Leitner System studying technique is best for memorization heavy subjects such as biology.*



#### **Why is this project of interest to you?**

I am an avid learner strive to learn better and faster about computer science.
Moreover, by using an efficient learning technique, I can also achieve better work life balance by learning the same amount of material faster and using the extra time to spend time for hobbies or family.

#### **User Stories**
- As a user, I want to be able to add a new flash card to a box
- As a user, I want to be able to remove and modify an existing flash card
- As a user, I want to be able to move an existing flash card to different box
- As a user, I want to be able to modify box timer for user's liking and customization
- As a user, I want to be able to test cards in a box when current time is exactly or exceeds due time.*
- As a user, I want to be able to save cards and not have to enter the cards again when using the program the next time.
- As a user, I want to be able to load cards automatically from the start of application.

**Due timer is calculated by start time + card box timer. Start time is set to the time when the card is first created and when the card is moved to previous or next box*

#### **Phase 4: Task 2**
##### Indicate which of the options above you have chosen to implement. 
Test and design a class in your model package that is robust. 
You must have at least one method that throws a checked exception.  
You must have one test for the case where the exception is expected and another where the exception is not expected.

##### Please include the classes and methods in that play a role in this task
findCardInCardBox() throws NoCardFoundException

NoCardFoundException is caught in 
removeCard() 
modifyCard()
moveCardToDifferentBox()

#### **Phase 4: Task 3**
#### Reflect on the design presented in your UML class diagram. 
#### If you had more time to work on the project, is there any refactoring that you would do to improve your design?
- Consistency Principle: In the UML diagram, JsonWriter depends on CardBoxManager and JsonReader is associated with CardBoxManager. This design is inconsistent because JsonReader has CardBoxManager as its field while JsonWriter does not. To fix this, JsonWriter should be associated with CardBoxManager.
- Flexibility Principle: In the UML diagram, 5 CardBox objects are hardcoded (instantiated) in the CardBoxManager constructor. However, this causes inflexibility to add more card boxes to the Rememore program because, to add more card boxes in, I have to add another line of instantiation of CardBox class in the CardBoxManager constructor. To fix this, 
- Law of Demeter and Iterator design pattern: In the UML diagram, the lack of an iterator pattern implies the loops in CardBoxManager and CardBox use loops that expose the underlying details of the loop. For example, the findCardsToTest() method uses for each loop “for (Card cardInTableOfCards : tableOfCards)” that reveals that tableOfCards is an ArrayList with Card objects in them. Instead, I should use an iterator pattern to hide internal representation of the data structure that the loop is traversing. For example, using the iterator pattern, findCardsToTest() method can employ “while (iterator.hasNext())” to hide the fact that Card element is being iterated in ArrayList tableOfCards.
- Singleton Pattern: In the UML diagram, there is a lack of information about how many CardBoxManager is instantiated. However, CardBoxManager is meant to be instantiated only once. Accidently, I can instantiate the CardBoxManager multiple times. To ensure that it is instantiated once, I should employ a singleton pattern by making CardBoxManager constructor private and have a public getInstance() method for global access to a sole CardBoxManager object.
- Open/Closed Principle: In the UML diagram, CardBox is associated with Card. In other words, CardBox has 0 to multiple cards. However, Card class can only support flash cards with only text. If I wanted a flash card that can support images, for example, I have to create an ImageCard class that is on the same level of abstraction as Card class. However, CardBox is unable to add, remove, modify the ImageCard class as it can only do Card class objects. Therefore, I should employ open/closed principle and add the Card interface that TextCard (card that only supports text)  and ImageCard (card that can support images) implements. This way, CardBox can add, remove, modify different types of Card implementation.




#### **Grading Scheme**
- 20 pts - (code coverage score * 20) - so 100% code coverage yields a score of 20, whereas 0% code coverage yields a score of 0
- 10 pts - clear and correct documentation has been provided 
- 70 pts - realization of four user stories relevant to the proposed application (roughly equally weighted);
to obtain any of these marks at least one of the user stories that has been realized must be of the form "add multiple Xs to a Y" as described above.  
