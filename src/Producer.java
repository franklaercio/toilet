/**
 * Producer tries to use the toilet
 *
 * @author Frank Laércio
 * @author Ohanna Dezidério
 */
public class Producer extends Thread {

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
    buffer.use(Gender.random());
  }
}
