import java.time.Instant;
import java.util.Random;

/**
 * Producer tries to use the toilet
 *
 * @author Frank Laércio
 * @author Ohanna Dezidério
 */
public class Producer extends Thread {

  /**
   * Function to random a value in Java.
   */
  private static final Random random = new Random();
  
  /**
   * Shared toilet in the company.
   */
  private final ToiletBuffer buffer;

  /**
   * Producer constructor
   *
   * @param name   Name to be assigned to the thread
   * @param buffer Reference to the toilet
   */
  public Producer(String name, ToiletBuffer buffer) {
    super(name);
    this.buffer = buffer;
  }

  /**
   * A person tries to use the toilet
   */
  @Override
  public void run() {
    buffer.use(new Person(Gender.random(), Instant.now().plusSeconds(random.nextInt(10))));
  }
}
