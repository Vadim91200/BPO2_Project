package Pi�ce;

import g�om�trie.Direction;

public class Roi extends Pi�ce{
    private Direction cap;
    public Roi(){
        super.setNom("Roi");
    }
    @Override
    public String toString() {
        return "r";
    }
}
