/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.ermay12.regex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Regex {
  private Pattern pattern;
  private String rawRegex;
  private final String privatesyncobj = "";

  protected Regex(String... components) {
    StringBuilder b = new StringBuilder();
    for(String inner : components) {
      b.append(inner);
    }
    rawRegex = b.toString();
    pattern = null;
  }

  public Regex(Regex... components) {
    StringBuilder b = new StringBuilder();
    for(Regex inner : components) {
      b.append(inner.rawRegex);
    }
    rawRegex = b.toString();
    pattern = null;
  }

  public static Regex fromRawRegex(String regex) {
      return new Regex(regex);
  }

  private Matcher getMatcher(String input) {
    if (pattern == null) {
      synchronized (privatesyncobj) {
         if(pattern == null) {
           pattern = pattern.compile(rawRegex);
         }
      }
    }
    return pattern.matcher(input);
  }

  public RegexMatch getMatch(String input, int i) {
    Matcher m = getMatcher(input);
    for (int j = 0; j <= i; j++) {
      m.find();
    }
    return new RegexMatch(m);
  }

  public RegexMatch firstMatch(String input) {
    Matcher m = getMatcher(input);
    m.find();
    return new RegexMatch(m);
  }

  public boolean doesMatch(String input) {
    Matcher m = getMatcher(input);
    return m.find();
  }

  public String replace(String input, ReplacementRegex replacement) {
    Matcher m = getMatcher(input);
    return m.replaceAll(replacement.toString());
  }

  @FunctionalInterface
  public interface ReplacementLambda {
    String matchCallback(RegexMatch match);
  }

  public String replace(String input, ReplacementLambda l) {
    Matcher m = getMatcher(input);
    return m.replaceAll(match -> l.matchCallback(new RegexMatch(match)));
  }

  public Stream<RegexMatch> getMatches(String input) {
    Matcher m = getMatcher(input);
    return m.results().map(RegexMatch::new);
  }

  public String getRawRegex() {
    return rawRegex;
  }

  public String toString() {
      return rawRegex;
  }

  private static final List<Character> metacharacters = Arrays.asList('?', '\\', '-', '=', '[', ']', '(', ')', '{', '}', '<', '>', '!', '*', '.', '+', '^', '$', '|' );

  protected static String sanitized(char c) {
    StringBuilder b = new StringBuilder();
    if(metacharacters.contains(c)) {
      b.append('\\');
    }
    b.append(c);

    return b.toString();
  }

  private static Regex badEscapeChecker = Regex.fromRawRegex(".*\\\\E.*");

  protected static String sanitized(String s) {
    //TODO(astanesc): Use a regex or .contains?
    StringBuilder b = new StringBuilder();
    if(s.contains("\\E") || s.length() == 1) {
      for (char c : s.toCharArray()) {
        b.append(sanitized(c));
      }
    } else {
      b.append("\\Q");
      b.append(s);
      b.append("\\E");
    }
    return b.toString();
  }

  protected String selfAsGrouped() {
    StringBuilder r = new StringBuilder();
    r.append("(?:");
    r.append(rawRegex);
    r.append(")");
    return r.toString();
  }

  public static Regex lookahead(Regex regex) {
    return new Regex(
            "(?=",
            regex.rawRegex,
            ")"
    );
  }

  public static Regex anyAmount(char c) {
    return new Regex(sanitized(c), "*");
  }

  public static Regex anyAmount(Regex s) {
    return new Regex(s.selfAsGrouped(), "*");
  }

  public static Regex atLeastOne(Regex s) {
    return new Regex(s.selfAsGrouped(), "+");
  }

  public static Regex capture(Regex s) {
    return new CapturingGroup("(", s.rawRegex, ")");
  }

  private static Regex regexLabel = Regex.fromRawRegex("[a-zA-Z][a-zA-Z0-9]*");

  public static Regex capture(Regex s, String label) {
    if(!regexLabel.doesMatch(label)) {
      throw new IllegalArgumentException("Label must be ok");
    }

    return new CapturingGroup("(?<", label, ">", s.rawRegex, ")");
  }

  public static Regex optional(char c) {
    return new Regex(sanitized(c), "?");
  }

  public static Regex optional(Regex s) {
    return new Regex(s.selfAsGrouped(), "?");
  }

  public static Regex repeat(char c, int min, int max) {
    return new Regex(sanitized(c),
                      "{", Integer.toString(min), ",",
                      Integer.toString(max), "}");
  }

  public static Regex repeat(Regex g, int min, int max) {
    return new Regex(g.selfAsGrouped(),
                     "{", Integer.toString(min), ",",
                     Integer.toString(max), "}");
  }

  public static Regex repeatAtLeast(Regex g, int min) {
    return new Regex(g.selfAsGrouped(),
                     "{", Integer.toString(min), ",}");
  }

  public static Regex oneOf(Regex s1, Regex... ss) {
    StringBuilder regex = new StringBuilder();
    regex.append("(?:");
    regex.append(s1.rawRegex);
    for (Regex s : ss) {
      regex.append("|");
      regex.append(s.rawRegex);
    }
    regex.append(")");
    return new Regex(regex.toString());
  }

  public static Regex single(CharacterClass c) {
    return c;
  }

  public static Regex string(String s) {
    return new Regex(sanitized(s));
  }

  public static final Regex LINE_START = new Regex("^");
  public static final Regex LINE_END = new Regex("$");

  private static class CapturingGroup extends Regex {
    public CapturingGroup(String... components) {
      super(components);
    }

    @Override
    protected String selfAsGrouped() {
      return getRawRegex();
    }
  }
}
