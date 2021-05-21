import java.util.Arrays;

// There is the realization of car registration system.

public class CarArrayList implements CarList{

    private Car[] array = new Car[10];
    private int size = 0;

    // Method "get" returns element from array by its index.
    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    // Method "add" puts element to array.
    @Override
    public void add(Car car) {
        if (size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = car;
        size++;
    }

    // Method "remove" deletes element by its brand and number.
    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(car)){
                return removeAt(i);
            }
        }
        return false;
    }

    // Method "removeAt" deletes element by its index.
    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        if (size - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    // Method "size" returns the value of elements from array.
    @Override
    public int size() {
        return size;
    }

    // Method "clear" deletes all elements from array and set 0 for size.
    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    /*
    Method "checkIndex" checks if index of element is not in the range from 0 to size - 1.
    if it's not then system throws exception IndexOutOfBoundsException().
     */
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}
