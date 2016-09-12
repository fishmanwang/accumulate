package com.accumulate.base.constant;

/**
 * @author jintao
 * 
 *         公共系统常量定义类
 * 
 */
public class CommonConstants {
	
	public static class Sort {
		public static final String ASC = "asc";
		public static final String DESC = "desc";
	}
	
	public static final int ZERO = 0;
	public static final int ONE = 1;

	/**
	 * 系统配置bean的name
	 */
	public static final String EP_CONFIG = "epConfig";
	public static final String CURRENT_USER = "currentUser";
	public static final String USERNAME = "username";
	public static final String EMAIL = "email";

	/**
	 * common status
	 */
	public static final String STATUS_PENDING = "pending";
	public static final String STATUS_APPROVE = "approve";
	public static final String STATUS_REJECT = "reject";
	public static final String DISABLED = "DISABLED";
	public static final String ENABLED = "ENABLED";

	/**
	 * date
	 */
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";
	public static final String TIME_STATUS_FUTURE = "future";
	public static final String TIME_STATUS_INPROGRESS = "inprogress";
	public static final String TIME_STATUS_FINISHED = "finished";

	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_FORMAT_SIMPLE = "yyyy-MM-dd";
	public static final String TIME_FORMAT_ZONE = "yyyy-MM-dd HH:mm:ss zzz";
	public static final String TIME_FORMAT_JS = "MMM d, yyyy hh:mm:ss";
	public static final String DATE_FORMAT_SLASH = "MM/dd/yyyy";
	public static final String DATE_FORMAT_HYPHEN = "MM-dd-yyyy";

	public static final String YEAR_PARAM = "year";
	public static final String MONTH_PARAM = "month";
	public static final String DAY_PARAM = "day";

	public static final String TRIGGERNAME = "triggerName";
	public static final String TRIGGERGROUP = "triggerGroup";
	public static final String STARTTIME = "startTime";
	public static final String ENDTIME = "endTime";
	public static final String REPEATCOUNT = "repeatCount";
	public static final String REPEATINTERVEL = "repeatInterval";

	public static final String ALL = "all";
	public static final String TYPE = "type";
	public static final String COUNT = "count";
	public static final String STATUS = "status";

	/**
	 * common properties
	 */
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String USER = "user";
	public static final String READABLE_ID = "readableId";
	public static final String DISPLAY_NAME = "displayName";
	public static final String PROFILE_ID = "profileId";
	public static final String URL = "url";
	public static final String CITY = "city";

	/**
	 * common sign
	 */
	public static final String BLANK = "";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String AND = "&";
	public static final String OR = "|";
	public static final String PLUS = "+";
	public static final String EQUAL = "=";
	public static final String ASTERISK = "*";
	public static final String COLON = ":";
	public static final String SEMICOLON = ";";
	public static final String ELLIPSIS = "...";
	public static final String BLANK_SPACE_HTML = "&nbsp;";
	public static final String AT = "@";
	public static final String COMMA = ",";
	public static final String SLASH = "/";
	public static final String UNDER_LINE = "_";
	public static final String HYPHEN = "-"; // 连字符
	public static final String DASH = "——"; // 破折号

	/**
	 * shipping status
	 */
	public static final String INITIAL = "initial";
	public static final String PENDING_SHIPMENT = "pending_shipment";
	public static final String NO_PENDING_ACTION = "no_pending_action";

	/**
	 * login related
	 */
	public static final String COOKIE_SOMPLE_SHOP = "SOMPLE_SHOP";
	public static final String COOKIE_VERIFYUSER = "verifyUser";
	public static final String RESPONSE = "response";
	public static final String REMEMBER_USERNAME = "rememberUsername";
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	/**
	 * http
	 */
	public static final String HTTP_METHEOD_POST = "POST";
	public static final String HTTP_RESPONSE = "response";
	public static final String HTTP_SET_COOKIE = "Set-Cookie";
	public static final String REQUEST_SUFFIX = ".html";

	/**
	 * 操作类型
	 */
	public static final String ACTION_PARAM = "action";
	public static final String EDIT_ACTION = "edit";
	public static final String UPDATE_ACTION = "update";
	public static final String ADD_ACTION = "add";
	
	/**
	 * 支付方式
	 */
	public static final String PAYMENT_METHOD_ALIPAY = "alipay";
	public static final String PAYMENT_METHOD_ONLINE = "online";
	public static final String PAYMENT_METHOD_TENPAY = "tenpay";
	public static final String PAYMENT_METHOD_COD = "cod";

}
