package org.lzj.poa.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

@SuppressWarnings("all")
public class DateConverter extends StrutsTypeConverter {
	
	private static Logger log = Logger.getLogger(DateConverter.class);
	private static final String  DATE_FORMAT_DAY = "yyyy-MM-dd";
	private static final String  DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

	@Override
	public Object convertFromString(Map content, String[] values, Class toClass) { 
		Date date = null;
		String dateString = null;
		if(values !=null && values.length > 0){
			dateString = values[0];
			SimpleDateFormat sdf =  new SimpleDateFormat(DATE_FORMAT_DAY);
			try {
				sdf.parse(dateString);
			} catch (ParseException e) {
				date = null;
				log.error("convert date failed!", e);
			}
			if(null == date){
				sdf = new SimpleDateFormat(DATE_FORMAT_TIME);
				try {
					sdf.parse(dateString);
				} catch (ParseException e) {
					date = null;
					log.error("convert date failed!", e);
				}
			}
		}
		return date;
	}

	@Override
	public String convertToString(Map content, Object obj) {
		String dateString = "";
		if(obj instanceof org.lzj.poa.entity.User){
			System.out.println("1111111111111111111111111111");
		}
		if(obj instanceof Date){
			SimpleDateFormat sdf =  new SimpleDateFormat(DATE_FORMAT_TIME);
			dateString = sdf.format((Date)obj);
		}
		return dateString;
	}

}
