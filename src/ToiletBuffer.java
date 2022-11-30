import java.time.Instant;
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
  private final Queue<Person> buffer;

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
   * @param person Gender to use the toilet
   */
  public synchronized void use(Person person) {
    while (buffer.size() == capacity || (
        !buffer.isEmpty() && buffer.stream().noneMatch(p -> p.getGender() == person.getGender()))) {
      System.out.print("Toilet engaged. ");
      System.out.print("There is " + buffer.size() + " in toilet. ");
      System.out.println(
          Thread.currentThread().getName() + " " + person.getGender() + " is waiting.");
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    buffer.add(person);
    System.out.println(Thread.currentThread().getName() + " " + person.getGender() + " in toilet.");
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

    while (true) {
      Person person = buffer.peek();
      if (person != null && person.getToiletTime().isBefore(Instant.now())) {
        buffer.remove(person);
        System.out.println(Thread.currentThread().getName() + " removed " + person.getGender());
        notifyAll();
        break;
      }
    }
  }
}