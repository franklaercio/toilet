/**
 * Consumer use to exit the toilet
 *
 * @author Frank Laércio
 * @author Ohanna Dezidério
 */
public class Consumer extends Thread {

  /**
   * Shared toilet in the company
   */
  private final ToiletBuffer buffer;

  /**
   * Consumer constructor
   *
   * @param name   Name of consumer instance
   * @param buffer Shared toilet in the company
   */
  public Consumer(String name, ToiletBuffer buffer) {
    super(name);
    this.buffer = buffer;
  }

  /**
   * Method to exit the toilet.
   */
  @Override
  public void run() {
    buffer.exit();
  }
}
