import java.lang.reflect.*;
import java.util.DoubleSummaryStatistics;

public class MethodPointerTest {
    public static void main(String[] args) throws Exception{

        Method square = MethodPointerTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * Возвращает квадрат числа.
     * @param x Число
     * @return Квадрат числа
     */

    public static double square(double x){
        return x*x;
    }

    /**
     * Выводит таблицу значений x и y метода.
     * @param from Нижняя граница значений x
     * * @param to Верхняя граница значений x
     * * @param n Количество строк в таблице
     * * @param f Метод, получающий и возвращающий значения
     *             типа double
     */

    public static void printTable(double from, double to, int n, Method f){

        System.out.println(f);
        double dx = (to-from)/(n-1);
        for (double x = from; x <= to; x +=dx){
            try{
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            }
            catch (Exception e) {e.printStackTrace();}

        }
    }
}
