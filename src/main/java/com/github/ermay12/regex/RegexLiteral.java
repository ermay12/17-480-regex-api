package com.github.ermay12.regex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexLiteral {
  Pattern pattern;
  String rawRegex;
  final Object privatesyncobj = new Object();
  Map<CapturingGroup, Integer> groupToIndex = new HashMap<>();
  int numGroups = 0;

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
  RegexLiteral(String... components) {
    StringBuilder b = new StringBuilder();
    for (String inner : components) {
      b.append(inner);
    }
    rawRegex = b.toString();
    pattern = null;
  }


  /**
   * Constructs a Regular Expression from the regular expression subcomponents.
   * Takes group indexing regex from a base regex.
   * Note that this method does not escape any characters
   *
   * @param base       the regex to copy group indexing info from
   * @param components the sub-components of the regular expression
   */
  RegexLiteral(RegexLiteral base, String... components) {
    this(components);
    this.numGroups = base.numGroups;
    this.groupToIndex = base.groupToIndex;
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
  public RegexLiteral(RegexLiteral... components) {
    StringBuilder b = new StringBuilder();
    numGroups = 0;
    for (RegexLiteral inner : components) {
      appendRegex(b, inner);
    }
    rawRegex = b.toString();
    pattern = null;
  }
  /*
   *******************
   * Public Helpers *
   *******************
   */

  /**
   * Returns the raw regex string that this regex is composed of
   *
   * @return the raw regex string that this regex is composed of
   */
  public String getRawRegex() {
    return rawRegex;
  }

  @Override
  public String toString() {
    return rawRegex;
  }

  /*
   *******************
   * Private Helpers *
   *******************
   */

  /**
   * Appends a regex's string to a builder, while also updating capturing group information.
   *
   * @param b     the builder being used
   * @param regex the regex, which may contain capturing groups
   */
  void appendRegex(StringBuilder b, RegexLiteral regex) {
    b.append(regex.rawRegex);
    final int curGroupIndex = numGroups;
    regex.groupToIndex.forEach((group, index) -> {
      if (this.groupToIndex.containsKey(group)) {
        // Remove label from capturing group
        String toFind = "?<" + group.label + ">";
        int startIndex = b.indexOf(toFind);
        assert (startIndex != -1);
        b.delete(startIndex, startIndex + toFind.length());
      }
      this.groupToIndex.put(group, index + curGroupIndex);
    });
    numGroups += regex.numGroups;
  }

  /**
   * Returns a matcher on the given input
   *
   * @param input the input to match on
   * @return A matcher for the given input
   */
  Matcher getMatcher(String input) {
    if (pattern == null) {
      synchronized (privatesyncobj) {
        if (pattern == null) {
          pattern = pattern.compile(rawRegex);
        }
      }
    }
    return pattern.matcher(input);
  }

  static final List<Character> metacharacters = Arrays.asList('?', '\\', '-', '=', '[', ']', '(', ')',
      '{', '}', '<', '>', '!', '*', '.', '+',
      '^', '$', '|');

  /**
   * Returns the given character as a string, escaped if necessary
   *
   * @param c The character to sanitize
   * @return the given character as a string, escaped if necessary
   */
  static String sanitized(char c) {
    StringBuilder b = new StringBuilder();
    if (metacharacters.contains(c)) {
      b.append('\\');
    }
    b.append(c);

    return b.toString();
  }

  /**
   * Returns the given string, escaping any metacharacters that appear
   *
   * @param s the string to sanitize
   * @return the given string, escaped if necessary
   */
  static String sanitized(String s) {
    //TODO(astanesc): Use a regex or .contains?
    StringBuilder b = new StringBuilder();
    for (char c : s.toCharArray()) {
      b.append(sanitized(c));
    }
    return b.toString();
  }

  /**
   * Returns this regex as a group that can be used with quantifiers
   * <p>
   * The default implementation returns the regex within a non-capturing group
   *
   * @return this regex as a group
   */
  String selfAsGrouped() {
    StringBuilder r = new StringBuilder();
    r.append("(?:");
    r.append(rawRegex);
    r.append(")");
    return r.toString();
  }

}
