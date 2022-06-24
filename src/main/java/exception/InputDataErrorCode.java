package exception;

public enum InputDataErrorCode {
    INVALID_RANGE_LOTTO_NUMBER("[ERROR] 잘못된 숫자를 입력하였습니다. 로또 숫자는 1~45 사이의 숫자입니다."),
    THERE_IS_DUPLICATE_NUMBER("[ERROR] 중복된 데이터가 있습니다."),
    DATA_IS_EMPTY("[ERROR] Lotto Data가 없습니다."),
    INPUT_NOT_NEGATIVE_NUMBER("[ERROR] 음수는 입력할수 없습니다."),
    VALID_LOTTO_SIZE_SIX("[ERROR] 로또는 6개의 숫자가 있어야합니다."),
    ALREADY_EXIST_BALL("[ERROR] 이미 로또안에 있는 볼입니다."),
    NOT_FOUND_RANK_INFO("[ERROR] 당첨 등수 정보가 없습니다.");

    private String errorMessage;

    InputDataErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return this.errorMessage;
    }
}
