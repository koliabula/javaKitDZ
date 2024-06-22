package MultiThreading.DZ_5;

public class Fork {
    private boolean isFree;

    public Fork() {
        isFree = true;
    }

    public boolean getFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

}
