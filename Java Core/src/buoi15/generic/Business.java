package buoi15.generic;

public interface Business<T> {
    void execute(T business);
    // class implement interface này phải override lại execute()
}
