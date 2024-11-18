public class p71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        Stack<String> reverseStack = new Stack<>();

        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }

        while (!reverseStack.isEmpty()) {
            result.append("/").append(reverseStack.pop());
        }

        return result.toString();
    }
}
