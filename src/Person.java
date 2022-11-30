import java.time.Instant;

/**
 * Person in the company context.
 *
 * @author Frank Laércio
 * @author Ohanna Dezidério
 */
public class Person {

  private final Gender gender;

  private final Instant toiletTime;

  public Person(Gender gender, Instant toiletTime) {
    this.gender = gender;
    this.toiletTime = toiletTime;
  }

  public Gender getGender() {
    return gender;
  }

  public Instant getToiletTime() {
    return toiletTime;
  }

  @Override
  public String toString() {
    return "Person{" +
        "gender=" + gender +
        '}';
  }
}
