import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 */
class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> matching = new HashMap<>();
        matching.put(')', '(');
        matching.put(']', '[');
        matching.put('}', '{');
        Stack<Character> opening = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                opening.push(current);
            } else {
                if (opening.isEmpty()) {
                    return false;
                } else {
                    char top = opening.peek();
                    if ((current == ')' && top == '(') ||
                            (current == '}' && top == '{') ||
                            (current == ']' && top == '[')
                    ) {
                        opening.pop();
                    } else {
                        return false;
                    }
                }

            }
        }

        return opening.isEmpty();
    }
}