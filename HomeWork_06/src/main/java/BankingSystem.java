import java.util.*;

public class BankingSystem {
    private final static int MIN_ARRAY_DIMENSION = 1, MAX_ARRAY_DIMENSION = 1000000, ARRAY_BOUND = 20,
                             START_ACCOUNT_NUMBER = 50000;
    private final static int COUNT_CLIENT_IN_BANK = 3;

    public static void main(String[] args) {
        Client[] clientList = createRandomClientsList(COUNT_CLIENT_IN_BANK);
        printClientsList(clientList);

        //пользователь задаёт количество счетов в банке
        int accountListDimension = getAccountListDimension();

        HashMap<Account, Client> accountList = createRandomAccounts(accountListDimension, clientList);
        printAccountList(accountList);

        //по какому номеру счета в банке пользователь хочет получить инфо
        int accountNumber = getAccountInfo();

        findClient(accountNumber, accountList);

        //для какого клиента банка пользователь хочет получить инфо
        String clientFullname = getClientFullname();

        ArrayList<Account> acountList4Client = getAccounts4Client(clientFullname, accountList);
        printAccountList4Client(acountList4Client);
    }

    //формирование перечня клиентов банка
    static Client[] createRandomClientsList(int countClientInBank) {
        Random rnd = new Random();
        Calendar calendar = Calendar.getInstance();
        Client[] client = new Client[countClientInBank];

        for (int i = 0; i < client.length; i++) {
            calendar.add(Calendar.YEAR, -rnd.nextInt(ARRAY_BOUND));
            client[i] = new Client();
            client[i].setClient(i + 1, "Фамилия_" + (i + 1), "Имя_" + (i + 1), "Отчество_" + (i + 1), calendar.getTime());
        }

        return client;
    }

    //вывод на экран перечня клиентов банка
    static void printClientsList(Client[] clients) {
        System.out.println("Перечень всех клиентов банка:");

        for (Client clientInstance : clients) {
            clientInstance.printClient();
        }
    }

    //получение от пользователя информации
    static int getUserInfo(String questionText, String errorTextTry, String errorTextCatch, int minValue, int maxValue) {
        int userResponse = 0;

        Scanner scan = new Scanner(System.in);
        System.out.print(questionText);
        try {
            //Считывание с консоли ответа
            while (!scan.hasNextInt()) {
                System.out.println(errorTextTry);
                scan.next();
            }
            userResponse = scan.nextInt();
                    if (userResponse > maxValue || userResponse < minValue)
                        throw new Exception(errorTextCatch);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return userResponse;
    }

    //определение количество рассматриваемых счетов банка
    static int getAccountListDimension() {
        int countAccountInBank;
        countAccountInBank = getUserInfo("Задайте количество счетов, которые будут открыты в банке для разных клиентов (от " + MIN_ARRAY_DIMENSION + " до " + MAX_ARRAY_DIMENSION + "): ",
                "Вы ввели не целое число. Задайте количество счетов: ",
                "Число должно быть в диапазоне от " + MIN_ARRAY_DIMENSION + " до " + MAX_ARRAY_DIMENSION,
                MIN_ARRAY_DIMENSION,
                MAX_ARRAY_DIMENSION);

        return countAccountInBank;
    }

    //по какому номеру счета в банке пользователь хочет получить инфо
    static int getAccountInfo() {
        int accountNumber;
        accountNumber = getUserInfo("По какому номеру счета Вы хотите получить информацию о клиенте: ",
                "Вы ввели не целое число. Задайте количество счетов: ",
                "Число должно быть в диапазоне от " + START_ACCOUNT_NUMBER + " до " + START_ACCOUNT_NUMBER+MAX_ARRAY_DIMENSION,
                START_ACCOUNT_NUMBER,
                START_ACCOUNT_NUMBER+MAX_ARRAY_DIMENSION);

        return accountNumber;
    }

    //для какого клиента банка пользователь хочет получить инфо
    static String getClientFullname() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ФИО клиента банка, по которому неоюходиимо вывести перечень его счетов: ");
        String userResponseFullname = scan.nextLine();

        return userResponseFullname;
    }

    //поиск всех счетов по клиенту
    static ArrayList<Account> getAccounts4Client(String fullname, HashMap<Account, Client> accountList) {
        Client client = new Client();
        client.fullname = fullname;
        ArrayList<Account> acountsList = new ArrayList<>();

        for (Map.Entry<Account, Client> entry : accountList.entrySet()) {
            if (entry.getValue().equals(client)) {
                //System.out.println(entry.getKey().toString());
                acountsList.add(entry.getKey());
            }
        }

        return acountsList;
    }

    //вывод на экран всех счетов по клиенту
    static void printAccountList4Client(ArrayList<Account> accountsList) {
        System.out.println(accountsList);
    }

    //поиск клиента по счету
    static void findClient(Integer accountNumber, HashMap<Account, Client> accountList) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        Client client = accountList.get(account);
        client.printClient();
    }

    static HashMap<Account, Client> createRandomAccounts(int arrayDimension, Client[] clients) {
        Random rnd = new Random();
        HashMap<Account, Client> randomAccountsList = new HashMap<>();
        Account[] account = new Account[arrayDimension];

        for (int i = 0; i < clients.length; i++) {
            for (int j = randomAccountsList.size(); j < arrayDimension / clients.length * (i + 1); j++) {
                account[j] = new Account();
                account[j].setAccounts(START_ACCOUNT_NUMBER + j, /*clients[i],*/ rnd.nextInt(ARRAY_BOUND) + 200);
                randomAccountsList.put(account[j], clients[i]);
            }
        }

        //остаток от деления (оставшееся кол-восчетов) отдать первому клиенту
        for (int j = randomAccountsList.size(); j < account.length; j++) {
            account[j] = new Account();
            account[j].setAccounts(START_ACCOUNT_NUMBER + j, /*clients[0],*/ rnd.nextInt(ARRAY_BOUND) + 200);
            randomAccountsList.put(account[j], clients[0]);
        }

        return randomAccountsList;
    }

    static void printAccountList(HashMap<Account, Client> accountList) {
        Set<Account> keys = accountList.keySet();
        System.out.println("Ключи: " + keys);

        ArrayList<Client> values = new ArrayList<>(accountList.values());
        System.out.println("Значения: " + values);
    }
}