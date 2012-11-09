package com.rarnu.zoe.loving;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Config {

	public static final String TOKEN = "b83b2cb9049ed3141ad282578bd9da0b";
	public static final String SECRET_TOKEN = "33818b0bdc0f29ba5796163affc42073";
	
	public static final String FIRST_START = "first_start";
	private static final String HINT_ENABLED = "hint%d_enabled";
	private static final String HINT_TIME = "hint%d_time";

	private static SharedPreferences sp = null;
	private static void initSharedPreference(Context context) {
		if (sp == null) {
			sp = PreferenceManager.getDefaultSharedPreferences(context);
		}
	}
	
	public static boolean getFirstStart(Context context) {
		initSharedPreference(context);
		return sp.getBoolean(FIRST_START, true);
	}
	
	public static void setFirstStart(Context context, boolean value) {
		initSharedPreference(context);
		sp.edit().putBoolean(FIRST_START, value).commit();
	}
	
	public static boolean getHintEnabled(Context context, int index) {
		initSharedPreference(context);
		String key = String.format(HINT_ENABLED, index);
		return sp.getBoolean(key, false);
	}
	
	public static void setHintEnabled(Context context, int index, boolean enabled) {
		initSharedPreference(context);
		String key = String.format(HINT_ENABLED, index);
		sp.edit().putBoolean(key, enabled).commit();
	}
	
	public static long getHintTime(Context context, int index, long def) {
		initSharedPreference(context);
		String key = String.format(HINT_TIME, index);
		return sp.getLong(key, def);
	}
	
	public static void setHintTime(Context context, int index, long value) {
		initSharedPreference(context);
		String key = String.format(HINT_TIME, index);
		sp.edit().putLong(key, value).commit();
	}
}
