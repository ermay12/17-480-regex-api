/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.ermay12.regex;

import java.util.regex.Pattern;

/**
 * This class represents a compiled Regular expression. Instances of this class are immutable and
 * safe to be used by multiple concurrent threads.
 *
 * <h3>Summary of Regular Expression Constructs</h3>
 *
 * <table style="border: 0; border-collapse: collapse; border-spacing: 0;">
 * <caption>Regular Expression Constructs</caption>
 * <tbody>
 *  <tr style="text-align: left">
 *    <th style="padding: 1px; text-align: left; background-color: #CCCCFF" id="construct">Construct</th>
 *    <th style="padding: 1px; text-align: left; background-color: #CCCCFF" id="matches">Matches</th>
 *  </tr>
 *
 *  <tr><th>&nbsp;</th></tr>
 *
 *  <tr style="text-align: left"><th colspan="2" id="characters">Characters</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct characters"><i>single('x')</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">The character 'x'. Note that this will escape 'x' if necessary
 *                          (i.e. if it is a special regex character)</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct characters"><i>string("ab.")</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">The string 'ab.'. Note that this will escape any characters if necessary
 *                          (i.e. if it is a special regex character, such as the '.' in this example)</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct characters"><i>fromRawRegex("ab.")</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">The regex 'ab.'. Note that this will <b>NOT</b> escape any characters
 *                          (i.e. the '.' in this example)</td>
 *  </tr>
 *
 *  <tr><th>&nbsp;</th></tr>
 *
 *  <tr style="text-align: left"><th colspan="2" id="classes">Character Classes</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct classes"><i>single(CharacterClass)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">The same thing that the given character class matches. See {@link CharacterClass}</td>
 *  </tr>
 *
 *  <tr><th>&nbsp;</th></tr>
 *
 *  <tr style="text-align: left"><th colspan="2" id="predef">Predefined Character Classes</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct predef"><i>CharacterClass.WILDCARD</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">Any character. See {@link CharacterClass#WILDCARD}</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct predef"><i>CharacterClass.DIGIT</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">Any digit (0-9). See {@link CharacterClass#DIGIT}</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct predef"><i>CharacterClass.WORD_CHARACTER</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">Any word character (a-z, A-Z, 0-9 and _). See {@link CharacterClass#WORD_CHARACTER}</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct predef"><i>CharacterClass.WHITESPACE</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">Any whitespace character ( ,\t,\n,\x0B,\f\r). See {@link CharacterClass#WHITESPACE}</td>
 *  </tr>
 *
 *  <tr><th>&nbsp;</th></tr>
 *
 *  <tr style="text-align: left"><th colspan="2" id="bound">Boundaries</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct bound"><i>LINE_START</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">The start of a line. If multi-line mode is off, then this matches the start of input</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct bound"><i>LINE_END</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">The end of a line. If multi-line mode is off, then this matches the end of input</td>
 *  </tr>
 *
 *  <tr><th>&nbsp;</th></tr>
 *
 *  <tr style="text-align: left"><th colspan="2" id="quant">Quantifiers</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>optional(X)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, either once or not at all</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>anyAmount(X)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, zero or more times</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>atLeastOne(X)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, one or more times</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>repeatExactly(X, amount)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, repeated exactly amount times</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>repeatAtLeast(X, min)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, min or more times</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>repeatAtMost(X, max)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, repeated at most max times</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>repeat(X, min, max)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, repeated at least min and at most max times</td>
 *  </tr>
 *
 *  <tr style="text-align: left"><th colspan="2" id="quant">Alternative Evaluation type quantifiers</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>optional(X, T)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, either once or not at all, using the provided {@link EvaluationMethod} T</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>anyAmount(X, T)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, zero or more times, using the provided {@link EvaluationMethod} T</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>atLeastOne(X, T)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, one or more times, using the provided {@link EvaluationMethod} T</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>repeatExactly(X, amount, T)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, repeated exactly amount times, using the provided {@link EvaluationMethod} T</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>repeatAtLeast(X, min, T)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, min or more times, using the provided {@link EvaluationMethod} T</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>repeatAtMost(X, max, T)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, repeated at most max times, using the provided {@link EvaluationMethod} T</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct quant"><i>repeat(X, min, max, T)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X, repeated at least min and at most max times, using the provided {@link EvaluationMethod} T</td>
 *  </tr>
 *
 *  <tr><th>&nbsp;</th></tr>g
 *  <tr style="text-align: left"><th colspan="2" id="logical">Logical Operators</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct logical"><i>new Regex(X1, X2, ...)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X1 followed by X2 followed by ...</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct logical"><i>concatenate(X1, X2, ...)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">X1 followed by X2 followed by ...</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct logical"><i>oneOf(X1, X2, ...)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">either X1 or X2 or ...</td>
 *  </tr>
 *
 *  <tr><th>&nbsp;</th></tr>
 *  <tr style="text-align: left"><th colspan="2" id="back">Back References</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct back"><i>backReference(i)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">What the i'th capturing group matched</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct back"><i>backReference(group)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">What the capturing group passed in matched</td>
 *  </tr>
 *
 *  <tr><th>&nbsp;</th></tr>
 *  <tr style="text-align: left"><th colspan="2" id="lookaround">Lookaround</th></tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct capture"><i>lookahead(X)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">asserts that the rest of the string matches X, but does not consume any characters</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct capture"><i>negativeLookahead(X)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">asserts that the rest of the string does not match X, but does not consume any characters</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct capture"><i>lookbehind(X)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">asserts that the precending bit of the string matches X, but does not consume any characters</td>
 *  </tr>
 *  <tr>
 *    <td style="padding: 1px;" valign="top" headers="construct capture"><i>negativeLookbehind(X)</i></td>
 *    <td style="padding: 1px; padding-left: 5px;" headers="matches">asserts that the precending bit of the string does not match X, but does not consume any characters</td>
 *  </tr>
 *  </tbody>
 * </table>
 */
public class Regex extends RegexLiteral {

  /*
   ****************
   * Constructors *
   ****************
   */

  /**
   * Constructs a Regular Expression from the regular expression subcomponents.
   * Note that this method does not escape any characters
   *
   * @param components the sub-components of the regular expression
   */
  Regex(CharSequence... components) {
    super(components);
  }


  /**
   * Constructs a Regular Expression from the regular expression subcomponents.
   * Takes group indexing regex from a base regex.
   * Note that this method does not escape any characters
   *
   * @param base       the regex to copy group indexing info from
   * @param components the sub-components of the regular expression
   */
  Regex(RegexLiteral base, CharSequence... components) {
    super(base, components);
  }

  /**
   * Constructs a regular expression from the given sub-components. The
   * new Regex constructed will be the concatenation of all of the subcomponents.
   * <p>
   * In other words, if the subcomponents match "a", "b" and "c", then the new regular
   * expression will match "abc"
   *
   * @param components the sub-components of the regular expression
   */
  Regex(RegexLiteral... components) {
    super(components);
  }


  /*
   **************
   * Characters *
   **************
   */

  /**
   * Returns a regex that matches a single character
   *
   * @param c the character class
   * @return a regex that matches a single character
   */
  public static Regex single(char c) {
    return new Regex(sanitized(c));
  }

  /**
   * Returns a regex that matches a given CharSequence exactly. The given CharSequence has any special regex characters
   * escaped automatically.
   *
   * @param s the CharSequence to match against
   * @return a regex that matches the given CharSequence
   */
  public static Regex string(CharSequence s) {
    return new Regex(sanitized(s));
  }

  /**
   * Constructs a regular expression from the given raw regular expression. This Regular expression
   * should conform to the Java Regex language. See {@link Pattern}
   *
   * @param regex the sub-components of the regular expression
   * @return a new regular expression matching the given regex
   */
  public static Regex fromRawRegex(CharSequence regex) {
    return new Regex(regex);
  }
  /*
   *********************
   * Character Classes *
   *********************
   */

  /**
   * Returns a regex that matches a single character within a given character class
   *
   * @param c the character class
   * @return a regex that matches a single character within a given character class
   */
  public static Regex single(CharacterClass c) {
    return new Regex(new RegexLiteral[]{c});
  }


  /*
   **************
   * Boundaries *
   **************
   */

  /**
   * The start of a line. If multi-line mode is off, then this matches the start of input
   */
  public static final Regex LINE_START = new Regex("^");
  /**
   * Any boundary to a word character
   */
  public static final Regex WORD_BOUNDARY = new Regex("\\b");
  /**
   * Any non boundary to a word character
   */
  public static final Regex NOT_WORD_BOUNDARY = new Regex("\\B");

  /**
   * The end of a line. If multi-line mode is off, then this matches the end of input
   */
  public static final Regex LINE_END = new Regex("$");

  /*
   ***************
   * Quantifiers *
   ***************
   */

  /**
   * Returns a regex which matches any string that consists of the given string either once or not at all
   *
   * @param s the CharSequence to compose on
   * @return a regex which matches any string that consists of the given string repeated at most once
   */
  public static Regex optional(CharSequence s) {
    return optional(s, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated either once or not at all
   *
   * @param r the regex to compose on
   * @return a regex which matches any string that consists of any string the given regex matches repeated either once or not at all
   */
  public static Regex optional(RegexLiteral r) {
    return optional(r, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of the given string either once or not at all
   * This uses the provide Evaluation method
   *
   * @param s the CharSequence to compose on
   * @param t the evaluation type
   * @return a regex which matches any string that consists of the given string repeated at most once
   */
  public static Regex optional(CharSequence s, EvaluationMethod t) {
    if (s.length() == 1) {
      return new Regex(sanitized(s.charAt(0)), "?", t.toRegex());
    } else {
      return new Regex("(?:", sanitized(s), ")?", t.toRegex());
    }
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated either once or not at all.
   * This uses the provide Evaluation method
   *
   * @param r the regex to compose on
   * @param t the evaluation type
   * @return a regex which matches any string that consists of any string the given regex matches repeated either once or not at all
   */
  public static Regex optional(RegexLiteral r, EvaluationMethod t) {
    return new Regex(r, r.selfAsGrouped(), "?", t.toRegex());
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated any number of times.
   *
   * @param s the CharSequence to compose on
   * @return a regex which matches any string that consists of the given string repeated any number of times.
   */
  public static Regex anyAmount(CharSequence s) {
    return anyAmount(s, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of the given regex repeated any number of times.
   *
   * @param r the regex to compose on
   * @return a regex which matches any string that consists of the given regex repeated any number of times.
   */
  public static Regex anyAmount(RegexLiteral r) {
    return anyAmount(r, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated any number of times.
   * This uses the provide Evaluation method
   *
   * @param s the CharSequence to compose on
   * @param t the evaluation type
   * @return a regex which matches any string that consists of the given string repeated any number of times.
   */
  public static Regex anyAmount(CharSequence s, EvaluationMethod t) {
    if (s.length() == 1) {
      return new Regex(sanitized(s.charAt(0)), "*", t.toRegex());
    } else {
      return new Regex("(?:", sanitized(s), ")*", t.toRegex());
    }
  }

  /**
   * Returns a regex which matches any string that consists of the given regex repeated any number of times.
   * This uses the provide Evaluation method
   *
   * @param r the regex to compose on
   * @param t the evaluation type
   * @return a regex which matches any string that consists of the given regex repeated any number of times.
   */
  public static Regex anyAmount(RegexLiteral r, EvaluationMethod t) {
    return new Regex(r, r.selfAsGrouped(), "*", t.toRegex());
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated at least once.
   *
   * @param s the CharSequence to compose on
   * @return a regex which matches any string that consists of the given string repeated at least once.
   */
  public static Regex atLeastOne(String s) {
    return atLeastOne(s, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated at least once.
   *
   * @param r the regex to compose on
   * @return a regex which matches any string that consists of any string the given regex matches repeated at least once.
   */
  public static Regex atLeastOne(RegexLiteral r) {
    return atLeastOne(r, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated at least once.
   *
   * @param s the CharSequence to compose on
   * @param t the evaluation type
   * @return a regex which matches any string that consists of the given string repeated at least once.
   */
  public static Regex atLeastOne(CharSequence s, EvaluationMethod t) {
    if (s.length() == 1) {
      return new Regex(sanitized(s.charAt(0)), "+", t.toRegex());
    } else {
      return new Regex("(?:", sanitized(s), ")+", t.toRegex());
    }
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated at least once.
   * This uses the provide Evaluation method
   *
   * @param r the regex to compose on
   * @param t the evaluation type
   * @return a regex which matches any string that consists of any string the given regex matches repeated at least once.
   */
  public static Regex atLeastOne(RegexLiteral r, EvaluationMethod t) {
    return new Regex(r, r.selfAsGrouped(), "+", t.toRegex());
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated between min and max times
   *
   * @param s   the CharSequence to repeat
   * @param min the minimum number of times the character should repeat (inclusive)
   * @param max the maximum number of times the character should repeat (inclusive)
   * @return a regex which matches any string that consists of the given string repeated between min and max times
   */
  public static Regex repeat(CharSequence s, int min, int max) {
    return repeat(s, min, max, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated between min and max times
   *
   * @param g   the regex to repeat
   * @param min the minimum number of times the regex should repeat (inclusive)
   * @param max the maximum number of times the regex should repeat (inclusive)
   * @return a regex which matches any string that consists of any string the given regex matches repeated between min and max times
   */
  public static Regex repeat(RegexLiteral g, int min, int max) {
    return repeat(g, min, max, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated between min and max times
   * This uses the provide Evaluation method
   *
   * @param s   the CharSequence to repeat
   * @param min the minimum number of times the character should repeat (inclusive)
   * @param max the maximum number of times the character should repeat (inclusive)
   * @param t   the evaluation type
   * @return a regex which matches any string that consists of the given string repeated between min and max times
   */
  public static Regex repeat(CharSequence s, int min, int max, EvaluationMethod t) {
    if (s.length() == 1) {
      return new Regex(sanitized(s.charAt(0)),
          "{", Integer.toString(min), ",",
          Integer.toString(max), "}", t.toRegex());
    } else {
      return new Regex(
          "(?:", sanitized(s), ")",
          "{", Integer.toString(min), ",",
          Integer.toString(max), "}", t.toRegex());
    }
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated between min and max times
   * This uses the provide Evaluation method
   *
   * @param g   the regex to repeat
   * @param min the minimum number of times the regex should repeat (inclusive)
   * @param max the maximum number of times the regex should repeat (inclusive)
   * @param t   the evaluation type
   * @return a regex which matches any string that consists of any string the given regex matches repeated between min and max times
   */
  public static Regex repeat(RegexLiteral g, int min, int max, EvaluationMethod t) {
    return new Regex(g, g.selfAsGrouped(),
        "{", Integer.toString(min), ",",
        Integer.toString(max), "}", t.toRegex());
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated exactly amount times
   *
   * @param s      the CharSequence to repeat
   * @param amount the number of times the regex should repeat
   * @return a regex which matches any string that consists of the given string repeated exactly amount times
   */
  public static Regex repeatExactly(CharSequence s, int amount) {
    if (s.length() == 1) {
      return new Regex(sanitized(s.charAt(0)),
          "{", Integer.toString(amount), "}");
    } else {
      return new Regex(
          "(?:", sanitized(s), ")",
          "{", Integer.toString(amount), "}");
    }
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated exactly amount times
   *
   * @param g      the regex to repeat
   * @param amount the number of times the regex should repeat
   * @return a regex which matches any string that consists of any string the given regex matches repeated exactly amount times
   */
  public static Regex repeatExactly(RegexLiteral g, int amount) {
    return new Regex(g, g.selfAsGrouped(),
        "{", Integer.toString(amount), "}");
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated at least min times
   *
   * @param s   the CharSequence to repeat
   * @param min the minimum number of times the character should repeat (inclusive)
   * @return a regex which matches any string that consists of the given string repeated at least min times
   */
  public static Regex repeatAtLeast(CharSequence s, int min) {
    return repeatAtLeast(s, min, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated at least min times
   *
   * @param g   the regex to repeat
   * @param min the minimum number of times the regex should repeat (inclusive)
   * @return a regex which matches any string that consists of any string the given regex matches repeated at least min times
   */
  public static Regex repeatAtLeast(RegexLiteral g, int min) {
    return repeatAtLeast(g, min, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated at least min times
   * This uses the provide Evaluation method
   *
   * @param s   the CharSequence to repeat
   * @param min the minimum number of times the character should repeat (inclusive)
   * @param t   the evaluation type
   * @return a regex which matches any string that consists of the given string repeated at least min times
   */
  public static Regex repeatAtLeast(CharSequence s, int min, EvaluationMethod t) {
    if (s.length() == 1) {
      return new Regex(sanitized(s.charAt(0)),
          "{", Integer.toString(min), ",}", t.toRegex());
    } else {
      return new Regex(
          "(?:", sanitized(s), ")",
          "{", Integer.toString(min), ",}", t.toRegex());
    }
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated at least min times
   * This uses the provide Evaluation method
   *
   * @param g   the regex to repeat
   * @param min the minimum number of times the regex should repeat (inclusive)
   * @param t   the evaluation type
   * @return a regex which matches any string that consists of any string the given regex matches repeated at least min times
   */
  public static Regex repeatAtLeast(RegexLiteral g, int min, EvaluationMethod t) {
    return new Regex(g, g.selfAsGrouped(),
        "{", Integer.toString(min), ",}", t.toRegex());
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated at most max times
   *
   * @param s   the CharSequence to repeat
   * @param max the maximum number of times the character should repeat (inclusive)
   * @return a regex which matches any string that consists of the given string repeated at most max times
   */
  public static Regex repeatAtMost(CharSequence s, int max) {
    return repeatAtMost(s, max, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated at most max times
   *
   * @param g   the regex to repeat
   * @param max the maximum number of times the regex should repeat (inclusive)
   * @return a regex which matches any string that consists of any string the given regex matches repeated at most max times
   */
  public static Regex repeatAtMost(RegexLiteral g, int max) {
    return repeatAtMost(g, max, EvaluationMethod.GREEDILY);
  }

  /**
   * Returns a regex which matches any string that consists of the given string repeated at most max times
   * This uses the provide Evaluation method
   *
   * @param s   the CharSequence to repeat
   * @param max the maximum number of times the character should repeat (inclusive)
   * @param t   the evaluation type
   * @return a regex which matches any string that consists of the given string repeated at most max times
   */
  public static Regex repeatAtMost(CharSequence s, int max, EvaluationMethod t) {
    if (s.length() == 1) {
      return new Regex(sanitized(s.charAt(0)),
          "{0,", Integer.toString(max), "}", t.toRegex());
    } else {
      return new Regex(
          "(?:", sanitized(s), ")",
          "{0,", Integer.toString(max), "}", t.toRegex());
    }
  }

  /**
   * Returns a regex which matches any string that consists of any string the given regex matches repeated at most max times
   * This uses the provide Evaluation method
   *
   * @param g   the regex to repeat
   * @param max the maximum number of times the regex should repeat (inclusive)
   * @param t   the evaluation type
   * @return a regex which matches any string that consists of any string the given regex matches repeated at most max times
   */
  public static Regex repeatAtMost(RegexLiteral g, int max, EvaluationMethod t) {
    return new Regex(g, g.selfAsGrouped(),
        "{0,", Integer.toString(max), "}", t.toRegex());
  }

  /*
   *********************
   * Logical Operators *
   *********************
   */

  /**
   * Constructs a regular expression from the given sub-components. The
   * new Regex constructed will be the concatenation of all of the subcomponents.
   * <p>
   * In other words, if the subcomponents match "a", "b" and "c", then the new regular
   * expression will match "abc"
   *
   * @param components the sub-components of the regular expression
   * @return a new regular expression matching the concatenation of the arguments
   */
  public static Regex concatenate(RegexLiteral... components) {
    return new Regex(components);
  }

  /**
   * Returns a regex which matches one of the given strings. If no strings
   * are provided in the arguments, a regular expression matching nothing is returned
   *
   * @param ss the CharSequences that are the options
   * @return a regex which matches one of the given regular expressions
   */
  public static Regex oneOf(CharSequence... ss) {
    assert (ss.length > 0); // Should not fail because you cannot call
    // oneOf with no arguments due to overloading
    if (ss.length > 1) {
      StringBuilder regex = new StringBuilder();
      regex.append("(?:");
      regex.append(sanitized(ss[0]));
      for (int i = 1; i < ss.length; i++) {
        regex.append("|");
        regex.append(sanitized(ss[i]));
      }
      regex.append(")");
      return new Regex(regex.toString());
    } else {
      return new Regex(sanitized(ss[0]));
    }
  }

  /**
   * Returns a regex which matches one of the given regular expressions. If no regular expressions
   * are provided in the arguments, a regular expression matching nothing is returned
   *
   * @param rs the regular expressions that are the options
   * @return a regex which matches one of the given regular expressions
   */
  public static Regex oneOf(RegexLiteral... rs) {
    assert (rs.length > 0); // Should not fail because you cannot call
    // oneOf with no arguments due to overloading
    if (rs.length > 1) {
      Regex regex = new Regex("");
      StringBuilder b = new StringBuilder();
      b.append("(?:");
      regex.appendRegex(b, rs[0]);
      for (int i = 1; i < rs.length; i++) {
        b.append("|");
        regex.appendRegex(b, rs[i]);
      }
      b.append(")");
      regex.rawRegex = b.toString();
      return new Regex(b.toString());
    } else {
      return new Regex(new RegexLiteral[]{rs[0]});
    }
  }

  /*
   *******************
   * Back-References *
   *******************
   */

  /**
   * Returns a new regex that matches the same thing that the i^th capturing group within a larger regex matched.
   * <p>
   * See Capturing Groups in the class-level documentation
   *
   * @param i Which capturing group to match on
   * @return a regex that matches the same thing that the i^th capturing group within a larger regex matched.
   */
  public static Regex backReference(int i) {
    return new Regex("\\", Integer.toString(i));
  }

  /**
   * Returns a new regex that matches the last thing that the capturing group passed in matched.
   *
   * @param group Which capturing group to match on
   * @return a regex that matches the same thing that the last instance of group matched.
   */
  public static Regex backReference(CapturingGroup group) {
    return new Regex("\\k<", group.label, ">");
  }

  /*
   **************
   * Lookaround *
   **************
   */

  /**
   * Returns a new regex that matches any string that the given regex matches, without consuming any characters.
   * The returned regex essentially acts as an "assert" that the rest of the string matches.
   * <p>
   * In technical terms, the new regex performs zero-width positive lookahead on the provided regex
   *
   * @param r the regex to perform lookahead on
   * @return a new regex that asserts that the rest of the string matches r, but does not consume any characters
   */
  public static Regex lookahead(RegexLiteral r) {
    return new Regex(r,
        "(?=",
        r.rawRegex,
        ")"
    );
  }

  /**
   * Returns a new regex that matches any string that the given regex does not match, without consuming any characters.
   * The returned regex essentially acts as an "assert" that the rest of the string does not match.
   * <p>
   * In technical terms, the new regex performs zero-width negative lookahead on the provided regex
   *
   * @param r the regex to perform negative lookahead on
   * @return a new regex that asserts that the rest of the string does not match r, but does not consume any characters
   */
  public static Regex negativeLookahead(RegexLiteral r) {
    return new Regex(r,
        "(?!",
        r.rawRegex,
        ")"
    );
  }

  /**
   * Returns a new regex that asserts that the preceding part of the string (within a larger regex) matches the provided
   * regex <code>r</code>, without consuming any characters.
   * The returned regex essentially acts as an "assert" that the previous part of the string matches.
   * <p>
   * In technical terms, the new regex performs zero-width positive lookbehind on the provided regex
   *
   * @param r the regex to perform lookbehind on
   * @return a new regex that asserts that the preceding part of the string matches r, but does not consume any characters
   */
  public static Regex lookbehind(RegexLiteral r) {
    return new Regex(r,
        "(?<=",
        r.rawRegex,
        ")"
    );
  }

  /**
   * Returns a new regex that asserts that the preceding part of the string (within a larger regex) does not match the
   * provided regex <code>r</code>, without consuming any characters.
   * The returned regex essentially acts as an "assert" that the previous part of the string does not match.
   * <p>
   * In technical terms, the new regex performs zero-width negative lookbehind on the provided regex
   *
   * @param r the regex to perform negative lookbehind on
   * @return a new regex that asserts that the preceding part of the string does not match r, but does not consume any characters
   */
  public static Regex negativeLookbehind(RegexLiteral r) {
    return new Regex(r,
        "(?<!",
        r.rawRegex,
        ")"
    );
  }


}
