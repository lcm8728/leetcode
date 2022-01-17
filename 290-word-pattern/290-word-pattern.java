class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        
        if(split.length != pattern.length()) return false;
        
        HashMap<String, Character> dict1 = new HashMap<>();
        HashMap<Character, String> dict2 = new HashMap<>();
        for(int i = 0; i < split.length; ++i) {
            Character ch = pattern.charAt(i);
            String word = split[i];
            
            if(!dict1.containsKey(word) && !dict2.containsKey(ch)) {
                dict1.put(word, ch);
                dict2.put(ch, word);
            } else if(!ch.equals(dict1.put(word, ch)) || !word.equals(dict2.put(ch, word))) {
                return false;
            }
        }

        return true;
    }
}