package java8.interfaceT;

public interface InterfaceM {
    int getSize();

    default int size() {

        return getSize()*5;
    }
}
