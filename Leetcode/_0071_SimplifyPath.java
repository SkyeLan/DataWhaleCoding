package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the
 * directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash /
 * between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute path.
 */
public class _0071_SimplifyPath {
    public static String simplifyPath(String path) {
        String newPath = "";
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        for (String s : str) {
            if (s.equals("") || s.equals("."))
                continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(s);
        }
        if (stack.isEmpty())
            return "/";
        while (!stack.isEmpty())
            newPath = "/" + stack.pop() + newPath;
        return newPath;
    }

    public static void main(String[] args) {
        String p = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(p));
    }
}
