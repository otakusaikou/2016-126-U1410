package practice0530.model;

import practice0530.model.User;

/*
 * 此Java Class扮演MVC架構中Model的角色, 會讓Controller來呼叫使用
 */
public class AccountUtil {

	/**
	 * 此方法用來新增一位使用者
	 * 
	 * @param name
	 *            使用者所輸入的名字
	 * @param address
	 *            使用者所輸入的地址
	 * @param phoneNumber
	 *            使用者所輸入的電話號碼
	 * @param education
	 *            使用者所輸入的教育程度
	 * @return 傳回一個User物件
	 */
	public static User addNewUser(String name, String address, String phoneNumber,
			String education) {

		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setPhoneNumber(phoneNumber);
		user.setEducation(education);

		return user;
	}

}
