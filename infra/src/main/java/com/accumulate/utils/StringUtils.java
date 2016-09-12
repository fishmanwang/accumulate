package com.accumulate.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * @author jintao
 * 
 */
public class StringUtils {

	// Empty checks
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if a CharSequence is empty ("") or null.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("bob")     = false
	 * StringUtils.isEmpty("  bob  ") = false
	 * </pre>
	 * 
	 * <p>
	 * NOTE: This method changed in Lang version 2.0. It no longer trims the
	 * CharSequence. That functionality is available in isBlank().
	 * </p>
	 * 
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is empty or null
	 * @since 3.0 Changed signature from isEmpty(String) to
	 *        isEmpty(CharSequence)
	 */
	public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty ("") and not null.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.isNotEmpty(null)      = false
	 * StringUtils.isNotEmpty("")        = false
	 * StringUtils.isNotEmpty(" ")       = true
	 * StringUtils.isNotEmpty("bob")     = true
	 * StringUtils.isNotEmpty("  bob  ") = true
	 * </pre>
	 * 
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null
	 * @since 3.0 Changed signature from isNotEmpty(String) to
	 *        isNotEmpty(CharSequence)
	 */
	public static boolean isNotEmpty(CharSequence cs) {
		return !StringUtils.isEmpty(cs);
	}

	/**
	 * <p>
	 * Checks if a CharSequence is whitespace, empty ("") or null.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 * 
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is null, empty or whitespace
	 * @since 2.0
	 * @since 3.0 Changed signature from isBlank(String) to
	 *        isBlank(CharSequence)
	 */
	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty (""), not null and not whitespace
	 * only.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.isNotBlank(null)      = false
	 * StringUtils.isNotBlank("")        = false
	 * StringUtils.isNotBlank(" ")       = false
	 * StringUtils.isNotBlank("bob")     = true
	 * StringUtils.isNotBlank("  bob  ") = true
	 * </pre>
	 * 
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null and
	 *         not whitespace
	 * @since 2.0
	 * @since 3.0 Changed signature from isNotBlank(String) to
	 *        isNotBlank(CharSequence)
	 */
	public static boolean isNotBlank(CharSequence cs) {
		return !StringUtils.isBlank(cs);
	}

	public static String nullSafeString(String value) {
		return value == null ? "" : value;
	}

	public static String trim(String value) {
		return trim(3, value, new char[] { ' ' });
	}

	public static String trim(String value, char[] chars) {
		return trim(3, value, chars);
	}

	public static String trimStart(String value, char[] chars) {
		return trim(1, value, chars);
	}

	public static String trimEnd(String value, char[] chars) {
		return trim(2, value, chars);
	}

	private static String trim(int mode, String value, char[] chars) {
		if ((value == null) || (value.length() <= 0)) {
			return value;
		}
		int startIndex = 0;
		int endIndex = value.length();
		int index = 0;
		if (mode != 1) {
			if (mode != 3)
				;
		} else {
			while (index < endIndex) {
				if (!contains(chars, value.charAt(index++)))
					break;
				startIndex++;
			}

		}

		if (startIndex >= endIndex) {
			return "";
		}
		if ((mode == 2) || (mode == 3)) {
			index = endIndex - 1;
			while (index >= 0) {
				if (!contains(chars, value.charAt(index--)))
					break;
				endIndex--;
			}

		}

		if (startIndex >= endIndex)
			return "";
		if ((startIndex == 0) && (endIndex == value.length() - 1)) {
			return value;
		}
		return value.substring(startIndex, endIndex);
	}

	private static boolean contains(char[] chars, char chr) {
		if ((chars == null) || (chars.length <= 0))
			return false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == chr)
				return true;
		}
		return false;
	}

	public static boolean isEmail(String email) {
		boolean flag = false;
		try {
			if (email == null) {
				return flag;
			}

			email = email.replaceAll(" ", "");
			if ("".equals(email)) {
				return flag;
			}

			flag = match(
					"^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",
					email);
		} catch (Exception e) {
			return false;
		}
		return flag;
	}

	public static boolean isMobile(String phone) {
		boolean flag = false;
		try {
			if (phone == null) {
				return flag;
			}

			phone = phone.replaceAll(" ", "");
			if ("".equals(phone)) {
				return flag;
			}

			flag = match("^1[3|4|5|8]\\d{9}$", phone);
		} catch (Exception e) {
			return false;
		}
		return flag;
	}

	/**
	 * 判断是否为整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * 判断是否为正整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isPositiveInteger(String str) {
		Pattern pattern = Pattern.compile("^[1-9]\\d*$");//^[1-9]\d*|0$ //非负整数（正整数+0）
		return pattern.matcher(str).matches();
	}

	public static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 根据匹配的字符串match 分割原字符串，然后返回前半部分 Examples: <blockquote>
	 * 
	 * <pre>
	 * substringBefore("123456789", "456") returns "123"
	 * <blockquote>
	 * 
	 * <pre>
	 * 
	 * @return
	 */
	public static String substringBefore(String value, String match) {
		if (StringUtils.isBlank(value)) {
			return value;
		}
		int index = value.indexOf(match);
		if (index > -1) {
			value = value.substring(0, index);
		}
		return value;
	}

	/**
	 * 根据匹配的字符串match 分割原字符串，然后返回后半部分 <br>
	 * Examples: <br>
	 * substringAfter("123456789", "456") returns "789"
	 */
	public static String substringAfter(String value, String match) {
		if (StringUtils.isBlank(value)) {
			return value;
		}
		int index = value.indexOf(match);
		if (index > -1) {
			value = value.substring(index + match.length());
		}
		return value;
	}

	public static int parseStringToInt(String stringValue, int defaultValue) {
		int intValue = 0;
		try {
			intValue = Integer.parseInt(stringValue);
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
		return intValue;
	}

	public static String toString(List<String> result) {
		if (result == null || result.size() == 0) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (String obj : result) {
			sb.append(obj).append(",");
		}
		sb = sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	/**
	 * 用于简单对象的toString。主要用于简化各个类的toString方法。
	 * 不要妄想通过该方法将一个复杂对象转换为完整的字符串，那是MapperObject做的事儿。
	 * 所有非static和final，并且提供getter方法的数据,都会生成出来。
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		// ToStringHelper helper =
		// getStringHelper(Optional.fromNullable((ToStringHelper)null), obj);
		// return helper.toString();
		ToStringHelper helper = MoreObjects.toStringHelper(obj.getClass());
		return getClassToStringHelper(helper, obj).toString();
	}

	/**
	 * 同上
	 * 
	 * @param shOpt
	 * @param obj
	 * @return
	 */
	public static String toString(Optional<ToStringHelper> shOpt, Object obj) {
		ToStringHelper helper = getStringHelper(shOpt, obj);
		return helper.toString();
	}

	/**
	 * 服务于toString。主要用与子类继承父类的stringHelper。
	 * 
	 * @param shOpt
	 * @param obj
	 * @return
	 */
	public static ToStringHelper getStringHelper(Optional<ToStringHelper> shOpt, Object obj) {
		Preconditions.checkArgument(obj != null);

		ToStringHelper helper = shOpt.or(MoreObjects.toStringHelper(obj));
		Field[] fs = obj.getClass().getDeclaredFields();
		for (Field f : fs) {
			int m = f.getModifiers();
			if (!Modifier.isStatic(m) && !Modifier.isFinal(m)) {
				PropertyDescriptor pd;
				try {
					pd = new PropertyDescriptor(f.getName(), obj.getClass());
					if (pd.getReadMethod() != null) {
						Method rd = pd.getReadMethod();
						Object val = rd.invoke(obj);
						if (val != null) {
							helper.add(f.getName(), val);
						}
					}
				} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return helper;
	}

	private static <T> ToStringHelper getClassToStringHelper(ToStringHelper helper, Object obj) {
		return getClassToStringHelper(helper, obj, obj.getClass());
	}

	@SuppressWarnings("rawtypes")
	private static <T> ToStringHelper getClassToStringHelper(ToStringHelper helper, Object obj, Class<T> clazz) {
		if (clazz.getSuperclass() != null) {
			getClassToStringHelper(helper, obj, clazz.getSuperclass());
		}

		if (Collection.class.isAssignableFrom(obj.getClass())) {
			helper.addValue(obj);
		} else {
			Field[] fs = clazz.getDeclaredFields();
			for (Field f : fs) {
				int m = f.getModifiers();
				if (!Modifier.isStatic(m) && !Modifier.isFinal(m) && !Modifier.isTransient(m)) {
					PropertyDescriptor pd;
					try {
						pd = new PropertyDescriptor(f.getName(), clazz);
						if (pd.getReadMethod() != null) {
							Method rd = pd.getReadMethod();
							Object val = rd.invoke(obj);
							if (val != null) {
								if (Collection.class.isAssignableFrom(val.getClass()) && ((Collection) val).isEmpty()) {
									continue;
								}
								if (Map.class.isAssignableFrom(val.getClass()) && ((Map) val).size() == 0) {
									continue;
								}
								helper.add(f.getName(), val);
							}
						}
					} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return helper;
	}
	
	/**
	 * 将字符串中包含正则表达式特殊符号字符转义，避免模糊查询时，以特殊符号方式处理字符。
	 * 例如：a*b 转义为 a\*b。
	 * @param keyword
	 * @return
	 */
	public static String escapeExprSpecialWord(String keyword) {
	    if (StringUtils.isNotBlank(keyword)) {  
	        String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };  
	        for (String key : fbsArr) {  
	            if (keyword.contains(key)) {  
	                keyword = keyword.replace(key, "\\" + key);  
	            }  
	        }  
	    }  
	    return keyword;  
	}
	
}
