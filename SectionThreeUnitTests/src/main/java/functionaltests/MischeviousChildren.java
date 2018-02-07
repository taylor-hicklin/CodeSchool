package functionaltests;

public class MischeviousChildren {
    // We have two children, a and b, and the parameters aSmile and
    // bSmile indicate if each is smiling. We are in trouble if they
    // are both smiling or if neither of them is smiling. Return true
    // if we are in trouble.
    //
    // areWeInTrouble(true, true) -> true
    // areWeInTrouble(false, false) -> true
    // areWeInTrouble(true, false) -> false
    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
//        throw new UnsupportedOperationException("Not implemented");
        boolean trouble;

        if(aSmile && bSmile){
            trouble = true;
        } else if (!aSmile && !bSmile) {
            trouble = true;
        } else {
            trouble = false;
        }
        return trouble;
    }
}
