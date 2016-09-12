package interviewprep;

// HARD: Implement a queue using 2 stacks
public class StackQueue {
  // Queue is first in first out
  // Stack is last in first out
  
  // Input: 1, 2, 3, 4
  // 2 stacks is [4, 3, 2, 1]
  // queue is  [1, 2, 3, 4]
  
  /*
   * Keep 2 stacks, let's call them inbox and outbox.

Queue:
- Push the new element onto inbox

Dequeue:
- If outbox is empty, refill it by popping each element from inbox and pushing it onto outbox
- Pop and return the top element from outbox

Using this method, each element will be in each stack exactly once - meaning each element will be pushed twice and popped twice, giving amortized constant time operations.

   */
}
