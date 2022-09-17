class Solution {
    private TrieNode root = new TrieNode();
    public List<List<Integer>> palindromePairs(String[] words) {
        int empty = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                empty = i;
                continue;
            }
            insert(words[i], i);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (empty >= 0 && i != empty && isPal(words[i])) {
                List<Integer> tt = new ArrayList<>();
                tt.add(empty);
                tt.add(i);
                res.add(tt);
            }
            
            Set<Integer> tmp = query(words[i]);
            
            for (int x : tmp) {
                if (x == i) {
                    continue;
                }
                List<Integer> tt = new ArrayList<>();
                tt.add(x);
                tt.add(i);
                res.add(tt);
            }
        }
        
        return res;
    }
    
    private void insert(String word, int index) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
                node.children[idx].val = ch;
            }
            
            node = node.children[idx];
        }
        node.index = index;
    }
    
    private Set<Integer> query(String word) {
        TrieNode node = root;
        char[] chs = word.toCharArray();
        Set<Integer> res = new HashSet<>();
        int i = chs.length-1;
        for (; i >= 0; i--) {
            int idx = chs[i] - 'a';
            if (node.children[idx] == null) {
                break;
            }
            node = node.children[idx];
            
            if (node.index >= 0) {
                if (isPal(word.substring(0, i))) {
                    res.add(node.index);
                }
            }
        }
        
        if (i >= 0) {
            if (node.index < 0) {
                return res;
            }
            if (isPal(word.substring(0, i+1))) {
                res.add(node.index);
            }
        } else {
            if (node.index >= 0) {
                res.add(node.index);
            }
            for (int j = 0; j < node.children.length; j++) {
                StringBuilder sub = new StringBuilder();
                if (node.children[j] != null) {
                    querySubs(node.children[j], res, sub);
                }
            }
        }
        return res;
    }
    
    private void querySubs(TrieNode node, Set<Integer> res, StringBuilder sub) {
        sub.append(node.val);
        if (node.index >= 0) {
            if (isPal(sub.toString())) {
                res.add(node.index);
            }
        }
        
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                querySubs(node.children[i], res, sub);
            }
        }
        sub.deleteCharAt(sub.length() - 1);
    } 
    
    private boolean isPal(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int index = -1;
    char val;
}