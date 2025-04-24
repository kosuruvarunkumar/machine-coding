Requirements
- The queue should be in-memory and should not require access to the file system.
- There can be multiple topics in the queue.
- A (string) message can be published on a topic by a producer/publisher and consumers/subscribers can subscribe to the topic to receive the messages.
- There can be multiple producers and consumers.
- A producer can publish to multiple topics.
- A consumer can listen to multiple topics.
- The consumer should print "<consumer_id> received <message>" on receiving the message.
- The queue system should be multi-threaded, i.e., messages can be produced or consumed in parallel by different producers/consumers.