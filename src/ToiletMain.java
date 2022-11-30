/**
 * The shared toilet on company
 *
 * @author Frank Laércio
 * @author Ohanna Dezidério
 */
public class ToiletMain {

  /**
   * Number of producer and consumer threads
   */
  private static final int CAPACITY = 3;

  /**
   * Number of people who can use the toilet
   */
  private static final int NUM_PEOPLE_THREADS = 3;

  /**
   * Main method
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    ToiletBuffer buffer = new ToiletBuffer(CAPACITY);

    Producer[] producers = new Producer[NUM_PEOPLE_THREADS];
    Consumer[] consumers = new Consumer[NUM_PEOPLE_THREADS];

    for (int i = 0; i < NUM_PEOPLE_THREADS; i++) {
      producers[i] = new Producer("Producer " + (i + 1), buffer);
      consumers[i] = new Consumer("Consumer " + (i + 1), buffer);
    }

    for (int i = 0; i < NUM_PEOPLE_THREADS; i++) {
      producers[i].start();
      consumers[i].start();
    }

    try {
      for (int i = 0; i < NUM_PEOPLE_THREADS; i++) {
        producers[i].join();
        consumers[i].join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}