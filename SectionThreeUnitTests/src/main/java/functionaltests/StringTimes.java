package functionaltests;

public class StringTimes {

    // Given a String and a non-negative int n, return a larger String
    // that is n copies of the original String.
    //
    // stringTimes("Hi", 2) -> "HiHi"
    // stringTimes("Hi", 3) -> "HiHiHi"
    // stringTimes("Hi", 1) -> "Hi"
    public String stringTimes(String str, int n) {
//        throw new UnsupportedOperationException("Not implemented");
        String message = "";
        for(int i=0; i < n; i++){
            message += str;
        }
        return message;
    }

}
