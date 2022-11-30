import java.util.LinkedList;
import java.util.Queue;

/**
 * The shared toilet on company
 *
 * @author Frank Laércio
 * @author Ohanna Dezidério
 */
public class ToiletBuffer {

  /**
   * Capacity of toilet
   */
  private final int capacity;

  /**
   * Shared toilet
   */
  private final Queue<Gender> buffer;


  /**
   * ToiletBuffer constructor
   *
   * @param capacity Capacity of toilet
   */
  public ToiletBuffer(int capacity) {
    this.capacity = capacity;
    buffer = new LinkedList<>();
  }

  /**
   * Method to use the toilet. If the capacity is completely engaged, it is not possible to use the
   * toilet. If you have someone of another gender, you cannot use the toilet.
   *
   * @param gender Gender to use the toilet
   */
  public synchronized void use(Gender gender) {
    while (buffer.size() == capacity || (!buffer.isEmpty() && !buffer.contains(gender))) {
      System.out.print("Toilet engaged. ");
      System.out.println(Thread.currentThread().getName() + " " + gender + " is waiting.");
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    buffer.add(gender);
    System.out.println(Thread.currentThread().getName() + " " + gender + " in toilet.");
    notifyAll();
  }

  /**
   * Method to be used when leaving the toilet
   */
  public synchronized void exit() {
    while (buffer.size() == 0) {
      System.out.print("Toilet is vacant. ");
      System.out.print(Thread.currentThread().getName() + " suspended.\n");
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    Gender gender = buffer.remove();
    System.out.println(Thread.currentThread().getName() + " removed " + gender);
    notifyAll();
  }
}