class Solution {
    public List<List<String>> wordSquares(String[] words) {
        HashMap<String, List<String>> m1 = new HashMap<>();
        HashMap<Character, List<String>> m2 = new HashMap<>();

        for(String word: words){
            String s = word.charAt(0) +""+ word.charAt(3);
            m1.computeIfAbsent(s, k->new ArrayList<>()).add(word);
            m2.computeIfAbsent(word.charAt(0), k->new ArrayList<>()).add(word);
        }

        List<List<String>> result = new ArrayList<>();
        
        for(String word: words){
            List<String> leftSet = m2.getOrDefault(word.charAt(0), new ArrayList<>());
            List<String> rightSet = m2.getOrDefault(word.charAt(3), new ArrayList<>());

            for(String left: leftSet){
                if(left.equals(word))continue;
                for(String right: rightSet){
                    if(right.equals(word) || right.equals(left))continue;
                    List<String> bottomSet = m1.getOrDefault(left.charAt(3)+""+right.charAt(3), new ArrayList<>());
                    for(String bottom: bottomSet){
                        if(bottom.equals(word) || bottom.equals(left) || bottom.equals(right))continue;
                        List<String> temp = new ArrayList<>();
                        temp.add(word);
                        temp.add(left);
                        temp.add(right);
                        temp.add(bottom);
                        result.add(temp);
                    }
                }
            }
        }

        Collections.sort(result, (a, b)->{
            for(int i=0; i<4; i++){
                int res = a.get(i).compareTo(b.get(i));
                if(res != 0){
                    return res;
                }
            }
            return 0;
        });

        return result;
    }
}