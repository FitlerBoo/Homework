package Lesson2;

import java.util.Comparator;

/** Создает пустой список элементов заданного типа T с динамически изменяемой размерностью.
 *
 * @param <T> Задает тип содержащихся в списке элементов
 */
public class MyArrayList<T>{
    private final int INITIAL_ARRAY_LENGTH = 16;
    private final int CUT_RATE = 4;
    private T[] myArray = (T[])new Object[INITIAL_ARRAY_LENGTH];
    private int myCounter = 0;

    /** Добавляет в конец списка один передаваемый элемент заданного типа
     *
     *@param element элемент, который нужно вставить.
     */
    public void add(T element){
        if(myCounter == myArray.length-1)
            resize(myArray.length*2);
        myArray[myCounter++] = element;
    }

    /** <p>Добавляет в список один передаваемый элемент заданного типа по заданному индексу</p>
     * <p>Метод принимает два параметра:</p>
     *
     *@param index индекс, по которому вставляется элемент;
     *@param element элемент, который нужно вставить.
     */
    public void add(int index, T element){
        rangeCheck(index);
        for (int i = index; i<myCounter; i++){
            if(i == myArray.length - 1)
                resize(myArray.length*2);
            myArray[i+1] = myArray[i];
        }
        myArray[index] = element;
        myCounter++;
    }

    /** Возвращает из заданного списка элемент по передаваемому индексу
     *
     * @param index индекс возвращаемого элемента.
     */
    public T get(int index){
        rangeCheck(index);
        return myArray[index];
    }

    /** Удаляет из списка элемент по передаваемому индексу
     *
     * @param index индекс удаляемого элемента.
     */
    public void remove(int index) {
        rangeCheck(index);
        for (int i = index; i<myCounter; i++)
            myArray[i] = myArray[i+1];
        myArray[myCounter] = null;
        myCounter--;
        if (myArray.length > INITIAL_ARRAY_LENGTH && myCounter < myArray.length / CUT_RATE)
            resize(myArray.length/2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }

    /** Очищает коллекцию от всех элементов и приводит ее к первоначальным характеристикам размерности
     */
    public void clear(){
        myArray = (T[])new Object[INITIAL_ARRAY_LENGTH];
        myCounter = 0;
    }

    /** Возвращает количество элементов заданной коллекции
     */
    public int size(){
        return myCounter;
    }

    /** Сортирует заданный список по возрастанию по установленному <u>comparator</u> правилу
     *
     * @param comparator интерфейс, задающий правило сравнения элементов.
     */
    public void sort(Comparator<T> comparator){
        quicksort(myArray, 0, myCounter - 1, comparator);
    }

    private void quicksort(T[] arr, int low, int high, Comparator<T> comparator){
        if (low < high) {
            int partitionIndex = partition(arr, low, high, comparator);
            quicksort(arr, low, partitionIndex - 1, comparator);
            quicksort(arr, partitionIndex + 1, high,comparator);
        }
    }

    private int partition(T[] arr, int low, int high, Comparator<T> comparator) {
        T pivot = arr[high];
        int i = (low-1);

        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j],pivot) < 0) {
                i++;

                T swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        T swapTemp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = swapTemp;

        return i+1;
    }

    private void resize(int newLength) {
        T[] newArray = (T[])new Object[newLength];
        System.arraycopy(myArray, 0, newArray, 0, myCounter);
        myArray = newArray;
    }

    private void rangeCheck(int index) {
        if (index > myCounter || index < 0)
            throw new IndexOutOfBoundsException("Выход за границы списка");
    }
}
