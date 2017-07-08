package MyClasses;

public class MyArrays {
    public void print10x10(int array[]) {                  //вывод массива на печать, строками по 10 элементов
        String str = "";
        int t = 0;
        System.out.print(" ");
        for (int i = 0; i < array.length; i++) {

            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }
    }

}