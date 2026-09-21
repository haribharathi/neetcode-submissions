class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        traverse("", n, 0, 0);
        return list;
    }

    public void traverse(String s, int n, int open, int end) {
        if (end > open) {
            return;
        }
        if (s.length() == 2 *n) {
            //System.out.println("st " + open + "end" + end);
            list.add(s);
            return;
        }
        if (open < n) {
            s = s + "(";
            open++;
            traverse(s, n, open, end);
            s = s.substring(0, s.length() - 1);
            open--;
        }
        //open--;
        if (end < n) {
            s = s + ")";
            end++;
            traverse(s, n, open, end);
            s = s.substring(0, s.length() - 1);
            end--;
        }
        //s = s.substring(0, s.length() - 1);
        //end--;
    }
}
