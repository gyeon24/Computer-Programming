package lab12_handout;


//*******************************************************************
// # 94
//*******************************************************************
// Name : AccountType
// Type : Enum
// Description : 계좌 타입(예금계좌, 저축계좌)을 Enum으로 나타낸 열거형 데이터를 구현
//*******************************************************************
public enum AccountType {
    CHECKING("예금계좌"),
    SAVINGS("저축계좌");
	
	private final String description;
	
	AccountType(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return description;
	}
	
}
