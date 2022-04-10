# voteBackend
## Overview of the Basic framework
The first layer, is MVC model, which maps endpoint (like a url) to function and convert object from service to HttpResponse

The second layer is the service layer, which does the core management logic.
It finds and filters data according to the frontend's request.
It also help to record opinionPoll's info and manage the feedback to the specific policy.

The third layer is to interact with NoSQL database.

The Fourth is the elasticsearch and Redis, where we store data
![voteBackend](https://user-images.githubusercontent.com/101444408/162607751-737bd454-8683-4dfd-af51-e764a703f098.jpg)
## Business Logic
### MP/Party/Event/opinionPoll Management Service
![searchManagement drawio](https://user-images.githubusercontent.com/101444408/162609965-81670a95-62f3-4470-98e3-d0b318234d89.png)
### Policy Track
### Feedback to Policy
![FeedbackSystem drawio](https://user-images.githubusercontent.com/101444408/162609985-48d7becd-321a-40ff-b46f-18bca1b37d5c.png)
