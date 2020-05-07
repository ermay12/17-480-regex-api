/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.ermay12.regex;

import com.google.common.collect.Streams;
import org.junit.Test;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class RegexTest {
  @Test
  public void testStringBasedRegex() {
    Regex regex = Regex.fromRawRegex("([A-Z])\\w+");
    String input = "this Is the Example input String";

    Stream<RegexMatch> matches = regex.getMatches(input);

    assertTrue(regex.doesMatch(input));

    Streams.forEachPair(matches, Stream.of("Is", "Example", "String"),
        (RegexMatch match, String expectedString) -> {
          assertEquals(expectedString, match.toString());
        }
    );

    RegexMatch match1 = regex.getMatch(input, 1).get();
    assertEquals("Example", match1.toString());

    RegexMatch firstMatch = regex.firstMatch(input).get();
    assertEquals("Is", firstMatch.toString());


    ReplacementRegex replacement = new ReplacementRegex("$1word");

    String newString = regex.replace(input, replacement);

    assertEquals("this Iword the Eword input Sword", newString);

    newString = regex.replace(input, (RegexMatch match) -> {
      if (match.toString().equals("Is")) {
        return "is";
      }
      return match.getGroup(1) + "word";
    });
    assertEquals("this is the Eword input Sword", newString);
  }
}
