public class RemoteCalculation implements AutoCloseable {
    public void printMinus(int x, int y) throws OurException {
        //выброс ошибки вверх rethrow
            throw new OurException("Метод по вычиланию чисел пока недоработан. Извините");
    }

    public void printMultiply(int x, int y) {
        String result = x + " * " + y + " = ";
            result  = result + (x * y);
            System.out.println(result);
    }

    public void printDivision(int x, int y) {
        String result = x + " / " + y + " = ";
        try {
            result  = result + (x / y);
            System.out.println(result);
        }
        //вывод ошибки пользователю
        catch (ArithmeticException ex) {
            System.out.println("Нельзя вводить нуль в качестве делителя :" + ex.getMessage());
            System.out.println(result);
        }
        catch (Exception ex) {
            System.out.println("Что-то не так с Кевином: " + ex.getMessage());
            System.out.println(result);
        }
    }

    @Override
    public void close() {
        System.out.println("ADIOS AMIGO!");
    }
}