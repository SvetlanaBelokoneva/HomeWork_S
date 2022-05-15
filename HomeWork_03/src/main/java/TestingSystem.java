import java.util.Scanner;
import java.io.IOException;

public class TestingSystem {
    private final static int QUESTION_COUNT = 3, ANSWER_COUNT = 5, ALL_ANSWER_COUNT = ANSWER_COUNT * QUESTION_COUNT;
    private static int correctCount = 0, wrongCount = 0;
    private static int userOpinion, correctAnswer;

    public static void main(String[] args) {
        Question question[];
        Answer answer[];

        question = new Question[QUESTION_COUNT];
        answer = new Answer[ALL_ANSWER_COUNT];
        Scanner scan = new Scanner(System.in);

        //инициализация вопросов
        for (int i = 0; i < question.length; i++) {
            question[i] = new Question();

            switch (i + 1) {
                case 1:
                    question[i].setQuestion(i + 1, (i + 1) + ". С чего начинают первую помощь при открытом переломе конечностей, сопровождающемся кровотечением?");
                    answer[0] = new Answer();
                    answer[0].setAnswer(question[i], 1, "   1. С наложения импровизированной шины", false);
                    answer[1] = new Answer();
                    answer[1].setAnswer(question[i], 2, "   2. С наложения жгута выше раны на месте перелома", true);
                    answer[2] = new Answer();
                    answer[2].setAnswer(question[i], 3, "   3. С наложения давящей повязки", false);
                    answer[3] = new Answer();
                    answer[3].setAnswer(question[i], 4, "   4. С наложения санкций", false);
                    answer[4] = new Answer();
                    answer[4].setAnswer(question[i], 5, "   5. С наложения порчи и сглаза", false);
                    break;
                case 2:
                    question[i].setQuestion(i + 1, (i + 1) + ". В каких случаях следует начинать сердечно-легочную реанимацию пострадавшего?");
                    answer[5] = new Answer();
                    answer[5].setAnswer(question[i], 1, "   1. При наличии болей в области сердца и затрудненного дыхания", false);
                    answer[6] = new Answer();
                    answer[6].setAnswer(question[i], 2, "   2. При отсутствии у пострадавшего сознания, независимо от наличия дыхания", false);
                    answer[7] = new Answer();
                    answer[7].setAnswer(question[i], 3, "   3. При наличии признаков депрессии и плохого настроения", false);
                    answer[8] = new Answer();
                    answer[8].setAnswer(question[i], 4, "   4. При отсутствии у пострадавшего сознания, дыхания и кровообращения", true);
                    answer[9] = new Answer();
                    answer[9].setAnswer(question[i], 5, "   5. При отсутствии желания идти на работу", false);
                    break;
                case 3:
                    question[i].setQuestion(i + 1, (i + 1) + ". Разрешено ли давать пострадавшему лекарственные средства при оказании ему первой помощи?");
                    answer[10] = new Answer();
                    answer[10].setAnswer(question[i], 1, "  1. Разрешено", false);
                    answer[11] = new Answer();
                    answer[11].setAnswer(question[i], 2, "  2. Разрешено в случае крайней необходимости", false);
                    answer[12] = new Answer();
                    answer[12].setAnswer(question[i], 3, "  3. Запрещено", true);
                    answer[13] = new Answer();
                    answer[13].setAnswer(question[i], 4, "  4. Разрешено по понедельникам", false);
                    answer[14] = new Answer();
                    answer[14].setAnswer(question[i], 5, "  5. Разрешено по праздникам", false);
                    break;
                default:
                    System.out.println("Количество вопросов превышает запланированный максимум!");
            }
        }

        //вывод перечня вопросов на экран
        System.out.println("Добро пожаловать на викторину по основам доврачебной помощи!");
        for (Question questionInstance : question) {
            System.out.println(questionInstance.getQuestion());

            //вывод перечня ответов на экран
            for (Answer answerInstance : answer) {
                //вывод ответов только для текущего вопроса
                if (questionInstance.equals(answerInstance.questionForAnswer)) {
                    System.out.println(answerInstance.getAnswer());

                    //фиктирование правильного ответа в переменную
                    if (answerInstance.getAnswerIfCorrect())
                        correctAnswer = answerInstance.getAnswerIndex();
                }
            }

            //запрос ответа от пользователя
            System.out.print("Ваш ответ: ");
            try {
                //Считывание с консоли ответа
                while (!scan.hasNextInt()) {
                    System.out.println("Вы ввели не целое число. Ваш ответ: ");
                    scan.next();
                }
                userOpinion = scan.nextInt();

                if(userOpinion >= ANSWER_COUNT) throw new Exception("Нет ответов с таким индексом");

                //Проверка ответа и вывод результата + наращивание счетчики правильных/неправильных ответов
                if (userOpinion == correctAnswer) {
                    correctCount++;
                    System.out.println("Верно!");
                }
                else {
                    wrongCount++;
                    System.out.println("Неверно.");
                    System.out.println("Верный ответ: " + correctAnswer);
                }
            }
            catch(Exception ex) {
                System.out.println(ex.getMessage());
                wrongCount++;
            }
            /*finally {
                System.out.println("Допустимо вводить только целые числа");
                break;
            }*/
        }

        //Вывод общего результата
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }
    //класс, реализующий вопрос викторины-----------------------------------------------------------------------------------
    static class Question
    {
        private int questionIndex;
        private String questionText;

        //инициализация вопроса
        void setQuestion(int questionIndex, String questionText) {
            this.questionIndex = questionIndex;
            this.questionText = questionText;
        }

        //возвращает формулировку вопроса
        String getQuestion() {
            return questionText;
        }
    }
    //класс, реализующий варианты ответов на вопрос-----------------------------------------------------------------------------------
    static class Answer
    {
        private int answerIndex;
        private String answerText;
        private boolean isCorrectAnswer;

        private Question questionForAnswer;

        void setAnswer(Question questionForAnswer, int answerIndex, String answerText, boolean isCorrectAnswer) {
            this.answerIndex = answerIndex;
            this.answerText = answerText;
            this.isCorrectAnswer = isCorrectAnswer;
            this.questionForAnswer = questionForAnswer;
        }

        //возвращает формулировку ответа
        String getAnswer() {
            return answerText;
        }

        //возвращает признак корректного ответа
        boolean getAnswerIfCorrect() {
            return isCorrectAnswer;
        }

        //возвращает индекс ответа
        int getAnswerIndex() {
            return answerIndex;
        }
    }
}
