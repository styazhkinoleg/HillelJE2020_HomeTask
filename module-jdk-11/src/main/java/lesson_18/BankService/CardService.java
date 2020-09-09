package lesson_18.BankService;

public class CardService implements Runnable{
    private String cardID;
    private int pin;
    private double amount;
    private Operation operation;
    private String AccountID;
    private ErrorClass messageError;

    public CardService(String cardID, int pin, double amount, Operation operation) {
        this.cardID = cardID;
        this.pin = pin;
        this.amount = amount;
        this.operation = operation;
        messageError = new ErrorClass();
    }

    @Override
    public void run() {
        if(isCorrectInput() && isCardAuthorized()){
            accountChangeAmount();
        }
    }

    public String getMessageError() {
        return messageError.message;
    }
    public byte getErrorCode() {
        return messageError.errorCode;
    }

    /*
    TEST BLOCK BEGIN
    */
    public void generateDataBase(){
        new BankServiceDB().generateDataBase();
    }
    public void showDBInfo() {
        DataBase.DB.values().stream().forEach((x) -> System.out.printf("%s = %.2f\n", x.getID(), x.getAmount()));
        System.out.println();
    }
    /*
    TEST BLOCK END
    */

    private boolean isCorrectInput(){
        if(amount > 0 && operation != null)
            return true;
        else {
            messageError.errorCode = 4;
            messageError.message = "Wrong operation";
        }
        return false;
    }
    private boolean isCardAuthorized() {
        int count = 3;
        for (int i = 0; i < count; i++) {
            BankServiceDB DB = new BankServiceDB();
            try {
                BankServiceDB.AnswerDB answerDB = DB.getDataByCardID(cardID, pin);
                if (answerDB == null) {
                    messageError.errorCode = 2;
                    messageError.message = "Card not found";
                    return false;
                } else {
                    AccountID = answerDB.AccountID;
                    if (!answerDB.CardAccess) {
                        messageError.errorCode = 3;
                        messageError.message = "Wrong ping number";
                    }
                    return answerDB.CardAccess;
                }
            }
            catch (Exception e) {
                messageError.errorCode = 1;
                messageError.message = "Connection error with database";
            }
        }
        return false;
    }
    private synchronized boolean accountChangeAmount(){
        if (operation.equals(Operation.RECHARGE)){
            System.out.printf("ID thread = %d. RECHARGE - % 10.2f from %s\n",
                    Thread.currentThread().getId(), amount, AccountID);
            return new BankServiceDB().recharge(AccountID, amount);
        } else if (operation.equals(Operation.WITHDRAW)){
            System.out.printf("ID thread = %d. WITHDRAW - % 10.2f from %s\n",
                    Thread.currentThread().getId(), amount, AccountID);
            if(new BankServiceDB().withdraw(AccountID, amount)){
                return true;
            } else {
                messageError.errorCode = 4;
                messageError.message = "Not enough money to operation.";
                return false;
            }
        }
        return false;
    }

    /* Error code:
    0 - no error
    1 - no connect with database
    2 - card not find in database
    3 - input wrong pin
    4 - wrong operation
    */
    public class ErrorClass {
        public String message;
        public byte errorCode;
    }
}
