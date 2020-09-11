package summer2019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordDictionary {

    Map<Integer,Set<String>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public WordDictionary() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(map.get(word.length())!=null)
            map.get(word.length()).add(word);
        else{
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(word.length(),set);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(map.get(word.length())==null)
            return false;
        Set<String> set = map.get(word.length());
       p:for(String item:set){
            char[] items = item.toCharArray();
            char[] chars = word.toCharArray();
            for(int i=0;i<items.length;i++){
                if(chars[i]!='.' && chars[i]!=items[i])
                    continue p;
            }
            return true;
        }
        return false;
    }

}
