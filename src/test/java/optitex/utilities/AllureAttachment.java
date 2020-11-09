package optitex.utilities;

import io.qameta.allure.Attachment;

public class AllureAttachment {
	@Attachment(value = "log", type = "text/plain", fileExtension = ".txt")
	public static String attachText(String message) {
		return message;
	}

	@Attachment(value = "URL attachment", type = "text/uri-list", fileExtension = ".uri")
	public static void attachURL(String url) {
		System.out.println(url);
	}
}
