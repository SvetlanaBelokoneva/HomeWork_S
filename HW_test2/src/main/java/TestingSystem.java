import java.util.Scanner;

public class TestingSystem {
    public static void main(String[] args) {
        int questionCnt = 3, answerCnt = 5, correctCnt = 0, wrongCnt = 0;
        int userOpinion;

        //Массив вопросов
        String[] questions = new String[questionCnt];
        questions[0] = "С чего начинают первую помощь при открытом переломе конечностей, сопровождающемся кровотечением?";
        questions[1] = "В каких случаях следует начинать сердечно-легочную реанимацию пострадавшего?";
        questions[2] = "Разрешено ли давать пострадавшему лекарственные средства при оказании ему первой помощи?";

        //Массив вариантов ответов
        String[][] answerOptions = new String[questionCnt][answerCnt];
        answerOptions[0][0] = "1. С наложения импровизированной шины";
        answerOptions[0][1] = "2. С наложения жгута выше раны на месте перелома";
        answerOptions[0][2] = "3. С наложения давящей повязки";
        answerOptions[0][3] = "4. С наложения санкций";
        answerOptions[0][4] = "5. С наложения порчи и сглаза";

        answerOptions[1][0] = "1. При наличии болей в области сердца и затрудненного дыхания";
        answerOptions[1][1] = "2. При отсутствии у пострадавшего сознания, независимо от наличия дыхания";
        answerOptions[1][2] = "3. При наличии признаков депрессии и плохого настроения";
        answerOptions[1][3] = "4. При отсутствии у пострадавшего сознания, дыхания и кровообращения";
        answerOptions[1][4] = "5. При отсутствии желания идти на работу";

        answerOptions[2][0] = "1. Разрешено";
        answerOptions[2][1] = "2. Разрешено в случае крайней необходимости";
        answerOptions[2][2] = "3. Запрещено";
        answerOptions[2][3] = "4. Разрешено по понедельникам";
        answerOptions[2][4] = "5. Разрешено по праздникам";


        //Массив правильных ответов
        int[] correctAnswers = new int[questionCnt];
        correctAnswers[0] = 2;
        correctAnswers[1] = 4;
        correctAnswers[2] = 3;

        System.out.println("Добро пожаловать на викторину по основам доврачебной помощи!");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        //Цикл по всем вопросам - исправить, написать правильно
        for(int i = 0; i < questions.length; i++) {
            //Вывод вопроса на экран
            System.out.println(questions[i]);

            //Вывод вариантов ответов на экран
            for (int j = 0; j < answerOptions[i].length; j++) {
                System.out.println(answerOptions[i][j]);
            }

            System.out.print("Ваш ответ: ");
            //Считывание с консоли ответа
            userOpinion = scan.nextInt();

            //Проверка ответа и вывод результата + наращивание счетчики правильных/неправильных ответов
            if (userOpinion == correctAnswers[i]) {
                correctCnt++;
                System.out.println("Верно!");
            }
            else {
                wrongCnt++;
                System.out.println("Неверно.");
                System.out.println("Верный ответ: " + correctAnswers[i] + " (" + answerOptions[i][correctAnswers[i]-1] + ")");
            }
        }

        //Вывод общего результата
        System.out.println("Результат: правильно " + correctCnt + ", неправильно " + wrongCnt);
    }
}