public class Phone_Directory {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        HashSet<String> idx = new HashSet<>();

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static void insert(String s, Node root) {
        Node curr = root;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
            curr.idx.add(s);
        }

        curr.eow = true;
    }

    static ArrayList<String> search(String s, Node root) {
        ArrayList<String> list = new ArrayList<>();

        Node curr = root;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (curr.children[index] == null) {
                list.add("0");
                return list;
            }

            curr = curr.children[index];
        }

        list = new ArrayList<String>(curr.idx);

        return list;
    }

    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // code here
        Node root = new Node();
        for (int i = 0; i < contact.length; i++) {
            insert(contact[i], root);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> list = search(s.substring(0, i + 1), root);
            Collections.sort(list);
            ans.add(list);
        }

        return ans;
    }
}
