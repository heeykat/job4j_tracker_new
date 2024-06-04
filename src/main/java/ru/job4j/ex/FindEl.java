package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element Is Not Found");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = new String[] {"one, two, tree, four"};
/*        try {
            indexOf(arr, "five");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
 */
        try {
            indexOf(arr, "five");
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
