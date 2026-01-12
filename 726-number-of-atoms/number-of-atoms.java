class Pair{
    HashMap<String, Integer> map;
    int idx;
    Pair(int idx, HashMap<String, Integer> map){
        this.idx = idx;
        this.map = map;
    }
}
class Solution {
    String formula;
    char[] s;
    int n;
    public String countOfAtoms(String formula) {
        this.formula = formula;
        this.s = formula.toCharArray();
        n = formula.length();

        Pair p = helper(0);
        StringBuilder res = new StringBuilder();
        List<String> sorted = new ArrayList<>(p.map.keySet());
        Collections.sort(sorted);
        for(String atom: sorted){
            res.append(atom);
            int conc = p.map.get(atom);
            if(conc > 1){
                res.append(conc);
            }
        }
        return res.toString();
    }
    
    public Pair helper(int start){
        HashMap<String, Integer> map = new HashMap<>();
        int i = start;
        while(i<n){
            //starting of an element
            if(s[i] >= 'A' && s[i] <= 'Z'){
                int j = readAtom(i+1);
                int k = readConc(j);
                
                String atom = formula.substring(i, j);
                int conc = getConc(j, k);

                map.put(atom, map.getOrDefault(atom, 0)+conc);
                i = k;
            }else if(s[i] == '('){
                Pair p = helper(i+1);
                int k = readConc(p.idx);

                HashMap<String, Integer> atoms = p.map;
                int conc = getConc(p.idx, k);

                for(String atom: atoms.keySet()){
                    map.put(atom, map.getOrDefault(atom, 0)+atoms.get(atom)*conc);
                }
                i = k;
            }else{
                return new Pair(i+1, map);
            }
        }
        return new Pair(i+1, map);
    }

    public int readAtom(int start){
        int i = start;
        while(i<n && s[i] >='a' && s[i]<='z')i++;
        return i;
    }

    public int readConc(int start){
        int i = start;
        while(i<n && s[i]>='0' && s[i]<='9')i++;
        return i;
    }
    public int getConc(int j, int k){
        return j!=k?Integer.parseInt(formula.substring(j, k)):1;
    }
}