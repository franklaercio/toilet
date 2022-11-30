import java.util.Random;

/**
 * Gender in the company context.
 *
 * @author Frank Laércio
 * @author Ohanna Dezidério
 */
public enum Gender {
  MALE, FEMALE;

  /**
   * Function to random a value in Java.
   */
  private static final Random PRNG = new Random();

  /**
   * Method to random a gender in the use to the toilet.
   *
   * @return a random Gender
   */
  public static Gender random() {
    Gender[] genders = values();
    return genders[PRNG.nextInt(genders.length)];
  }
}
