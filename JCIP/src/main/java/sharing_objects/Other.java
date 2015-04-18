package sharing_objects;

import sharing_objects.ThisEscape.Inner;

public class Other {
    public static void main(String[] args) {
        ThisEscape es = new ThisEscape();
        Inner in = es.getInner();

    }
}
